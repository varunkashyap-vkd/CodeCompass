# The LLD Runbook — Styling Reference

> **How to use this file:** Paste or attach this document at the start of any session that
> creates or edits runbook pages. It is the single source of truth for typography, color,
> spacing and print behaviour. Individual page layouts are free to vary; the rules below are not.
>
> Scope: `lowleveldesign/` — a printable A4 HTML document exported to PDF.
> Inherits CodeCompass brand tokens from `/AI_CONTEXT.md`.

---

## 1. Design intent

This is a **dense technical reference**, not a landing page. The reader is preparing for an
interview and will re-read pages under time pressure. Optimise for scanning and information
density, not for impact.

The target feel is a well-set **technical handbook** — the visual language of a good O'Reilly
or Manning page, tinted with CodeCompass purple.

**Anti-goals — these make a page look AI-generated or salesy. Avoid all of them:**

| Avoid | Instead |
|---|---|
| Every block wrapped in a rounded, shadowed card | Hairline rules and left-edge accents |
| Large hero whitespace between sections | Tight, even rhythm (see §5) |
| Gradient text and glowing accents | Flat ink; gradient only on the cover |
| Pill badges scattered across the page | At most one label per section |
| Emoji as icons (🚀 ✅ 💡) | Text labels or nothing |
| Marketing voice: "Master X in minutes!" | Declarative, factual statements |
| Centre-aligned body text | Left-aligned, consistent measure |
| Three or more accent colours on one page | Purple plus at most one semantic colour |
| Drop shadows on inline elements | Shadow only on the page sheet itself |

**Density target:** roughly 20–25% whitespace. Volume 1's booklet used 30–40%; this document
is deliberately tighter because it carries far more text.

---

## 2. Page geometry

| Property | Value |
|---|---|
| Sheet | A4 portrait, 210mm × 297mm |
| Page padding | `14mm 15mm 12mm` (top, sides, bottom) |
| Live text width | ~180mm |
| `@page` margin | `0` (padding is handled by `.page`) |
| Column gutter | 7mm |
| Max line measure | ~95 characters; use two columns beyond that |

Every page is a `.page` element of fixed height. **Content must never overflow.** If it does,
cut words rather than shrinking type below the scale in §3.

Each page carries a thin running header (chapter name, left) and a footer (document name left,
page number right), separated from content by a 1px `--rule` hairline.

---

## 3. Typography

### Families

```
--font-sans: "Inter", "Segoe UI", system-ui, -apple-system, sans-serif;
--font-mono: "JetBrains Mono", "Cascadia Code", "Consolas", ui-monospace, monospace;
```

Inter for everything except code. No third family. No decorative or display fonts.

### Scale

Sizes are in `px` (deterministic at 96dpi when printing). The `pt` column is the physical
printed size, given for reference only.

| Role | Element | Size | pt | Weight | Line height | Tracking |
|---|---|---|---|---|---|---|
| Display *(cover only)* | `h1` | 44px | 33 | 800 | 1.05 | -0.02em |
| Page title | `h1` | 25px | 18.8 | 700 | 1.15 | -0.015em |
| Section | `h2` | 16.5px | 12.4 | 700 | 1.25 | -0.01em |
| Subsection | `h3` | 13.5px | 10.1 | 700 | 1.35 | 0 |
| Micro-label | `h4` | 10px | 7.5 | 600 | 1.2 | 0.09em, uppercase |
| Lead paragraph | `.lead` | 14px | 10.5 | 500 | 1.5 | 0 |
| Body | `p`, `li` | 12.5px | 9.4 | 400 | 1.55 | 0 |
| Table / compact | `td`, `.compact` | 11.5px | 8.6 | 400 | 1.45 | 0 |
| Caption / aside | `.caption` | 11px | 8.25 | 400 | 1.45 | 0 |
| Code block | `pre` | 11px | 8.25 | 400 | 1.5 | 0 |
| Inline code | `code` | 11.5px | 8.6 | 500 | inherit | 0 |
| Running head / footer | — | 9.5px | 7.1 | 500 | 1.3 | 0.02em |

### Rules

- Never introduce a size outside this table. If something needs emphasis, change **weight or
  colour**, not size.
- Maximum three heading levels visible on any single page. Four means the page is doing too much.
- `h4` micro-labels are for naming small blocks (`REQUIREMENTS`, `COMMON MISTAKES`). They replace
  card headers and keep the page flat.
