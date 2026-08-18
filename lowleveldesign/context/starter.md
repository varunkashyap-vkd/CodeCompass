# The LLD Runbook — Session Starter

> **Use this as the only entry point for future sessions.** Tell the agent: “Develop the LLD
> Runbook context from `lowleveldesign/context/starter.md`, then work on …” The agent must follow
> the loading protocol below before planning or editing.

---

## 1. What this project is

**The LLD Runbook** is a premium, printable CodeCompass interview-preparation product for engineers
preparing for low-level design rounds at big-tech companies. It is a practical technical handbook,
not a web application, marketing page, pattern encyclopaedia, or collection of model answers.

It ships as two standalone A4 PDFs:

- **Part 1 — Theory and Principles:** the vocabulary, judgement, patterns, and five-question
  framework used to solve an LLD interview.
- **Part 2 — Problems:** ten chronological interview case studies that visibly apply that framework
  and show what happens when the requirement changes.

The product promise is understanding over memorisation. Content should sound like an experienced
mentor reconstructing real decisions, including uncertainty and correction, rather than presenting
an answer that appeared fully formed.

---

## 2. Source-of-truth order

When two files disagree, use this precedence:

1. `context/document-map.md` — structure, section status, page allocation, and binding content brief.
2. The task-specific contract:
   - `context/part-2-problem-blueprint.md` for any Part 2 problem.
   - `context/style-reference.md` for all visual, layout, typography, and print decisions.
3. `../part-1-theory.html` and `../part-2-problems.html` — current implementation.
4. `context/interview-notes.md` — factual source for personal stories; it overrides invented or
   inferred narrative details, but it does not override the structural map.
5. `context/document-structure.txt` — historical intent only; it is superseded by the map.
6. `../../AI_CONTEXT.md` — repository-wide CodeCompass brand principles. The runbook styling
   reference narrows those principles for this document and wins where the medium requires it.

Never silently resolve a structural disagreement in HTML. Update the map first, then implementation.

---

## 3. Loading protocol

### Core context — read for every runbook task

Read these files in order:

1. This starter completely.
2. `../../AI_CONTEXT.md` for brand, voice, and educational philosophy.
3. `context/document-map.md` for current structure and status.
4. `context/style-reference.md` for the print design contract.

After loading them, briefly state:

- Which part, section, page, or cross-document concern owns the requested work.
- Its current status in the map.
- The nearest implemented source file.
- Any dependency or contradiction that must be resolved before editing.

Do not map the entire repository when these files already identify the owning surface.

### Conditional context — read only when relevant

| Task | Additional files to read |
|---|---|
| Any Part 1 content or structure | Relevant section in `../part-1-theory.html`; neighbouring section only when needed for continuity. |
| Any Part 2 problem | `context/part-2-problem-blueprint.md`, relevant section of `context/interview-notes.md`, then the nearest completed problem in `../part-2-problems.html`. |
| Part 2 problem selection or page allocation | `context/part-2-problem-blueprint.md`, all available problem notes, and the Part 2 table in the map. |
| Cover, contents, index, or cross-part navigation | Both relevant front-matter regions in the HTML plus the complete map. |
| Personal interview story | Relevant notes section. Never infer missing facts; ask the author for them. |
| CSS, page layout, diagram, or typography | Relevant portion of `../assets/runbook.css` after reading the styling reference. |
| PDF, overflow, fonts, or print validation | `../tools/export-pdf.ps1`, relevant CSS print rules, and the rendered page. |
| Historical rationale | `context/document-structure.txt`; use only to explain intent, never to reverse a newer map decision. |

### Do not load by default

- Exported PDFs, unless visually reviewing the artifact.
- All of either HTML file when the map identifies a narrow section.
- Font binaries.
- Unrelated CodeCompass products.
- Historical session logs.

The goal is complete governing context, not maximum file volume.

---

## 4. Non-negotiable product decisions

- The runbook is one HTML file per part, with one fixed A4 `.page` element per printed page.
- **Part 1 is frozen at 29 pages and signed off.** Do not edit `../part-1-theory.html`, the pattern
  page template in section 7 of the map, or any Part 1 row or rationale. Part 2 work never justifies
  a Part 1 edit; if Part 2 appears to need one, raise it with the author instead.
- Part 2 case studies default to three pages — the brief, the model, the change — with the proof
  split onto its own page when the trace and the class design will not share one.
- `assets/runbook.css` is shared by both parts. Add new class names for Part 2 work rather than
  changing rules Part 1 already uses.
- Part 2 is an interview casebook, not a compressed answer catalogue.
- Every Part 2 problem visibly applies the five questions from Part 1 section 6.1:
  1. What am I actually building?
  2. What are the things?
  3. Who owns what?
  4. What will change?
  5. Does it actually work?
- Every changed requirement applies the four moves from Part 1 section 6.2:
  1. Restate it.
  2. Say where it lands.
  3. Say what changes and what remains stable.
  4. If it does not fit, say so and name the missing seam.
- A Part 2 problem receives three pages. A fourth page must perform distinct teaching
  work under the blueprint rubric; fame, ordering, and personal provenance do not earn space.
- Every Part 2 page is built against the block spine in blueprint section 5. A page carries at most
  four structural blocks and two tables, and the narrator argues in prose between them.
