# The LLD Runbook — Part 2 Problem Blueprint

> **How to use this file:** Begin from `lowleveldesign/context/starter.md`, which loads this file
> whenever a Part 2 problem is selected, commissioned, written, or reviewed. This is the content
> contract for all ten problems. The map controls problem order and page numbers; this file
> controls how a problem teaches.

---

## 1. Product promise

Part 2 is an **interview casebook**, not a catalogue of finished designs. A reader should be able
not only to understand the answer, but to rehearse how they would discover, explain, test, and
change it in a big-tech LLD interview.

Every problem must tell one coherent story:

> What I was asked → what I understood → what I clarified → what I designed → how I checked it →
> what changed → what broke → how I adapted → what the interviewer learned about me.

The document must stand on its own. A repository may provide complete compilable code, but no
reasoning required to understand the solution may be outsourced to it.

---

## 2. Part 1 is the navigation system

Section 6.1 of Part 1 gives the reader five questions. Every Part 2 problem must visibly run those
same questions, in the same order. Use the question labels in headings or margin labels so the
connection cannot be missed.

| Part 1 question | What the case study must show | Evidence on the page |
|---|---|---|
| **1. What am I actually building?** | Interpret the prompt, bound the system, state assumptions, and agree scope. | Original prompt, first-sixty-seconds response, clarification dialogue, requirements and exclusions. |
| **2. What are the things?** | Discover domain concepts from behaviour rather than list nouns mechanically. | Candidate entities, rejected false nouns, and why each surviving entity exists. |
| **3. Who owns what?** | Assign state and behaviour, then establish relationships. | Responsibilities, invariants, APIs, ownership notes, and the baseline class diagram. |
| **4. What will change?** | Identify one likely axis of variation without designing for every imaginary future. | The initial seam decision, or an explicit admission that the first design hard-coded the rule. Patterns appear only here, when justified. |
| **5. Does it actually work?** | Pressure-test the model instead of admiring the diagram. | One happy-path trace, one boundary or failure case, invariant checks, and operation-level complexity. |

The interview then enters the phase prepared by section 6.2:

| Follow-up phase | What the case study must show |
|---|---|
| **When the requirement changes** | The exact change, where it lands, what changes, what stays stable, and an honest response when the original design does not absorb it cleanly. |

The five questions are not decorative labels. If a draft cannot supply evidence for one of them,
the design explanation is incomplete.

---

## 3. Follow the interview, not a checklist

The case study is chronological. Do not present the final extensible class diagram first and
explain afterward that the initial design was different. The reader must experience the baseline
before seeing the pressure that changes it.

### The narrator

Part 1 works because one person is walking the reader through it, arguing, conceding, and
occasionally telling them off. Part 2 must be the **same narrator at a different distance**: Part 1
is him at the whiteboard, Part 2 is him in the room, remembering — and then turning to the reader
to say what it means. Same diction, same restraint, same willingness to say the uncomfortable thing.

Three registers carry it:

- **First person, past tense** for verified experience: “I assumed…”, “I asked…”, “I changed…”.
- **Neutral exposition, present tense** for reasoning: “The map holds nodes, not values…”.
- **Second person, present tense** for coaching: “In your interview, say this out loud.”

**Braid them; never segregate them.** The failure mode is putting each register in its own
container — story in the lead, exposition in the tables, coaching in the closing caption — which
reads as three authors rather than one narrator. The working pattern, repeated down every page:

> **What happened** (first person) → **the artifact** (table, diagram or code) → **what it means for
> you** (second person).

The third move is the narrator's signature and the one most easily lost. No table, diagram or code
block stands alone: something before it says why the reader is about to look at it, and something
after it says what to take from it. This is also where the author's recurring phrases belong —
“a couple of things”, “let's start with the basics”, “if you take one thing from this” — used
sparingly, and never more than one per page.

**Tense marks the boundary.** What happened is past, because it is over. What the design is
remains present, because it is still true. “I mapped keys to nodes” and “the map has to hold nodes,
not values” belong in the same paragraph and in different tenses. Collapsing both into one tense is
what makes technical writing sound authorless.

**The narrator has memory, not foresight.** He may say what he did and what he was thinking at the
time. He may not hint at what it is about to cost. “I said nothing would change — the most
expensive sentence of the round” spends page C's reversal on page B and lets the reader feel
knowing instead of caught. Hindsight is a page C privilege.

