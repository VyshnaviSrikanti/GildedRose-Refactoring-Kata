# Gilded Rose Java backlog

## Working agreement

Work from the upstream Java legacy implementation, in small reviewable steps.
Discuss reasoning and challenge the user's answers before implementing each
step. Record answers and decisions here. Do not transplant the earlier solution.
Separate behavior-preserving refactoring from the Conjured feature. Keep Item
and the items property unchanged as required by the kata.

## Sources

- Upstream: https://github.com/emilybache/GildedRose-Refactoring-Kata
- Requirements: [GildedRoseRequirements.md](GildedRoseRequirements.md)
- Target: Java/ (Maven, JUnit 5; upstream targets Java 8)
- Working branch: java-kata

## Backlog

- [x] B01: Read canonical requirements and inspect the Java starter.
- [ ] B02: Agree interview format, Java compatibility, and delivery workflow.
- [ ] B03: Run the untouched starter; document intentional failing test and tooling issues.
- [ ] B04: Build a requirements and boundary test matrix; distinguish observed behavior from requirements.
- [ ] B05: Replace placeholder test with characterization tests, without production changes.
- [ ] B06: Assess gaps and demonstrate tests detect relevant behavioral mutations.
- [ ] B07: Identify first refactoring seam; explain alternatives and choose the smallest useful change.
- [ ] B08: Refactor incrementally with tests and a commit at each coherent step.
- [ ] B09: Specify Conjured naming and edge cases; introduce a failing acceptance test.
- [ ] B10: Implement Conjured behavior and verify existing categories remain unchanged.
- [ ] B11: Review design against change scenarios, compatibility, and complexity.
- [ ] B12: Add reproducible validation instructions and Java CI; publish the branch in the fork.

## First discussion: pending answers

1. Interview format: user proposes changes while Codex challenges and implements,
   or Codex proposes changes and user reviews?
2. First action on unfamiliar legacy code, and evidence needed before modifying it?
3. Ordinary item at sellIn=0, quality=10: expected next state and rationale?
4. Backstage passes at sellIn=11,10,6,5,1,0 with quality=49: expected next states?
5. Requirements versus observed behavior: how to handle a discrepancy, such as
   Aged Brie increasing faster after expiry when that rate is not explicit?
6. What prevents a test suite from merely reproducing implementation mistakes?
7. Preserve Java 8 compatibility, or deliberately migrate the build to Java 17?

## Decisions and evidence

- User decision: complete and accept every existing-business-case validation task
  before changing any production code. Refactoring starts only after this gate.
- Each business case gets its own task, mapped to requirements and linked tests.
  Acceptance requires reviewing that test setup and assertions match the requirement
  and that the tests pass against unchanged production code.
- Red-first TDD is not required for validating existing working behavior. Conjured
  is a new feature and will be handled separately after the validation gate.
- Discussion focuses on engineering approach, not quizzes about business rules.
- No production changes made in this fork yet.
- Upstream Java test is an intentional placeholder: expects name "fixme" from item "foo".
- Existing standalone gilded-rose-java repository is separate from this exercise.

## Existing behavior validation gate

All tasks below must be accepted before B07/B08. Each task must record test
method names and execution evidence when implemented. No task is accepted yet.

- [ ] V01: Ordinary items lose quality and sellIn each day; verify expiry boundary and accelerated decay.
- [ ] V02: Ordinary item quality never falls below zero, including after expiry.
- [ ] V03: Aged Brie gains quality; characterize the existing expired-item rate.
- [ ] V04: Aged Brie never increases above 50, including near the cap and after expiry.
- [ ] V05: Sulfuras retains quality 80 and sellIn before, at, and after expiry.
- [ ] V06: Backstage passes gain quality across both threshold boundaries.
- [ ] V07: Backstage passes never increase above 50.
- [ ] V08: Backstage passes drop to zero after the concert; verify expiry boundary.
- [ ] V09: Names are preserved, unknown names use ordinary behavior, and updates mutate the supplied items.
- [ ] V10: Mixed inventories, repeated daily updates, and empty inventory behave consistently.

V09/V10 are compatibility checks in addition to the explicit business rules.
Conjured acceptance tests are tracked by B09/B10 and do not block the existing
behavior validation gate. A requirement/implementation discrepancy is recorded
for discussion rather than silently fixed during validation.
