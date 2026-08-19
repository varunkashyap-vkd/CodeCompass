# The LLD Runbook — Document Map

> **How to use this file:** This is the structural source of truth for the runbook. Begin future
> sessions from `lowleveldesign/context/starter.md`, which loads this map in the right context.
>
> To commission work, name a **section number** — "build 5.4" — not a page number. Section
> numbers are stable; page numbers shift whenever a page is added or split.
>
> After any structural change, update this file **first**, then the pages. If this file and the
> HTML disagree, this file wins.

**Related files**

| File | Role |
|---|---|
| `lowleveldesign/context/document-structure.txt` | The original outline. Historical intent; superseded by this map. |
| `lowleveldesign/context/style-reference.md` | Typography, colour, spacing, print rules. Non-negotiable. |
| `lowleveldesign/context/part-2-problem-blueprint.md` | Content contract for every Part 2 case study. Attach when commissioning or building a problem. |
| `lowleveldesign/context/interview-notes.md` | Author-supplied factual material for personal Part 2 stories. |
| `lowleveldesign/part-1-theory.html` | All Part 1 pages, one file. |
| `lowleveldesign/part-2-problems.html` | All Part 2 pages, one file. |
| `lowleveldesign/tools/export-pdf.ps1` | The only supported PDF export path. |

---

## 1. Product shape

Two standalone PDFs, each self-contained. Part 2 is allowed to be longer because its job is to
teach complete interview case studies rather than summarise reference material.

| | Pages | Purpose |
|---|---|---|
| **Part 1 — Theory and Principles** | 29 | Vocabulary, principles, patterns, and a solving framework. |
| **Part 2 — Problems** | 46 | Ten interview case studies worked chronologically — three case pages each except P1 and P2, every one closing with a full class plate — plus cover, contents and two closing pages. |

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

Part 2 replaces the section number with the problem number (`P1`) and names the leg of the case
in the header right (`The model · 2 of 3`). Every page of a case repeats the problem name in the
`h1` and carries that page's own narrative title in a `.case-deck` beneath it. Everything else
matches.

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
| 6.1 | 28 | A framework for any LLD problem | done | Five questions rather than steps, with a 45-minute timeline strip. Deliberately not a decision tree. The first sixty seconds, where candidates overspend, and Question 5 proved with a flow plus a boundary/invariant check. |
| 6.2 | 29 | When the requirement changes | done | Five shapes of follow-up, each mapped back to a chapter. Four moves when the change lands. Why admitting a design does not absorb a change outscores bluffing. Hands off to Part 2, where the same questions and moves are visibly reused. |

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

> **Titles P3–P10 are placeholders.** They are plausible LLD problems chosen so the contents page
> reads as a finished index; each is replaced when its commissioning brief is written. Page ranges
> assume the three-page default and are re-checked whenever a case is built.