- Part 2 page titles make a claim; the running header already names the leg of the case.
- The baseline design must appear before the evolved design.
- A pattern is introduced only after the narrative establishes the pressure that earns it.
- Personal stories use only author-supplied facts. Never name a company.
- Complete code links are supplementary. The printed explanation must stand on its own.
- Structural changes are made in the map before HTML.

---

## 5. Voice and teaching standard

The reader is intelligent and technically experienced enough to interview at SDE-II or SDE-III
level, but may not yet have reliable LLD instincts.

Write with these qualities:

- Professional, friendly, confident, practical, and concise.
- Specific enough to expose reasoning, including false assumptions and recovery.
- Beginner-friendly without flattening technical trade-offs.
- Mentor-like, never promotional or motivational.
- Chronological when reconstructing interviews.

Use first person only for verified experience, neutral exposition for technical reasoning, and
second person for coaching. Avoid buzzwords, inflated claims, excessive polish, generic pattern
advice, and walls of text.

A strong page answers “why did this design decision become necessary?” A weak page merely names
entities, relationships, patterns, and complexity in separate boxes.

---

## 6. Visual and implementation standard

The exact rules live in `context/style-reference.md`; this summary is only an orientation layer.

- Dense technical handbook, around 20–25% whitespace.
- A4 portrait, deterministic print layout, no overflow.
- Self-hosted Inter and JetBrains Mono fonts.
- Purple is an accent, not a page-wide theme.
- Flat hierarchy, hairline rules, small radii, no decorative card grid.
- HTML boxes plus inline SVG for diagrams; no JavaScript or Mermaid.
- Focused Java excerpts, normally no more than 12 lines each.
- Diagrams preserve chronology and use dashed styling only for genuinely later elements.
- Page furniture and total page counts must match the map.
- Use `../tools/export-pdf.ps1` as the only supported export path.
- Never use Microsoft Print to PDF; it rasterises the document.

Validate content and technical correctness before cutting words for page fit.

---

## 7. Task routing

### Editing Part 1

1. Locate the section in the map and read its binding brief.
2. Read that HTML page and enough of its neighbour to preserve continuity.
3. Check whether the change affects the five-question framework or a Part 2 dependency.
4. Update the map first for any structural or brief change.
5. Edit the HTML, validate page fit, then export Part 1.

### Starting or editing a Part 2 problem

1. Read the problem row in the map.
2. Read the complete Part 2 blueprint.
3. Read the corresponding interview notes.
4. Complete or review the commissioning brief before layout.
5. Resolve missing personal facts with the author; do not manufacture them.
6. Establish the chronological interview spine and map evidence to all five questions.
7. Decide three versus four pages using the rubric and record the reason in the map.
8. Build baseline before evolution, then validate content, page fit, links, and export.

### Editing contents or index pages

1. Treat the map as the only source for titles, order, status, and pagination.
2. Remember that preview pages must show the complete product, not a compressed chapter list.
3. Recalculate every affected page number and footer after structural changes.
4. Validate both the index and all affected page furniture.

### Styling or layout changes

1. Determine whether the request changes the shared design contract or only one page.
2. Update `context/style-reference.md` first when the contract changes.
3. Reuse existing classes and tokens before adding an abstraction.
4. Test representative pages from both parts when changing shared CSS.

### Export and release checks

1. Run the supported export script.
2. Confirm expected page count, embedded Inter/JetBrains Mono fonts, and low image-object count.
3. Inspect A4 fit and clipping in the rendered document.
4. Verify contents, page furniture, links, and total-page labels against the map.

---

## 8. Current project state

Use the map for the live status; this section is a quick orientation and must be updated when the
project crosses a major milestone.

- Part 1 is complete at 29 pages and frozen.
- Part 1 sections 6.1 and 6.2 establish the framework reused by Part 2.
- Part 2 targets 35 pages: cover, contents, ten case studies, and two closing pages.
- Built so far: cover, contents, and the LRU case study on pages 3–6.
- LRU is a four-page case built against blueprint section 5. Its legs are the brief, the model,
  the proof, and the change. It fits A4 and exports cleanly; it is pending author review.
- Problem titles P3–P10 in the contents are placeholders until each brief is written.
- HashMap is blocked on the author completing its interview notes.
- Problems P3–P10 are not yet selected, and their contents grouping is provisional.
- Part 2 page numbers beyond P1 are intentionally provisional.
- The preview index cannot be finalised until the problem lineup and page allocations are locked.

---

## 9. Maintenance rules for context files

Context is part of the product and must not drift behind implementation.

- Update `context/document-map.md` whenever structure, status, title, page count, or a binding brief changes.
- Update `context/style-reference.md` whenever a shared visual or print rule changes.
- Update `context/part-2-problem-blueprint.md` only when the contract for all problems changes, not
  to accommodate one awkward draft.
- Keep raw factual interview input in `context/interview-notes.md`; preserve the author’s rough voice.
- Update this starter only when file locations, precedence, loading protocol, locked decisions, or
  major project status changes.
- Keep `context/document-structure.txt` historical. Do not modernise it into a second map.
- When moving or renaming a context file, update this starter, all internal references, CSS comments,
  repository documentation, and repository memory in the same change.

Before ending any substantial editing session, check whether the map and this starter still tell a
future agent the truth.

---

## 10. Suggested future-session prompt

> Develop the complete LLD Runbook context from
> `lowleveldesign/context/starter.md`. Then work on **[section/problem/task]**. Follow the source-of-truth
> order and report any blocker or structural contradiction before editing.
