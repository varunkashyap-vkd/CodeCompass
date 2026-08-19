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


**How was the problem worded?**
<!-- This is the important one. "Design Google Docs" has no edges, so the exact wording decides
     how much you were expected to bound it yourself. -->


**Had you seen it before?**


### What happened

**How did you open?**
<!-- What did you scope OUT in the first minute? That is the whole lesson of this case. -->


**What did you agree was in scope, and what did you rule out?**
<!-- Editing? Formatting? Comments? Sharing and permissions? Version history? Offline? -->


**How did you model the document itself?**
<!-- One flat string, a list of paragraphs, a tree of nodes? Where did formatting live? -->


**What was the tweak or follow-up, and how was it phrased?**
<!-- Two people editing at once? Undo? Comments or suggestion mode? Version history? -->


**What did you do in response?**


**Did anything come up that you hadn't prepared for?**


### The lesson

**What was the interviewer actually probing?**


**What surprised you?**


**What do you now tell people about this problem?**


**Anything you'd do differently?**


**Outcome, and any feedback?**


**A hot take about this problem?**


---

## D. Optional — choosing the remaining eight problems

Not needed to start, but it will make the rest of Part 2 much better if I know which of these
you've personally been on either side of. Mark anything you have a story for.

**Problems you have been asked, or have asked as an interviewer:**


**Problems you deliberately want to include, and why:**


**Problems you think are overrated and want to leave out:**