| § | Page | Title | Status | Brief |
|---|---|---|---|---|
| — | 1 | Cover | done | Matches Part 1 cover, marked Part 2. Lede promises the follow-up moment Part 1 closes on. **Preview page.** |
| — | 2 | Contents | done | Reuses Part 1's `.index` markup and rhythm so both parts read as one product. Four groups with right-aligned notes, exactly like Part 1's chapters. Each case row carries a one-line editorial gloss, because this is the page a buyer inspects before paying. Revision entries are numbered `4.1`/`4.2` on Part 1's chapter.section convention and carry no separators. A strong rule marks where the index ends, then a boxed three-step “How to work a case” flow with badge numerals and chevrons, all drawn in CSS. Title is one word. **Preview page.** |
| P1 | 3–7 | LRU cache | done | Personal interview case in **four case pages plus a class plate**, each titled *LRU Cache* with its own deck: (A) *The round I misread* — prompt, the exchange, three clarifications, scope, stop line; (B) *Two structures, one promise* — rejected nouns, ownership, invariants, baseline diagram, public API, and Q4 answered honestly; (C) *What six calls proved* — six-call trace, decisive mutation, complexity derived at the call site, edge cases; (D) *The question after the code worked* — MRU follow-up, the recovery, Strategy named and justified against section 5.6's signal (including why it is not State), before/after code, delta diagram, rewiring cost, LFU limit, debrief and takeaway. Signed off by the author; treat its page spine as the reference for later cases. |
| P2 | 8–12 | Google Docs | done | Personal interview case, SDE-III object-oriented design round, in **four case pages plus a class plate**, each titled *Google Docs* with its own deck: (A) *Ten minutes deciding what not to build* — the unbounded prompt, bounding it by proposing scope rather than asking for it, the clarification that split undo two ways, the storage boundary drawn explicitly, text-only agreed, stop line; (B) *An edit has to carry its own past* — rejected nouns, the four entities, ownership and invariants, baseline diagram, public API, Q4 answered honestly (conflict rule named as variable, content type treated as fixed); (C) *Two editors, one line* — a five-step collision trace with real timestamps, the decisive `apply`, undo re-submitted as a reversed edit through the same path, complexity and edge cases; (D) *The assumption inside the word “text”* — the non-text follow-up, the sting of having proposed the simplification himself, four moves, before/after code, the rewiring cost that reaches `Edit` rather than stopping at `Document`, limits; (E) *Every class, and how they connect* — a full UML class plate: eight compartment boxes carrying every field and method, composition, aggregation, association and realization notation with multiplicities, and the repo link. Deliberately carries **no prose** — it is a reference artifact, not a teaching page. Replaced HashMap, whose natural follow-up (chaining versus open addressing) landed on the same closing lesson as P1: an interface does not absorb an algorithm that needs different state. Scope hard: the document model and one edit applied end to end, never “build Google Docs”. The product may be named; the interviewing company still may not. |
| P3 | 13–16 | Parking lot | todo | Placeholder title. Three case pages plus a class plate. Complete a commissioning brief before building. |
| P4 | 17–20 | Vending machine | todo | Placeholder title. Three case pages plus a class plate. Complete a commissioning brief before building. |
| P5 | 21–24 | Elevator system | todo | Placeholder title. Three case pages plus a class plate. Complete a commissioning brief before building. |
| P6 | 25–28 | Chess | todo | Placeholder title. Three case pages plus a class plate. Complete a commissioning brief before building. Chosen over Snake and ladder because nothing else in the lineup exercises inheritance versus composition (4.2), and Snake and ladder duplicated the Vending machine's rules-plus-state lesson. |
| P7 | 29–32 | Rate limiter | todo | Placeholder title. Three case pages plus a class plate. Complete a commissioning brief before building. |
| P8 | 33–36 | Notification service | todo | Placeholder title. Three case pages plus a class plate. Complete a commissioning brief before building. |
| P9 | 37–40 | Splitwise | todo | Placeholder title. Three case pages plus a class plate. Complete a commissioning brief before building. |
| P10 | 41–44 | Logging framework | todo | Placeholder title. Three case pages plus a class plate. Complete a commissioning brief before building. |
| — | 45 | Pattern-to-problem cheat sheet | todo | Which pattern showed up where and which framework question exposed it. |
| — | 46 | Where to go next | todo | Closing guidance and practice sequencing. |

### Contents grouping

The ten cases are grouped into three named bands plus revision, so the index carries Part 1's
chapter rhythm rather than reading as a flat list of ten nouns:

| Group | Note | Problems |
|---|---|---|
| 01 Rounds I sat in | First-hand | P1, P2 |
| 02 Objects, state and rules | Modelling and lifecycle | P3–P6 |
| 03 Services and policies | Extension under pressure | P7–P10 |
| 04 Revision | Reference | Cheat sheet, Where to go next |

