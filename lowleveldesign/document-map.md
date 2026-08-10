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
| **Part 1 — Theory and Principles** | 29 | Vocabulary, principles, patterns, and a solving framework. |
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
| Footer, right | Absolute position | `Page 4 of 29` |

The `of 29` is deliberate. It bounds the document so it never feels open-ended.

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
| 3.1 | 11 | Single Responsibility | done | "One reason to change", framed as *who files the bug report*. Invoice with four departments' concerns. Over-splitting as the opposite failure. |
| 3.2 | 12 | Open/Closed | done | Choosing the axis of variation is the design decision. Discount code if-chain to a `Discount` interface. Speculative seams as the cost. |
| 3.3 | 13 | Liskov Substitution | done | "Do more, never less." `ReadOnlyDocument` throwing on `save()`; fixed by splitting the contract into `WritableDocument`. |
| 3.4 | 14 | Interface Segregation | done | Fat `Job` interface forcing empty overrides. Role interfaces as the fix. Explicit link back to the 3.3 violation. |
| 3.5 | 15 | Dependency Inversion | done | Inversion is a direction, not injection. The abstraction must be owned by the module that needs it. Testability as the interview signal. |
| 4.1 | 16 | KISS, DRY and YAGNI | done | Framed as restraint heuristics, scored silently rather than asked by name. Guards-against/over-applied table. DRY as duplicated knowledge not text. The OCP-versus-YAGNI tension and how to resolve it aloud. |
| 4.2 | 17 | Composition over inheritance | done | The argument is arithmetic: two axes multiply under inheritance, add under composition. Report format x destination. When inheritance still wins. |
| 4.3 | 18 | Interfaces and immutability | done | Depend on the weakest type that works (distinct from creating interfaces, cf. 2.2). Value objects. Deep versus shallow immutability; entities are not value objects. |
| 5.1 | 19 | Choosing a pattern | done | Symptom-to-pattern table covering all seven. The three groups. When the answer is no pattern at all, and why naming it is worth less than applying it. |
| 5.2 | 20 | Singleton | done | *Creational.* Naive lazy init versus the holder idiom. Where it shows up. The trap: global mutable state; create one and inject it. |
| 5.3 | 21 | Factory | done | *Creational.* Construction leaking into callers. UML diagram. The honest point that the switch is confined, not removed. Simple factory versus GoF Factory Method. |
| 5.4 | 22 | Builder | done | *Creational.* Telescoping constructor with adjacent booleans. Fluent usage plus the builder mechanics. `build()` as the last chance to refuse an invalid object. Builder versus Factory. |
| 5.5 | 23 | Observer | done | *Behavioural.* A place() method growing a line per feature. Class diagram. The listener leak, failure isolation, and when you actually wanted a pipeline. |
| 5.6 | 24 | Strategy | done | *Behavioural.* Cache eviction, tying forward to the LRU problem in Part 2. Class diagram. Trap: strategies needing different inputs rebuild the fat interface from 3.4. |
| 5.7 | 25 | State | done | *Behavioural.* Order lifecycle. Uses a state-transition diagram rather than a class diagram. Who owns transitions, and stateless states as shared instances. |
| 5.8 | 26 | Decorator | done | *Structural.* HTTP client with logging, retries and caching. Wrapping-chain diagram. Order as behaviour; Decorator versus Proxy. |
| 5.9 | 27 | The rest, at a glance | done | Five worth a proper look (Adapter, Command, Chain of Responsibility, Template Method, Composite) plus eight one-liners. Framed as recognition, not memorisation. |
| 6.1 | 28 | A framework for any LLD problem | done | Five questions rather than steps, with a 45-minute timeline strip. Deliberately not a decision tree. The first sixty seconds, and where candidates overspend. |
| 6.2 | 29 | When the requirement changes | done | Five shapes of follow-up, each mapped back to a chapter. Four moves when the change lands. Why admitting a design does not absorb a change outscores bluffing. Hands off to Part 2. |

**Why chapter 6 is two pages.** The five questions are meant to be memorised; handling the
follow-up is meant to be practised. Different jobs, and combining them compromised the first.
The follow-up is also the reader's real pain point, and 1.3 already promises this payoff.