- Bold within body text uses weight 600 and stays `--ink`. Bold is for terms, not enthusiasm.
- Body text is always left-aligned and never justified — justification creates rivers at this measure.
- Paragraphs are capped at four lines. Beyond that, convert to a list.

---

## 4. Colour

### Tokens

```css
/* Ink */
--ink:            #1A1735;  /* headings, body text */
--ink-soft:       #4B5563;  /* secondary text, labels, captions */
--ink-faint:      #8B8AA0;  /* running heads, page numbers, metadata */

/* Brand purple */
--primary:        #8A2BE2;  /* accents, links, active marks */
--primary-dark:   #5B21B6;  /* headings that need brand weight, emphasis */
--accent:         #A855F7;  /* secondary accent, cover gradient only */

/* Surfaces */
--paper:          #FFFFFF;  /* page background */
--surface:        #FAF8FD;  /* subtle block tint */
--surface-strong: #F3EEFA;  /* table header rows, code block background */

/* Lines */
--rule:           #E7E3F0;  /* hairlines, table borders, dividers */
--rule-strong:    #D9D2EA;  /* section dividers */

/* Semantic — desaturated so they never fight the purple */
--bad:            #A33A32;  /* anti-pattern, wrong approach */
--bad-bg:         #FBF3F2;
--good:           #1F7A5C;  /* corrected approach */
--good-bg:        #F1F8F5;
--note:           #8A2BE2;  /* interview tip, insight — reuses primary */
--note-bg:        #F8F4FD;
```

### Usage rules

- **Purple is an accent, not a theme.** On a typical text page it should appear only in the
  page title rule, `h2` markers, inline links and one callout. If a page looks purple from
  across the room, it is over-styled.
- Body text is always `--ink`. Never set body copy in purple or grey.
- `--bad` and `--good` appear **only** in code comparisons and never as large fills — a 2px
  left border plus a label is sufficient.
- Backgrounds carry a maximum of two tint levels per page.
- The gradient (`--primary` → `--accent`) is permitted **only on the cover**.
- Links print as `--primary-dark` with no underline in headings, underlined in body text.

---

## 5. Spacing and rhythm

A **4px base scale**. Only these values:

```
2, 4, 6, 8, 12, 16, 20, 24, 32
```

| Relationship | Space |
|---|---|
| Page title → first section | 16px |
| Between sections (`h2` blocks) | 20px |
| `h2` → its content | 8px |
| `h3` → its content | 6px |
| Between paragraphs | 8px |
| Between list items | 4px |
| Inside a bordered block | 10px 12px |
| Block → following text | 12px |
| Content → footer rule | 12px minimum |

Rhythm matters more than generosity: equal gaps repeated down the page read as intentional,
while varied gaps read as sloppy regardless of how much air there is.

---

## 6. Surfaces, borders, dividers

| Property | Value |
|---|---|
| Radius | `4px` standard, `3px` for code and inline chips |
| Border | `1px solid var(--rule)` |
| Accent edge | `2px solid` on the **left** only |
| Shadow | **None**, except the page sheet on screen |
| Section divider | `1px solid var(--rule)`, full measure |

Small radii are deliberate — 16px rounding reads as web UI, 4px reads as print.

Prefer, in order: **plain text → text with a micro-label → left accent rule → tinted block →
fully bordered block.** Reach for the heaviest treatment only when a block must be visually
separable at a glance.

Maximum **two** tinted or bordered blocks per page. More turns the page into a dashboard.

---

## 7. Code

- Font `--font-mono`, 11px, line height 1.5.
- Background `--surface-strong`, radius 3px, padding `8px 10px`, no border.
- **Maximum 12 lines.** Show only the decisive part; link full source with a repo chip.
- No line numbers. No traffic-light window chrome. No filename tab bars.
- Syntax colouring is restrained: keywords `--primary-dark`, strings `--good`, comments
  `--ink-faint` italic, everything else `--ink`. Never colour more than three token types.
- Comparison blocks stack or sit side by side with a `--bad` / `--good` left edge and an
  `h4` micro-label (`ANTI-PATTERN` / `BETTER`). No red or green fills beyond `--bad-bg` / `--good-bg`.

**Repo chip:** inline element, 11px, mono, `--primary-dark` text, 1px `--rule` border,
radius 3px, padding `2px 6px` — used for "full implementation" links.

---

## 8. Diagrams