The first band groups by **provenance, not topic**. Its two problems are the ones the author sat
himself, and they are deliberately different shapes — a data structure and a document model — so the
pairing reads as “these are the real ones” rather than “these are the two data-structure ones”. An
earlier title, *Data structures under pressure*, advertised a similarity that was the reason HashMap
had to go. P3–P10 were reordered from their original sequence to fit these bands; the titles remain
placeholders and the bands are provisional until the lineup is locked.

### Intended pattern payoff

Six of the ten problems drift naturally to Strategy, and left unmanaged the cheat sheet on page 35
would have almost nothing to say. Each commissioning brief therefore names its payoff up front, and
the set is chosen to cover chapter 5 broadly plus several from 5.9. **Singleton (5.2) currently has
no home in Part 2.** That is a real gap in the cheat sheet, not an oversight to ignore; whichever of
P3–P10 is briefed next should be checked against it before its payoff is fixed.

| | Problem | Intended payoff |
|---|---|---|
| P1 | LRU cache | Strategy — **built** |
| P2 | Google Docs | Command for the edit and its undo; the follow-up pays off in **Open/Closed (3.2) through polymorphism (2.4)**, not a pattern — **built** |
| P3 | Parking lot | Factory, Composite |
| P4 | Vending machine | State |
| P5 | Elevator system | State plus a scheduling seam |
| P6 | Chess | Inheritance versus composition. **Command removed** — P2 now earns it, and chess move history taught the same lesson a second time |
| P7 | Rate limiter | The Strategy *trap* from 5.6 — algorithms needing different state |
| P8 | Notification service | Observer, and Builder for message construction |
| P9 | Splitwise | Interfaces and money invariants |
| P10 | Logging framework | Decorator, Chain of Responsibility |

Builder is otherwise never earned anywhere in Part 2, which is why P8 carries it. If a brief drifts
to Strategy when the table says otherwise, the problem is the brief, not the table.

**Why P1 earns a fourth page.** Two of the blueprint section 4 criteria are met, and the evidence
is a measured overflow rather than a preference. The class design and the operation trace each need
about 200px and compete for the same page; and the three-page version carried no Java at all, so
the public API and the decisive mutation — both required content — had nowhere to go. Splitting
the baseline from the proof resolves both. This does not entitle P2–P10 to four pages.

**Why P2 earns a fourth page.** Four of the five blueprint section 4 criteria are met, which is a
stronger case than P1's. The design carries **two independent mechanisms** — conflict resolution and
per-editor undo — that have to be shown separately or neither is convincing; the collision needs a
**timestamped trace of its own**, because the interesting behaviour only appears when two editors
land on one line; the follow-up is **structural**, changing both the collection type and where the
merge rule lives; and **concurrency is a material non-functional driver** rather than a footnote,
since near-real-time multi-editor was agreed scope in the first ten minutes. Arithmetic confirms it:
the three-page spine allocates page B roughly 900px before the masthead, leaving nothing for the
narrator's 100–120px, and P2's baseline has three mechanisms to P1's one. **This is now two
four-page cases in a row and the pattern stops here.** P3 onward start at three and must meet the
section 4 bar on measured evidence, not on the precedent of the two cases the author sat himself.

**Every case ends with a class plate.** The case pages deliver the design in chronological pieces,
which is right for learning it and wrong for returning to it. The plate is the artifact a reader
comes back to, and it is what lets the printed product carry the whole design without the
repository. Its contract is *The class plate* in blueprint section 5; the rule that matters most is
that **nothing appears on a plate that the linked code does not implement**. No ghost boxes, no
speculative classes, no members invented to fill a compartment.

A plate is a reference artifact and is exempt from the section 5 block spine — it carries no lead,
no narrator and no debrief. P2's first attempt wrapped it in prose and a draw-order table and was
rejected; do not rebuild that.

**CSS this added.** `.diagram--full` (unsets the 470px svg cap), `.d-strip`, `.d-rule`, `.d-mem`,
`.d-solid` — the compartment-box treatment that style-reference section 8 always specified but
nothing had used. Every later plate reuses these.

