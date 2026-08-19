# Interview notes — raw material for Part 2

> **What this is.** A place for you to dump the personal context I cannot invent: what actually
> happened to you in these rounds. I'll shape it into the *Interviewer's perspective* and
> *Real interview story* blocks, and let it colour the rest of the page.
>
> **How to fill it.** One or two sentences per prompt is plenty. Bullet fragments are fine —
> I'm after the specifics, not the prose. Leave anything blank that doesn't apply or that you'd
> rather not include, and delete a whole prompt if it's irrelevant.
>
> **Rough voice** is better than polished. If you write "interviewer went quiet for like 20
> seconds and then asked what if we wanted most-recently-used instead", that is far more useful
> to me than a tidy paragraph.

---

## A. General context

These answers apply across all problems, so I only need them once.

**How should companies be referred to?**
- Don't mention a company by name, but use acronyms like MAANG or Big tech.

**Roughly what level were you at for these rounds?**
- SDE-II and SDE-III levels, with experience ranging from 3 to 7 years based on individual interviews I was appearing for.


**Should these read as your own experience, or as things you've seen as an interviewer too?**
- For now, frame these as the questions I have encountered myself. For the next set of problems, I might try to frame them as interviewer's perspective also. But first I want the readers to get a feel of the things I have faced myself.


**Anything you say often when mentoring** that should show up as a recurring phrase?
- I feel I say "couple of things to discuss" whenever I am listing down stuff or responding to anyone who has just asked me a question that is not one word answer. 
- "Lets start with basics" - I use this multiple times because my general habit is to start from a basic working piece and then take it to fanciness or completion.
- "If you take one thing from session it would be this" - I use this when the discussion is long and I feel that mentee might not remember the whole session but there is this specific thing that I definitely want them to takeaway from the session.


**Anything that is off-limits** — NDA'd details, identifiable people, specifics to keep vague?
- Nothing of that sort, but never mention the company by exact name - always address them in terms of Big Tech/MAANG/FAANG etc. 
- Never say when I appeared for SDE-II role at Amazon, rather say that I was being evaluated for SDE-II loop at a big tech company.


---

## B. Problem 1 — LRU Cache

### The setup

**Where and when, and what kind of round was it?**
<!-- DSA round that turned into design? Dedicated LLD round? Machine coding? -->
- I was told to expect an LLD design, but the interviewer came with a live code editor asking me to write the LRU cache from scratch.
- It was indeed an LLD round, although on hearing the problem I wrongly assumed that it'd be just a DSA round.


**How was the problem actually worded when you got it?**
- We have a production application where we need to display user's location and address on the checkout page. How can we build something that will allow us to access this information in near real time for a given user.
- User base is quite large so we want to give priority to users who are coming most frequently. We are okay to be "late" for users who are not accessing our portal that frequently.


**Had you seen it before? Were you comfortable or caught cold?**
- I hadn't heard the exact problem statement but I did figure out that interviewer wanted to think in terms of an LRU Cache. I was more than comfortable.


### What happened

**How did you open — first thing you said or drew?**
- I started by saying that this sounds like a problem which can be solved with a cache, and since we want to support recent or active users more than others than I can go in the direction of LRU Cache.
- Did not draw anything, but explained the overall working I would expect from any lru cache, what DS I could use inside it internally and how I would I go about implementation.


**What was the tweak or follow-up, and how was it phrased?**
<!-- Your outline mentions the MRU switch. What exactly did they ask, and at what point? -->
- He did not interrupt me as I explained the solution and approach in detail.
- I became too comfortable thinking this is right in my domain, I have seen it before and I can code it quickly also (which I did as well). I totally assumed that this is not an LLD round and just a regular DSA round.
- Once I gave working code, he tested with few inputs with my help and it was the correct code.
- Then suddenly he flipped the script - what would happen to your code if tomorrow product comes and says they want to make the experience faster for those who have used it less and not the most recent ones.


