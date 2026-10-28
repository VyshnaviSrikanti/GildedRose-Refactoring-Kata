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

- No production changes made in this fork yet.
- Upstream Java test is an intentional placeholder: expects name "fixme" from item "foo".
- Existing standalone gilded-rose-java repository is separate from this exercise.