**A standing gap this exposed.** The dashed-diagram convention below says the closing *in-case*
class diagram should show both versions at once. P1's drops `Map`, `RecencyList` and `Node`, and
P2's page D has none at all. The plates do not excuse this; the in-case diagrams still argue, while
the plate only records.**Why Composite was dropped from P2.** The original payoff put Composite on the document tree, but
the author's actual follow-up asked for non-text *elements in a flat sequence*, not nesting — the
recovery was a polymorphic element type, and calling that Composite would have badged the case with
a pattern the design does not use. Part 1 also ranks Composite in 5.9, below the seven that earned
pages, so it made a weak climax for a case. It stays with P3, where nesting is real. P2's honest
payoff is chapter 3, and it becomes the one case in Part 2 where the answer to the follow-up is not
a pattern name — which section 5.1 already promises the reader will sometimes happen.

### Problem case-study contract

Every problem uses the chronology and definition of done in `lowleveldesign/context/part-2-problem-blueprint.md`.
The five questions from Part 1 section 6.1 are the visible navigation system; the changed
requirement follows the four moves from section 6.2.

Every case study receives three case pages by default, then a class plate:

1. **Enter the interview** — prompt, first response, clarification dialogue, assumptions and scope.
   Stops before entity discovery so the invitation to attempt the problem is real.
2. **Build and prove the design** — entities, ownership, invariants, diagram, traces, Java and complexity.
3. **Move the requirement** — impact, before/after design, debrief, alternatives and practice.
4. **The class plate** — the finished model in full UML, with a legend and the repo link. No prose.

**Page layout is not free.** Section 5 of the blueprint gives each of the three pages a binding
block spine, in the same way section 7 below governs the Part 1 pattern pages. Chapter 5 of Part 1
reads as one voice because of that spine; Part 2 needs its own or ten case studies will read as ten
documents. The spine also caps a page at four structural blocks and two tables, and requires prose
between them — stacked labelled containers with no argument running through them is the failure
mode these pages fall into.

A fourth **case** page is allowed only when it has a distinct teaching job: a substantial authentic
story, a separate operation trace, two independent mechanisms, a structural follow-up, or a material
non-functional concern. Fame and problem order are not reasons to add a page. The class plate is
separate and automatic; it never counts toward this decision, and a case must never be padded to a
fourth narrative page because the plate made it “nearly five”.

### Show the journey, not the destination

**The most important rule on these pages.** The reader must see the design the candidate would
actually write first, and then what the changed requirement did to it. Presenting the finished,
seam-in-the-right-place model as though it arrived fully formed is dishonest and wastes the whole
point of the problem.

Two devices carry this, and both should be reused for every problem:

- **A dashed diagram.** Anything the follow-up introduced gets `.d-box--later` and dashed
  connectors, with the figcaption saying so outright. The class diagram then shows *both*
  versions at once. Where the case claims the design is now cheap to extend, add one
  `.d-box--ghost` slot for the extension that was never built — lighter stroke, faint label, so it
  never reads as a class that exists. Three states in total: solid was always there, dashed arrived
  with the follow-up, ghosted is what extending it would cost. **In-case diagrams only** — a ghost
  box must never appear on a class plate, which may show only what the repository implements.
- **A stacked before/after.** A short `code-block--bad` labelled as the first version, then a
  `code-block--good` labelled as what the follow-up forced. Keep them structurally parallel so
  the diff is obvious — in P1 exactly one line differs.

Complexity belongs on the design page, beside the operation that creates it, so the closing page
is free for the change itself.

### Voice and attribution

From section A of `lowleveldesign/context/interview-notes.md`. These are binding on every story block.

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

### Story integration

The personal story is the spine of an authentic case, not a detachable note near the end. Setup,
false confidence, design choices, changed requirement, exposure, recovery and feedback must appear
where they happened in the chronology. The final takeaway addresses the reader and generalises the
lesson without rewriting the story.

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