**He is allowed to be wrong.** Part 1's narrator carries authority because the theory is settled.
Part 2's earns it by being wrong first and recovering in view. An admitted misjudgement is worth
more than a paragraph of correct analysis, and it is never edited into something more flattering.

Short interviewer/candidate dialogue is encouraged when the wording changes the design. Do not
invent quotations, outcomes, emotions, or company details. Label the provenance of every case:

- **From my interview** — based on completed notes from the author.
- **Representative interview** — constructed teaching scenario, stated honestly.
- **From the interviewer’s side** — only when the author supplies that experience.

Never name a company. Level may be described as an SDE-II or SDE-III loop at a big-tech or
MAANG-scale company.

---

## 4. Page allocation: three case pages by default, four when earned, plus a class plate

Page count follows teaching load, not problem rank. A problem receives a fourth **case** page only
when three pages would force the removal of reasoning that satisfies the product promise.

**Every problem then ends with a class plate**, which is not a case page and is not negotiable.
These are two separate decisions and must stay separate. Coupling them — treating “five pages” as the
unit — is how cases get padded with a fourth narrative page they did not earn. Decide the case pages
on the rubric below; add the plate on top.

So a problem is `3 + 1` by default and `4 + 1` when the case earns it. See section 5's *The class
plate* for what goes on it.

### Three case pages

Use three case pages when the baseline model, decisive code, and follow-up can each be explained
without compressing the interview narrative.

| Page | Job | Framework coverage |
|---|---|---|
| **A — Enter the interview** | Prompt, first response, clarification dialogue, assumptions, scope, functional and non-functional requirements. Ends with the agreed problem and nothing derived from it. | Question 1 |
| **B — Build and prove the design** | Entity discovery, responsibilities, invariants, APIs, baseline diagram, operation trace, decisive Java, complexity. | Questions 2, 3, 4 and 5 |
| **C — Move the requirement** | Exact follow-up, exposed weakness, before/after design and code, what changes and stays stable, alternatives, mistakes, interviewer perspective, practice prompts, takeaway. | Section 6.2 follow-up |
| **The class plate** | The finished model in full UML, with a legend and the repo link. No prose. Automatic, never part of the three-versus-four decision. | — |

Page A stops before entity discovery on purpose. The reader must reach the end of it holding
exactly what the candidate held — prompt, clarifications, agreed scope — so the invitation to
attempt the problem is real rather than decorative. Naming the surviving entities on page A gives
the answer away and removes the only place the reader can usefully stop.

### Four case pages

Use four case pages when at least one of these is true:

- The authentic interview story has multiple meaningful turns that would become a sidebar in three pages.
- The data structure or state model needs a concrete operation trace separate from the class design.
- The implementation contains two independently important mechanisms, such as storage and collision handling.
- The follow-up changes both class responsibilities and underlying data structures.
- Concurrency, consistency, or another non-functional requirement materially changes the design.

| Page | Job | Framework coverage |
|---|---|---|
| **A — Enter the interview** | Prompt, first-sixty-seconds response, dialogue, assumptions, requirements, exclusions. | Question 1 |
| **B — Derive the baseline** | Entity discovery, rejected false nouns, ownership, invariants, APIs, baseline diagram. | Questions 2, 3 and 4 |
| **C — Make it work** | End-to-end operation traces, decisive Java excerpts, edge cases, tests, and derived complexity. | Question 5 |
| **D — Move the requirement** | Follow-up, impact analysis, before/after design and code, alternatives, debrief, exercises, takeaway. | Section 6.2 follow-up |
| **The class plate** | The finished model in full UML, with a legend and the repo link. No prose. Automatic, never part of the three-versus-four decision. | — |

A fourth **case** page is not awarded because a problem is famous or because the author has a
personal story. It is earned by distinct teaching work. If page C merely stretches code or repeats
the class diagram, return to three. Neither three nor four includes the class plate, which every
problem gets regardless.

---

## 5. The case page template

Part 1 chapter 5 reads as one voice because every pattern page is built against the block spine in
`lowleveldesign/context/document-map.md` section 7. This section is the Part 2 equivalent, and it
is binding for the same reason: ten case studies assembled from a content checklist will read as
ten different documents no matter how good each one is in isolation.