- Built from **HTML boxes plus inline SVG connectors**. No JavaScript, no runtime rendering.
- Class boxes: 1px `--rule` border, radius 4px, name in `h3` size 600 weight on a
  `--surface-strong` header strip, members in 11px mono below, separated by a hairline.
- Connectors: 1px `--ink-soft` lines. UML arrowheads only — hollow triangle for inheritance,
  open arrow for association, diamond for composition. No curves or decorative paths.
- Diagram labels 10px, `--ink-soft`.
- Diagrams are monochrome plus at most one purple highlight for the element under discussion.
- Every diagram gets an 11px caption below it.

---

## 9. Print and PDF

```css
@page { size: A4 portrait; margin: 0; }
```

- `.page` uses fixed `210mm × 297mm`; padding provides the margin.
- `break-inside: avoid` and `page-break-inside: avoid` on every block, table and diagram.
- `break-after: page` on each `.page`.
- `print-color-adjust: exact` and `-webkit-print-color-adjust: exact` globally, or tints drop out.
- On screen, `.page` has a `box-shadow` and grey body background; both are removed in `@media print`.
- All pages of a part live in **one HTML file** so the export produces a single, correctly
  paginated PDF.
- Fonts must be self-hosted or preloaded — a Google Fonts fetch that fails at print time
  silently changes every measurement in §3.

---

## 10. Naming conventions

BEM-style, matching Volume 1:

```
.page                 .page__header      .page__footer     .page__num
.block                .block__label      .block__body
.u-*                  utility classes (spacing, alignment)
```

- Semantic block names describing role, not appearance: `.requirements`, `.mistakes`,
  `.diagram` — never `.purple-box` or `.left-column`.
- Modifiers with `--`: `.note--bad`, `.note--good`.
- All tokens declared once in `:root` in `assets/runbook.css`. **No hard-coded hex values or
  font sizes in page markup.**

---

## 11. Token block — copy into `assets/runbook.css`

```css
:root {
  /* Type */
  --font-sans: "Inter", "Segoe UI", system-ui, -apple-system, sans-serif;
  --font-mono: "JetBrains Mono", "Cascadia Code", "Consolas", ui-monospace, monospace;

  --fs-display: 44px;
  --fs-h1:      25px;
  --fs-h2:      16.5px;
  --fs-h3:      13.5px;
  --fs-label:   10px;
  --fs-lead:    14px;
  --fs-body:    12.5px;
  --fs-compact: 11.5px;
  --fs-caption: 11px;
  --fs-code:    11px;
  --fs-micro:   9.5px;

  --lh-tight: 1.2;
  --lh-head:  1.25;
  --lh-body:  1.55;

  /* Colour */
  --ink: #1A1735;
  --ink-soft: #4B5563;
  --ink-faint: #8B8AA0;

  --primary: #8A2BE2;
  --primary-dark: #5B21B6;
  --accent: #A855F7;

  --paper: #FFFFFF;
  --surface: #FAF8FD;
  --surface-strong: #F3EEFA;

  --rule: #E7E3F0;
  --rule-strong: #D9D2EA;

  --bad: #A33A32;
  --bad-bg: #FBF3F2;
  --good: #1F7A5C;
  --good-bg: #F1F8F5;
  --note: #8A2BE2;
  --note-bg: #F8F4FD;

  /* Space */
  --s-1: 2px;  --s-2: 4px;  --s-3: 6px;  --s-4: 8px;
  --s-5: 12px; --s-6: 16px; --s-7: 20px; --s-8: 24px; --s-9: 32px;

  /* Geometry */
  --radius: 4px;
  --radius-sm: 3px;
  --page-w: 210mm;
  --page-h: 297mm;
  --page-pad-y: 14mm;
  --page-pad-x: 15mm;
  --gutter: 7mm;
}
```

---

## 12. Pre-flight checklist

Before any page is considered done:

- [ ] Fits one A4 sheet with no overflow and no clipped content
- [ ] Every font size traces to the §3 scale
- [ ] Every colour traces to a §4 token; no raw hex in markup
- [ ] Every gap traces to the §5 scale
- [ ] At most two tinted or bordered blocks
- [ ] At most three heading levels
- [ ] No emoji, no gradient (cover excepted), no shadows on content
- [ ] Code blocks ≤ 12 lines
- [ ] Running head and page number present and correct
- [ ] Print preview matches screen — tints intact, nothing reflowed
