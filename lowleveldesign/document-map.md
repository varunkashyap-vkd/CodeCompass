# The LLD Runbook — Document Map

> **How to use this file:** This is the structural source of truth for the runbook. Attach it,
> together with `style-reference.md`, at the start of any session that builds or edits pages.
>
> To commission work, name a **section number** — "build 5.4" — not a page number. Section
> numbers are stable; page numbers shift whenever a page is added or split.
>
> After any structural change, update this file **first**, then the pages. If this file and the
> HTML disagree, this file wins.

**Related files**

| File | Role |
|---|---|
| `document_structure.txt` | The original outline. Historical intent; superseded by this map. |
| `style-reference.md` | Typography, colour, spacing, print rules. Non-negotiable. |
| `part-1-theory.html` | All Part 1 pages, one file. |
| `part-2-problems.html` | All Part 2 pages, one file. |
| `tools/export-pdf.ps1` | The only supported PDF export path. |

---

## 1. Product shape

Two standalone PDFs, each self-contained and each within a 25-page budget.

| | Pages | Purpose |
|---|---|---|
| **Part 1 — Theory and Principles** | 26 | Vocabulary, principles, patterns, and a solving framework. |
| **Part 2 — Problems** | 24 | Ten problems worked end to end, two pages each. |

Part 1 is read once, front to back. Part 2 is the working half, and is where readers return.

**Preview pages.** When these are sold as digital products, pages 1 and 2 (cover and contents)
are the free preview. The contents page therefore has to be complete rather than summarised —
it is what a buyer inspects before paying. Do not compress it back into a chapter list.

---

## 2. Numbering scheme

- **Two levels only.** `chapter.section`, for example `3.2`. Never `3.2.1`.
- **One section = one printed page.** The page is the atomic unit of this document.
- Sub-topics within a page are unnumbered `h3` headings.
- Front matter (cover, how-to-use) carries no section number.
- If a section outgrows its page, split it into `x.y` and `x.y+1` and renumber the rest of the
  chapter **in this file first**.

### Page furniture

Every content page carries three orientation signals:

| Position | Content | Example |
|---|---|---|
| Header, left | Chapter number and name | `Chapter 1 · What LLD actually is` |
| Header, right | Section number | `Section 1.2` |
| Title | Section number, then title | `1.2  Four rounds that get confused` |
| Footer, left | Document and part | `CodeCompass · The LLD Runbook · Part 1` |
| Footer, right | Absolute position | `Page 4 of 26` |

The `of 26` is deliberate. It bounds the document so it never feels open-ended.

---

## 3. Status legend

| Mark | Meaning |
|---|---|
| **done** | Built, fits A4, reviewed. |
| **draft** | Built but not yet reviewed or signed off. |
| **todo** | Planned, not yet written. |
| **blocked** | Needs input from the author (an anecdote, a decision). |

---

## 4. Part 1 — Theory and Principles

