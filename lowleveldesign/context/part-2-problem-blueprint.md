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

Use three distinct voices deliberately:

- **First person** for verified experience: “I assumed…”, “I asked…”, “I changed…”.
- **Technical exposition** for reasoning: “The map provides…”, “This invariant ensures…”.
- **Second person** for coaching: “In your interview, state this assumption aloud.”

Short interviewer/candidate dialogue is encouraged when the wording changes the design. Do not
invent quotations, outcomes, emotions, or company details. Label the provenance of every case:

- **From my interview** — based on completed notes from the author.
- **Representative interview** — constructed teaching scenario, stated honestly.
- **From the interviewer’s side** — only when the author supplies that experience.

Never name a company. Level may be described as an SDE-II or SDE-III loop at a big-tech or
MAANG-scale company.

---

## 4. Page allocation: three by default, four when earned

Page count follows teaching load, not problem rank. A problem receives a fourth page only when
three pages would force the removal of reasoning that satisfies the product promise.

### Three-page case study

Use three pages when the baseline model, decisive code, and follow-up can each be explained without
compressing the interview narrative.

| Page | Job | Framework coverage |
|---|---|---|
| **A — Enter the interview** | Prompt, first response, clarification dialogue, assumptions, scope, functional and non-functional requirements. End with the agreed problem. | Question 1, opening of Question 2 |
| **B — Build and prove the design** | Entity discovery, responsibilities, invariants, APIs, baseline diagram, operation trace, decisive Java, complexity. | Questions 2, 3, 4 and 5 |
| **C — Move the requirement** | Exact follow-up, exposed weakness, before/after design and code, what changes and stays stable, alternatives, mistakes, interviewer perspective, practice prompts, takeaway. | Section 6.2 follow-up |

### Four-page case study

Use four pages when at least one of these is true:

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

A fourth page is not awarded because a problem is famous or because the author has a personal
story. It is earned by distinct teaching work. If page C merely stretches code or repeats the
class diagram, return to three pages.

---

## 5. Required content

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

## 6. Code and diagram rules

The body of the document must contain enough Java to explain the mechanism without becoming a code
dump.

- Prefer several focused excerpts over one complete class.
- Each excerpt should answer one named question and normally stay within 12 lines.
- Show the public API, the decisive mutation, and the changed seam.
- Use concrete keys, values, states, or requests in operation traces.
- Derive complexity beside the operation that creates it rather than collecting unsupported Big-O
  claims at the end.
- A repository link is supplementary. The printed explanation must remain complete without it.

Diagrams must preserve chronology:

1. Show the baseline diagram as it existed before the follow-up.
2. Show a separate evolved diagram, or overlay only the later elements with dashed styling.
3. Name ownership and the important direction of dependency.
4. Do not add a pattern to the diagram before the narrative earns it.

---

## 7. Drafting workflow for each problem

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
6. **Choose three or four pages.** Apply the criteria in section 4 and record the reason in
   `lowleveldesign/context/document-map.md`.
7. **Update the map first.** Lock title, page allocation, story source, transformation, and brief.
8. **Build the HTML.** Preserve the shared visual system, but let the narrative determine section
   boundaries.
9. **Review content before fit.** Check chronology, technical accuracy, framework coverage, and
   authenticity before cutting for A4.
10. **Validate the artifact.** Check page fit, rendered diagrams, links, fonts, and PDF export.

---

## 8. Problem commissioning brief

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

Page count: 3 / 4
Why the fourth page is earned, if applicable:
```

---

## 9. Definition of done

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
- [ ] Every page fits A4 and passes the shared pre-flight checklist.

---

## 10. Anti-patterns

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
