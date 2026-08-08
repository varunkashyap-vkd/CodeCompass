<#
.SYNOPSIS
  Exports the runbook HTML to print-quality PDF.

.DESCRIPTION
  Uses headless Edge, which emits real vector text with embedded font subsets.
  Do NOT use the "Microsoft Print to PDF" printer — it rasterizes every page to
  JPEG, which blurs text and drops all font information.

.EXAMPLE
  .\tools\export-pdf.ps1
  .\tools\export-pdf.ps1 -Source part-1-theory.html
#>
param(
  [string]$Source,
  [string]$OutDir = "exports"
)

$ErrorActionPreference = "Stop"
$root = Split-Path $PSScriptRoot -Parent

$edge = @(
  "${env:ProgramFiles(x86)}\Microsoft\Edge\Application\msedge.exe",
  "$env:ProgramFiles\Microsoft\Edge\Application\msedge.exe",
  "$env:ProgramFiles\Google\Chrome\Application\chrome.exe"
) | Where-Object { Test-Path $_ } | Select-Object -First 1

if (-not $edge) { throw "Neither Edge nor Chrome was found. One of them is required for vector PDF export." }

$sources = if ($Source) { @(Join-Path $root $Source) } else { Get-ChildItem $root -Filter "part-*.html" | ForEach-Object { $_.FullName } }
$target = Join-Path $root $OutDir
New-Item -ItemType Directory -Force -Path $target | Out-Null

foreach ($src in $sources) {
  $name = [System.IO.Path]::GetFileNameWithoutExtension($src)
  $pdf = Join-Path $target "$name.pdf"
  $uri = "file:///" + ($src -replace '\\', '/')

  # Edge logs harmless noise to stderr, which would otherwise terminate the script.
  $prev = $ErrorActionPreference
  $ErrorActionPreference = "SilentlyContinue"
  & $edge --headless --disable-gpu --log-level=3 --no-pdf-header-footer --print-to-pdf="$pdf" $uri 2>&1 | Out-Null
  $ErrorActionPreference = $prev

  if (-not (Test-Path $pdf)) { throw "Export failed for $name" }

  # Fail loudly if fonts fell back or pages were rasterized.
  $latin1 = [System.Text.Encoding]::GetEncoding(28591)
  $raw = $latin1.GetString([System.IO.File]::ReadAllBytes($pdf))
  $fonts = [regex]::Matches($raw, '/FontName\s*/([#\w\+\-\.]+)') | ForEach-Object { $_.Groups[1].Value -replace '^\w{6}\+', '' } | Sort-Object -Unique
  $images = [regex]::Matches($raw, '/Subtype\s*/Image').Count
  $pages = [regex]::Matches($raw, '/Type\s*/Page[^s]').Count

  "$name.pdf  |  $pages pages  |  $([math]::Round((Get-Item $pdf).Length / 1KB, 1)) KB"
  "  fonts : $($fonts -join ', ')"

  if (-not ($fonts -like '*Inter*')) { Write-Warning "Inter is not embedded - check assets/fonts.css and the fonts/ folder." }
  if ($images -gt 4) { Write-Warning "$images image objects found - pages may have been rasterized." }
}