**What did you do in response?**
<!-- Including anything you fumbled, or a wrong turn you took first -->
- Initially I panicked, because I had kind of hardcoded the cache handling withing the class itself.
- But luckily I had 30minutes still left since I did the first coding very quickly.
- Took 2 minutes to think through, and suggested that with slight modifications, I'd actually make the cache eviction logic plug and play instead of modifying my cache eviction in the existing code itself.
- I then walked him through the strategy pattern usage for our use-case and where exactly would I implement it.
- Once the plug and play model was in place, he asked me what exact work would be required for adding a new mechanism for cache eviction. I walked him through the code I created, and showed that with modifying just 4-5 lines, we could have a new strategy linked with the cache. Obviously, the actual implementation of that specific new cache eviction mechanism would be separate. But linking itself would be pretty straightforward.


**How long did you have, and did you run short?**
- I had ~20 minutes left for the implementation of the complete class level design I just explained. But I was pretty good at coding so I did not run short of time and was able to adjust everything within 15-20mins.


### The lesson

**What was the interviewer actually probing, in hindsight?**
- My capability of adapting my code only solution to changing requirements
- Long term maintenance as he specifically asked - "if product wants a new way to evict cache, will your code absorb it"

**What surprised you?**
- That something as simple as LRU cache could be turned into a full blown LLD interview

**What do you now tell people about this problem?**
- Dont underestimate it, its so common that at first glance every candidate feels its too easy, and maybe it is. But all it takes is few modifications to the original intent for the interviewer to make it a hard or a complex one.

**Anything you'd do differently?**
- Pay more attention to what the round actually it, if its an LLD round, always write the initial pass of code with that angle also in mind.


**Outcome, and any feedback you received?**
- I got a strong positive feedback, interviewer appreciated that I adapted to the new requirements rather quickly, showing my maturity in handling changing conditions.


**A hot take about this problem** — something you disagree with the standard advice on?
- I can think of anything of that sort right now.


---

## C. Problem 2 — Google Docs

<!-- The low-level structure behind Google Docs. Naming the product is fine and makes the problem
     relatable; naming the company whose loop this was is still off-limits. -->

### The setup

**Where and when, and what kind of round was it?**
- This was a low level and object oriented design round for SDE-III role at a Big tech company.


**How was the problem worded?**
- Devs at our company frequently use google docs for documentation, design dicussions, etc. but we wish to eliminate our dependency on Google. Suppose you're building an alternative to google docs for internal use within our company. I want to understand how the low level details for the same would look like behind the scenes. You can assume that high level design is already done and approved, but low level implementation is assigned to you.

**Had you seen it before?**
- Never, I had done similar problems for an HLD setup but never for LLD setup.

### What happened

**How did you open?**
- It was too open ended - low level details of google docs could be a never ending discussion.
- I started throwing out the features that I felt would be relevant to our discussion - showing same state to all the people who have access to a doc, capability for each user to edit the doc simultaneaously. Capability to perform undo operations - version management.

**What did you agree was in scope, and what did you rule out?**
- A doc can be owned by one person but can be shared with multiple individuals for viewing and editing
- Edits should be near real time and every user curently having the doc opened should see the changes almost immediately.
- Multiple people can edit the same doc at the same time
- Each editor should have the option to perform undo, i.e., they can delete the effect of latest changes and go back to previous state


**How did you model the document itself?**
- I started small, and abstracted out all the components which involved leaving the boundary of lld .e.g, how the doc will be actually stored. I simply explained and conveyed that doc will be stored in a database and that we'll have a server connected to it which will give the application access to its contents and capability to update it.
- Since database design was not a point of discussion for this round, the interviewer accepted my assumptions and asked me to move forward.
- I represented the doc as an array of strings, where each element represented one line on the page. For simplicity, I scoped the problem to only involve text elements, interviewer liked the way I was restricting the scope towards a workable solution.
- For conflict resolution, I explained that as long as people are making edits on different lines, it's not an issue. The problem would arise only when two people make edit on the same line.
- For this I suggested using timestamp based information in the "edit" received by the class to pick the one having the latest changes. I would always consider the latest update to be the source of truth.
- Each "edit" object will contain basic and important information with it - line edited, previous content, new content, editor's name, timestamp, etc.


**What was the tweak or follow-up, and how was it phrased?**
- How would you extend your conflict resolution and doc's representation to handle non text elements like images, diagrams, etc.

**What did you do in response?**
- I would have to extend the way my doc is currently represented - from an array of strings to a collection of successive elements on the page instead. When clubbed together, this collection would convey the whole page's content. Each individual component will then have their own way to handle conflicts.