**Chapter 5 ordering rationale.** Creational, then behavioural, then structural. That grouping
happens to track familiarity almost exactly — creation patterns have one concern and are easier
to explain — so the reader starts on ground they recognise. Strategy and State are kept adjacent
because State is far easier to teach as "Strategy that swaps itself" than from scratch.

**Why State is a full page.** The staple LLD prompts — vending machine, ATM, elevator, order
lifecycle, traffic light — are all state machines. It earns more space than its usual
runners-up billing.

---

## 5. Part 2 — Problems

| § | Page | Title | Status | Brief |
|---|---|---|---|---|
| — | 1 | Cover | done | Matches Part 1 cover, marked Part 2. **Preview page.** |
| — | 2 | Contents and how to read these problems | part | Two-page anatomy is written. **Still needs the index of ten problems**, which is blocked on choosing them. ~380px reserved. **Preview page.** |
| P1 | 3–4 | LRU cache | done | Arrives disguised as a product requirement about checkout addresses — the words *cache* and *least recently used* never appear. Strategy on the eviction seam. Story: the MRU flip against hard-coded eviction. |
| P2 | 5–6 | HashMap | blocked | Same shape: pluggable collision handling. **Needs section C of `interview-notes.md`.** |
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

### Measured budget, from P1

The right-hand page is the tight one. P1 landed at 44px slack with this distribution, which is
a realistic target for every problem:

| Block | Height |
|---|---|
| Title | 39px |
| Relationships + Patterns (two columns) | 82px |
| Code sketch + repo chip | 222px |
| Complexity + Alternative (two columns) | 76px |
| Follow-ups (**two** items, not three) | 72px |
| Common mistakes (one `.compact` paragraph, not a list) | 57px |
| Story block | 203px |
| Takeaway caption | 34px |

Three lessons worth carrying forward: keep the code sketch to about nine lines, write common
mistakes as a single compact paragraph rather than a list, and budget roughly 200px for the
story before writing anything else.

### Voice and attribution

From section A of `interview-notes.md`. These are binding on every story block.

- **Never name a company.** "A big tech company", "a MAANG-scale company". Never "the SDE-II loop
  at <name>" — say "an SDE-II loop at a big tech company".
- **Level context:** SDE-II and SDE-III loops, three to seven years of experience.
- **Voice for now:** the author's own experience as a candidate. Later problems may add an
  interviewer's-side perspective, but the first set should be things he faced himself.
- **Recurring phrases**, to use sparingly and naturally rather than in every problem:
  "a couple of things", "let's start with the basics", and "if you take one thing from this".
  The last one is already the closing caption of P1 and pairs with Part 1's usage.
- Rough and specific beats polished. Keep the fumble in — the panic in P1 is the point of the
  story, not a blemish to edit out.

### Story block shape

Two paragraphs inside a `.note`, plus a `.caption` takeaway *outside* it.

1. **The setup and the false sense of security** — what the round appeared to be, and why that
   read was wrong.
2. **The change, the exposure, the recovery** — what the interviewer asked, what broke, what it
   cost to fix, and what the feedback actually rewarded.

The takeaway caption is the generalisable lesson, addressed to the reader rather than narrated.

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

---

## 7. Pattern page template (chapter 5)

Sections 5.2 to 5.8 share one spine so the chapter reads as a reference rather than eight essays.

| Block | Purpose | Approx. height |
|---|---|---|
| Title + category | `5.4 Builder`, with *Creational* in the header right | 85px |
| Lead | Intent in plain language, never GoF phrasing | 65px |
| **The signal** | The symptom in code that should make you reach for this. Comes first because interviews test recognition, not recall. | 110px |
| Structure | Diagram **or** a skeleton snippet — whichever explains it faster | 150–200px |
| Code | The decisive lines only, 12 maximum | 180px |
| Where it shows up | Two to four named interview problems. A list where there is room, a single `.caption` line where there is not. | 40–90px |
| The trap | The mistake that costs marks, or when not to use it at all | 110px |

Total lands near 800px against 959px available, leaving normal slack.

**Diagrams are optional.** Singleton is one box, so a diagram would be decoration. Factory,
Observer, Strategy, State and Decorator earn one because structure is the hard part. Where a
diagram is skipped, the code block absorbs the space.