Heights are approximate and assume the 959px live area of an A4 `.page__body`. Target 40–160px of
slack. Where a problem has nothing to put in an optional block, cut it and let the neighbours
breathe rather than inventing filler. Every page spends about 70px on the masthead before its own
blocks begin; the tables below start after it.

### The rule that matters most: prose carries the page

A Part 1 page averages **two or three structural blocks** — a table, a diagram, a code block, a
note — and the narrator argues in plain paragraphs between every one of them. Every table and
diagram is introduced by a sentence that says why the reader is about to look at it, or followed
by one that says what it proved.

A Part 2 page must do the same. Six labelled containers stacked with no connective text is the
single reliable way to make a case study feel assembled instead of told. Before adding a block,
ask whether two sentences would carry it better; for entity lists, rejected nouns, scope notes and
alternatives, they almost always do.

Hard limits per page: at most **four** structural blocks, at most **two** tables, and never a table
that opens a section without a sentence in front of it. **No two structural blocks may sit
adjacent** — two containers touching with nothing between them is where the narrator of section 3
disappears.

The block heights below exclude the narrator. Reserve roughly **100–120px per page** for the
sentences that introduce and resolve the artifacts, and treat it as spent before layout begins.
When a page overruns, cut a block, a table row, or an optional slot. **The narrator's lines are cut
last**, which is the opposite of what happens naturally under page-fit pressure.

### The masthead: problem in the title, page in the deck

Every page of a case carries the **same** `h1` — the problem number and name, `P1  LRU Cache` —
and puts that page's own narrative title in a `.case-deck` standfirst directly beneath the title
rule. Part 2 is the half readers return to, and they navigate by problem rather than by narrative
beat; a reader who opens the book anywhere in a case must be told which problem they are in without
having to decode the running head.

The narrative titles still matter and still have to be good — they are what makes the case read as
a story rather than four filed sections. They simply must not outrank their own subject. So the
rules from before still bind, one level down:

- The deck makes a claim about its page. "The model" and "The change" are drawer labels and repeat
  the leg already named in the running header.
- The register is Part 1's: "Two structures, one promise", "What six calls proved", "The question
  after the code worked".

The running head carries `.case-id` on every page of a case, one ink step darker than ordinary page
furniture, for the reader flipping rather than reading.

### Framework markers rank above body text

The five questions are the spine of the product, so a `.qtag` sits at `h3` size in full ink, in
sentence case, with the question number in purple. Two settings are wrong and both have been tried:
an `h2` with a rule beneath chops the page into a form, and a 10px micro-label ranks the marker
*below* the prose around it, so the promised link back to section 6.1 gets missed. `h3` with no rule
is the setting that reads as a marker rather than a field.

### Page A — Enter the interview

The reader is put in the chair. They finish this page with the problem and no solution.

| Block | Purpose | Approx. height |
|---|---|---|
| Lead | The round as it was set up, and the reading the candidate took. Ends on whatever footing the story needs, including a false one. | 70px |
| **The prompt** (`.brief`) | Close to the wording actually used. The only block on this page that must be verbatim in spirit. | 110px |
| The first sixty seconds | What was actually said aloud, quoted. This is Question 1 answered by demonstration rather than by heading. | 130px |
| What I asked, and why it mattered | Three clarifications maximum, each with the design decision it settled. Introduced by prose. | 160px |
| The turn that sets up the case *(optional)* | The misread, the assumption, or the constraint that the follow-up will later punish. Only where the story has one. | 90px |
| Scope agreed | Assumptions, in scope, out of scope. One compact paragraph or caption, not a grid. | 90px |
| **Your turn** | The stop line: how long to spend and what to produce before turning the page. | 60px |

### Page B — Build and prove the design

The design the candidate actually wrote, presented with confidence. Where the baseline contains
the flaw the follow-up will expose, show it plainly and **do not foreshadow it**. The reader is
meant to share the candidate's false summit; a page that hints at the trap throws away the
reversal on page C.