**Did anything come up that you hadn't prepared for?**
- I wasn't expecting the interiewer to discuss the non textual components for the doc in such a small round of 45minutes.

### The lesson

**What was the interviewer actually probing?**
- If I have the HLD already in place, am I capable of taking it to low level and ensuring proper completion adhering to best coding practices.

**What surprised you?**
- Interviewer was highly collaborative. And as time went by I started treating him more and more like a colleague. I expected him to be stern and straight to the point instead.

**What do you now tell people about this problem?**
- Stick to basics, don't try to cover each and every aspect of google doc's working.

**Anything you'd do differently?**
- Nothing I can think of.


**Outcome, and any feedback?**
- I was given a hire verdict for this round.

**A hot take about this problem?**
- At first glance, it screams HLD or system design, but people rarely stop and ask what I'd do if I have to handle low level stuff for this problem.

---

## D. Optional — choosing the remaining eight problems

Not needed to start, but it will make the rest of Part 2 much better if I know which of these
you've personally been on either side of. Mark anything you have a story for.

**Problems you have been asked, or have asked as an interviewer:**


**Problems you deliberately want to include, and why:**


**Problems you think are overrated and want to leave out:**


---

## E. Representative cases — what I see from the other side

> **What this is.** P1 and P2 are rounds I sat as a candidate. P3 onward are problems I *set* as an
> interviewer and work through with people I mentor, so the raw material is a different kind: not
> what happened to me, but what I watch happen to other people. Section A anticipated this — "for
> the next set of problems, I might try to frame them as interviewer's perspective also."
>
> **This is the input that makes a representative case work.** Without it the agent can only write
> a competent summary of a problem anyone could look up. With it, the case has a point of view.
>
> **How to fill it.** Three questions per problem, below. Two solid paragraphs is plenty and rough
> bullets are fine — no need to write prose. Skip anything you have no view on.

### The three questions, asked for every problem

1. **Where do people go wrong?** The mistake you actually watch them make, not the one a textbook
   would list.
2. **What are you listening for when you set it?** What separates an answer you would pass from one
   you would not.
3. **What moment would you use to break their design?** The concrete scenario you spring on them
   once they look comfortable.

The third is the one that pays. For the parking lot it became the entire closing page, more or less
as written.

---

### P3 — Parking lot  *(answered; built on pages 13–16)*

**Where people go wrong**
- Candidates over obsess on the sizes of the parking slots, and end up making too many "parking
  type" enums which are non-essential for actually constructing the overall design. Maybe one or two
  types are enough to convey your idea that there will be more than one kind of parking slot.

**What I'm listening for**
- Is the candidate tightly coupling a specific parking slot to a specific vehicle type? If yes, then
  how do they manage the case where a bigger parking space is available but the current vehicle to
  be parked is a smaller one?
- Are you properly utilising the total space, or just overly creating classes for vehicles and slots?
- Are you treating the slots as individual items — scooter 1, car 4, bus 8 — where if 8 consecutive
  slots are free they can be assigned to a bus also? If you hardcode a bus-type slot, then only a bus
  can be parked in it.
- What if you have a bus slot free but no bus to park, and instead you need to park 8 scooters? Did
  you decide to not allow them to park, or do you?
- The interviewer wishes to understand your reasoning. They don't wish to see unnecessary coupling
  of stuff which could otherwise be avoided to properly utilise the whole space in the parking lot.

**The moment I'd use to break it**
- Derived from the above rather than supplied separately: a bus bay standing empty with no buses
  booked, and eight scooters queued at the gate.

---

### P4 — Vending machine

**Where people go wrong**


**What I'm listening for**


**The moment I'd use to break it**


<!-- Prompts that might jog something, ignore any that don't apply: what do people get wrong about
     the money — partial payment, refunds, exact change — versus the dispensing they spend their
     time on? Do they put transitions in one big if/else chain, and what happens when a state is
     added? Is there a case that reliably catches people — item goes out of stock after selection,
     cancel mid-transaction, power loss with money inserted? Anything overrated about this problem? -->

---

### P5 – P10

Same three questions, added as each problem is commissioned. Do not build a representative case
before its answers are here.