| § | Page | Title | Status | Brief |
|---|---|---|---|---|
| — | 1 | Cover | done | Title, subtitle, positioning paragraph, author, edition. **Preview page.** |
| — | 2 | Contents | done | Full index: all six chapters, all 23 sections, grouped with page numbers. **Preview page.** |
| — | 3 | How to use this runbook | done | Framing, assumptions, exclusions, three reading paths, note on code links. |
| 1.1 | 4 | What LLD actually is | done | Definition as modelling plus defending. Where it shows up. What changes by level. |
| 1.2 | 5 | Four rounds that get confused | done | DSA / LLD / machine coding / HLD table. The gear shift. Where the LLD–HLD line sits. |
| 1.3 | 6 | What's actually being evaluated | done | Five scorecard items. How strong DSA candidates lose. What a good sentence sounds like. |
| 2.1 | 7 | Encapsulation | done | Who is allowed to mutate state. Cart example: derived totals and defensive copies. Naming the invariant. |
| 2.2 | 8 | Abstraction | done | Hiding decisions, not data. SMTP leaking into OrderService. Interface versus abstract class. Naming the technology as the leak tell. |
| 2.3 | 9 | Inheritance | done | `Stack extends ArrayList` inherits the whole API. Composition fix. The three conditions for inheriting. |
| 2.4 | 10 | Polymorphism | done | The growing switch and its siblings. PaymentMethod interface. When a switch is still right. Forward links to 3.2 and 5.2. |
| 3.1 | 11 | Single Responsibility | todo | "One reason to change." God-class anti-pattern, the fix, and the opposite failure of splitting too far. |
| 3.2 | 12 | Open/Closed | todo | Extension without modification. Enum-plus-switch refactored toward Strategy. Forward reference to 5.2. |
| 3.3 | 13 | Liskov Substitution | todo | Subtype contracts and preconditions. A realistic violation, not the Rectangle/Square cliché. |
| 3.4 | 14 | Interface Segregation | todo | Fat interfaces forcing empty implementations. Role interfaces as the fix. |
| 3.5 | 15 | Dependency Inversion | todo | Depend on abstractions. Constructor injection. Wiring at the edge, not in the middle. |
| 4.1 | 16 | KISS, DRY and YAGNI | todo | The three restraint principles, plus the honest counterpoint that DRY is the most over-applied idea in LLD. |
| 4.2 | 17 | Composition over inheritance | todo | The same requirement solved both ways, side by side, with the extension test applied to each. |
| 4.3 | 18 | Interfaces and immutability | todo | Program to interfaces; favour immutability. Value objects, defensive copies, thread safety by construction. |
| 5.1 | 19 | Choosing a pattern | todo | Symptom-to-pattern decision map. Explicit warning against pattern-dropping. Sets up the chapter. |
| 5.2 | 20 | Strategy | todo | Intent, class diagram, short snippet, interview usage, common mistakes. |
| 5.3 | 21 | Factory | todo | Same template. Factory method versus abstract factory, and when the distinction matters. |
| 5.4 | 22 | Observer | todo | Same template. Push versus pull, and listener lifecycle. |
| 5.5 | 23 | Singleton | todo | Same template. Thread safety, and why interviewers often treat it as a trap. |
| 5.6 | 24 | Builder and Decorator | todo | Two patterns, one page. Builder for construction, Decorator for layered behaviour. Split if too tight. |
| 5.7 | 25 | Runners-up and the rest | todo | Adapter, Command, Template, State in brief; remaining catalogue as one-line definitions. |
| 6.1 | 26 | A framework for any LLD problem | todo | The repeatable sequence with timeboxes: clarify, actors, entities, relationships, interfaces, walk a flow, absorb the follow-up. |

**Budget note.** Pages 24 and 25 are the tightest. If either splits, Part 1 becomes 27 or 28
pages and every later page number shifts — update this table, the contents page and every
footer before touching anything else.

---

## 5. Part 2 — Problems

| § | Page | Title | Status | Brief |
|---|---|---|---|---|
| — | 1 | Cover | todo | Matches Part 1 cover, marked Part 2. **Preview page.** |
| — | 2 | Contents and how to read these problems | todo | Full index of all ten problems, plus the two-page anatomy explained. **Preview page.** |
| P1 | 3–4 | LRU cache | blocked | Starts as DSA, becomes LLD when eviction must swap to MRU without a rewrite. **Needs the author's anecdote.** |
| P2 | 5–6 | HashMap | blocked | Same shape: pluggable collision handling. **Needs the author's anecdote.** |
| P3 | 7–8 | To be decided | todo | |
| P4 | 9–10 | To be decided | todo | |
| P5 | 11–12 | To be decided | todo | |
| P6 | 13–14 | To be decided | todo | |
| P7 | 15–16 | To be decided | todo | |
| P8 | 17–18 | To be decided | todo | |
| P9 | 19–20 | To be decided | todo | |
| P10 | 21–22 | To be decided | todo | |
| — | 23 | Pattern-to-problem cheat sheet | todo | Which pattern showed up where, as a one-page revision aid. |
| — | 24 | Where to go next | todo | Closing guidance and practice sequencing. |

### Problem page template

Every problem uses the same two-page anatomy. The original outline listed sixteen blocks;
requirements were merged into one, and the two interviewer-facing blocks into one, leaving
fourteen.

**Page 1 — the design**

1. Problem statement
2. Clarifying questions
3. Requirements — functional and non-functional, two columns
4. Entities
5. Class diagram

**Page 2 — the depth**

6. Relationships
7. Design patterns used
8. Code sketch, with a repo link chip
9. Complexity
10. Follow-up questions
11. Alternative design
12. Common mistakes
13. Interviewer's perspective, merged with the real interview story
14. Forward or backward cross-reference to Part 1

Roughly eight blocks per page, two to four lines each. The layout only works if that
discipline holds.

---

## 6. Rules for changing structure

1. Update this file before touching any HTML.
2. Adding a page inside a chapter renumbers every later section in that chapter and every
   later page number in the part. Update the manifest, the page furniture and the contents page.
3. Never let a chapter exceed nine sections. If it does, the chapter is really two chapters.
4. The `of N` in every footer must match the part's total. Changing the total means editing
   every page in that part.
5. Content briefs in the manifest are binding. If a page needs to cover something not in its
   brief, update the brief rather than quietly expanding the page.