| Block | Purpose | Approx. height |
|---|---|---|
| Title | The promise the model has to keep | 70px |
| Lead | The one or two guarantees everything else follows from | 60px |
| Entities, kept and dropped | Question 2, in prose. Name what survived, then name the false nouns and why they went. | 100px |
| Ownership and invariants | Question 3. Row-head table, four rows or fewer, closed by a one-line invariant caption. | 200px |
| **Baseline diagram** | Question 3 and 4. No dashed elements — the evolved design does not exist yet. | 170px |
| Trace | Question 5. Five or six calls with concrete values, complexity derived in the closing caption. | 200px |
| The honest axis, and the other answer | Question 4 answered truthfully in two or three sentences, plus the standard library or alternative approach. No heading of its own. | 100px |

### Page C — Move the requirement

| Block | Purpose | Approx. height |
|---|---|---|
| Title | What the follow-up actually tested | 70px |
| Lead | The false summit, then the moment it ended | 60px |
| **The follow-up** (`.brief`) | The changed requirement, close to how it was phrased | 90px |
| The two minutes | The recovery. The four moves from section 6.2 as a numbered list, one per line, echoing how Part 1 sets them out. Each line carries the concrete decision rather than restating the abstract move, and none of them may wrap. | 150px |
| **Before / after** | Structurally parallel excerpts, `code-block--bad` then `code-block--good`. The diff should be readable at a glance. | 220px |
| Evolved diagram | Dashed for genuinely later elements only. Shows the delta, not the whole model — completeness is the plate's job. Skip it where Part 1 already showed this exact structure and spend the space on cost instead. | 170px |
| What it cost, and where it stops | Rewiring cost in concrete terms, the limit of the evolved design, repo chip. | 100px |
| Debrief and takeaway | What the interviewer was probing, practice prompts, one generalisable line. | 90px |

The climax of a case cannot be a pattern name. Part 1 already taught the patterns, so a case whose
payoff is "the answer is Strategy" has delivered nothing the reader did not already own. The payoff
is the recovery: how the missing seam was found under time pressure, the sentence that named it,
and what the rewiring actually cost.

### The class plate — the last page of every case

The case pages deliver the design in chronological pieces, because that is how it was discovered.
The reader who returns three weeks later does not want the chronology; they want the model. The
plate is the page they come back to, and it is what makes the printed product complete without the
repository.

**It is a reference artifact, not a teaching page.** It is the only page in Part 2 exempt from the
block spine above: no lead, no narrator, no prose between artifacts, no debrief. Just the plate.
An early draft of P2's plate wrapped it in explanatory prose and a table on what order to draw the
classes in; it was rejected, and reintroducing that is an anti-pattern.

| Element | Rule |
|---|---|
| Scope | Every class in the finished design, including those the follow-up introduced. |
| Compartments | Name strip, hairline, then members in mono. Fields and methods both, with `+` / `-` visibility, parameter types and return types. |
| Stereotypes | `«interface»`, `«enum»`, `«record»` above the name where they apply. |
| Relationships | Filled diamond for composition, hollow diamond for aggregation, open arrow for association, dashed line plus hollow triangle for realization. Multiplicities on association ends. |
| Later additions | Dashed **box outline** marks a class the follow-up introduced. Line dashing stays reserved for realization, so the two never collide. |
| Legend | A compact strip along the foot of the plate naming every symbol **used on that plate**. Symbols not on the plate are not in its legend. |
| Prose | None. A one-line figcaption carrying the repo chip is the only text outside the diagram. |
| Width | Full body width. Use `.diagram--full`, which unsets the 470px cap that applies to in-case diagrams. |

**The binding rule: the plate is a contract with the repository.** The linked implementation must
contain exactly these classes, with these members and these relationships. Nothing may appear on a
plate that the code does not implement — no speculative classes, no ghost boxes showing what an
extension would cost, no members invented to balance a box, no placeholder types. The ghost box
convention belongs on the in-case diagram on page C or D, where it is explicitly labelled as never
built; on the plate it would be a lie about what the reader can go and read.

Build the plate **last**, from the finished code excerpts, and check every member against them. It
is the fourth statement of the same model — after the baseline diagram, the excerpts and the
evolved diagram — so it is the fourth place they can disagree.

---

## 6. Required content

Every problem must contain the following, but these are ingredients rather than fourteen isolated
boxes.

### Interview setup

- Round and level context, when known
- Prompt close to the wording actually used
- Candidate’s first interpretation and first-sixty-seconds response
- Clarification dialogue: question, answer, and why it matters
- Explicit assumptions, in-scope requirements, and exclusions

### Design derivation

- Requirements translated into design pressures
- Entities that survive scrutiny and false nouns deliberately rejected
- Responsibility and state owner for each entity
- At least two named invariants
- Public API before implementation details
- Baseline class diagram without follow-up additions
- One explicitly chosen axis of variation, or an honest statement that none is yet justified

### Proof that it works

- One concrete happy-path trace using example values
- One update, boundary, or failure trace
- Complexity derived operation by operation
- Decisive Java excerpts; boilerplate omitted
- Edge cases and test scenarios

### Requirement change

Apply the four moves from Part 1 section 6.2:

1. Restate the changed requirement.
2. Point to where it lands in the current design.
3. State what changes and what remains stable.
4. If it does not fit, say so and identify the seam that was missing.

Then show:

- Baseline design before the change
- Revised design after the change
- Dashed boxes and connectors only for elements genuinely introduced later
- Structurally parallel before/after code
- Why the selected pattern helps, if a pattern is needed
- Limits of the revised design; do not imply that one interface solves unrelated algorithms

### Debrief and practice

- Common reasoning and implementation mistakes
- A credible alternative design and its trade-off
- What the interviewer was evaluating
- What the author did well, fumbled, and would now do differently
- Two or three follow-ups for the reader to attempt without answers on the same page
- One concise, generalisable takeaway
- Link to complete code when available

---

## 7. Code and diagram rules

The body of the document must contain enough Java to explain the mechanism without becoming a code
dump.

- Prefer several focused excerpts over one complete class.
- Each excerpt should answer one named question and normally stay within 12 lines.
- Show the public API, the decisive mutation, and the changed seam.
- Use concrete keys, values, states, or requests in operation traces.
- **Prefer concrete types over generics.** A generic container is not something a candidate finishes
  in a 45-minute round, and the plate has to describe code that can actually be written. P1 uses
  plain `int` keys and values rather than `K` and `V` for exactly this reason.
- Derive complexity beside the operation that creates it rather than collecting unsupported Big-O
  claims at the end.
- A repository link is supplementary. The printed explanation must remain complete without it.

Diagrams must preserve chronology:

1. Show the baseline diagram as it existed before the follow-up.
2. Show a separate evolved diagram, or overlay only the later elements with dashed styling.
3. Name ownership and the important direction of dependency.
4. Do not add a pattern to the diagram before the narrative earns it.

**In-case diagrams argue; the plate records.** They are not competing for the same job, so do not
make the closing in-case diagram complete. It exists to show what the follow-up changed, and may
legitimately omit classes the reader already met and include a ghost box for what was never built.
Completeness is the plate's job, and only the plate is bound to the repository.

---

## 8. Drafting workflow for each problem

Do not begin page layout from a topic name alone. Build the problem in this order:

1. **Collect source material.** Complete the problem’s interview notes, including exact prompt,
   follow-up, response, outcome, and details that must remain anonymous.
2. **Write the interview spine.** In plain Markdown, narrate the sequence from prompt through
   follow-up in 8–12 beats.
3. **Map the five questions.** Record the evidence that answers each Part 1 question. Resolve any
   blank before writing HTML.
4. **Choose the teaching transformation.** Name the one design decision the follow-up will expose.
5. **Derive the artifacts.** Baseline and evolved diagrams, operation traces, code excerpts,
   complexity, edge cases, and exercises.
6. **Choose three or four case pages.** Apply the criteria in section 4 and record the reason in
   `lowleveldesign/context/document-map.md`. The plate is automatic and is not part of this count.
7. **Update the map first.** Lock title, page allocation, story source, transformation, and brief.
8. **Write the pages as prose.** Draft each page in Markdown against its block spine in section 5,
   including the sentences that introduce every table and diagram. A page that does not read well
   as plain text will not be rescued by markup.
9. **Build the HTML.** Preserve the shared visual system and the section 5 block order. Cut an
   optional block rather than exceeding the page.
10. **Build the class plate last**, from the finished code excerpts. Check every class, member and
    relationship against them, and against the linked repository. Anything the code does not
    implement comes off the plate.
11. **Review content before fit.** Check chronology, technical accuracy, framework coverage, and
    authenticity before cutting for A4.
12. **Validate the artifact.** Check page fit, rendered diagrams, links, fonts, and PDF export.

---

## 9. Problem commissioning brief

Copy and complete this block before starting a new problem:

```text
Problem ID and working title:
Story provenance: From my interview / Representative / Interviewer’s side
Round and level context:
Original prompt:
First interpretation:
Clarifications that changed the design:
Agreed scope and exclusions:

Q1 — What am I actually building?
Q2 — What are the things?
Q3 — Who owns what?
Q4 — What will change?
Q5 — Does it actually work?

Exact follow-up:
Where it lands in the baseline:
What changes:
What remains stable:
Baseline -> evolved design transformation:
Pattern earned, if any:
Limits of the evolved design:

Happy-path trace:
Boundary or failure trace:
Decisive Java excerpts:
Alternative design:
Common mistakes:
Interviewer evaluation:
Personal fumble and recovery, if verified:
Reader practice prompts:
Takeaway:
Full-code destination:

Class plate — classes and their members:
Class plate — relationships and multiplicities:
Concrete types chosen, in place of generics:

Case pages: 3 / 4  (the class plate is automatic and not part of this count)
Why the fourth case page is earned, if applicable:
```

---

## 10. Definition of done

A problem is not done until all of these are true:

- [ ] A reader can retell the interview in chronological order.
- [ ] The five questions from Part 1 are visibly answered with evidence.
- [ ] The first sixty seconds are demonstrated, not merely advised.
- [ ] Every important class traces to a requirement and owns a clear responsibility.
- [ ] At least two invariants and two concrete execution traces pressure-test the model.
- [ ] The baseline appears before the evolved design.
- [ ] The follow-up uses all four moves from Part 1 section 6.2.
- [ ] Every named pattern is earned by a visible design pressure.
- [ ] Complexity is explained operation by operation.
- [ ] The personal story changes the teaching, rather than appearing as a detachable note.
- [ ] The reader can understand the solution without opening the repository.
- [ ] Practice prompts make the problem reusable after the first read.
- [ ] The content passes technical review before it is compressed for page fit.
- [ ] Every page follows its block spine in section 5, with no more than four structural blocks.
- [ ] The case ends with a class plate carrying every class in the finished design.
- [ ] Every class, member and relationship on the plate exists in the linked implementation.
- [ ] The plate agrees with the code excerpts and diagrams in the case pages.
- [ ] The plate carries a legend covering every symbol it uses, and no prose.
- [ ] Every table and diagram is introduced or resolved by a sentence of prose.
- [ ] No two structural blocks sit adjacent on any page.
- [ ] Each page turns to the reader at least twice, not only in its closing caption.
- [ ] The story is past tense and the design is present tense.
- [ ] The narrator never anticipates the follow-up before page C.
- [ ] Every page title makes a claim rather than repeating the running header.
- [ ] Page A ends at an honest stopping point, before anything is derived.
- [ ] Every page fits A4 and passes the shared pre-flight checklist.

---

## 11. Anti-patterns

Reject a draft when it does any of the following:

- Opens with the final extensible class diagram.
- Treats entities, patterns, complexity, and mistakes as unrelated checklist cards.
- Names a pattern before identifying the pressure that requires it.
- Uses “plug-and-play” for algorithms that need different state or data structures.
- States complexity without walking the relevant operation.
- Presents twenty clarifying questions with no explanation of which answers matter.
- Hides missing reasoning behind a full-code link.
- Invents dialogue or personal detail to make a representative scenario sound authentic.
- Adds a fourth page that contains no distinct teaching job.
- Cuts the interview story first when the page overflows.
- Stacks labelled blocks with no argument between them, so the narrator disappears.
- Quarantines each voice in its own container — story in the lead, exposition in the tables,
  coaching in the closing caption — so the page reads as three authors.
- Lets the narrator show hindsight before page C.
- Cuts the narrator's connective sentences to make a page fit.
- Titles a page with the name of its leg, which the running header already carries.
- Foreshadows the weakness on page B and spends the reversal before page C.
- Ends the case on a pattern name that Part 1 already taught.
- Puts a class, member or relationship on the class plate that the repository does not implement.
- Wraps the class plate in explanatory prose, a lead, or a debrief.
- Pads a case to a fourth narrative page because the plate made it “nearly five”.
