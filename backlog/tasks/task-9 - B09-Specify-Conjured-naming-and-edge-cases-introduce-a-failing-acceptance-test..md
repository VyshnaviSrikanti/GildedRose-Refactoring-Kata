---
id: TASK-9
title: >-
  B09: Specify Conjured naming and edge cases; introduce a failing acceptance
  test.
status: Done
assignee:
  - '@codex'
created_date: '2026-10-28 10:42'
updated_date: '2026-10-28 10:45'
labels:
  - workflow
dependencies: []
references:
  - GildedRoseRequirements.md
ordinal: 9000
---

## Description

<!-- SECTION:DESCRIPTION:BEGIN -->
Migrated from the agreed Java kata workflow. Source: GildedRoseRequirements.md. Validate existing behavior against unchanged production code before refactoring. Preserve Item and items; keep the full suite green before each commit.
<!-- SECTION:DESCRIPTION:END -->

## Acceptance Criteria
<!-- AC:BEGIN -->
- [x] #1 Specify Conjured naming and edge cases; introduce a failing acceptance test.
- [x] #2 Record relevant evidence and test results in this task.
<!-- AC:END -->

## Implementation Plan

<!-- SECTION:PLAN:BEGIN -->
Add Conjured decay and floor cases plus mixed inventory coverage. Use exact Conjured and Conjured-space prefix; special existing names retain exact matching. Demonstrate new tests fail while prior tests pass.
<!-- SECTION:PLAN:END -->

## Implementation Notes

<!-- SECTION:NOTES:BEGIN -->
Added 13 feature cases. Red phase: 60 tests, 8 failures, all in Conjured feature methods. Naming assumption: exact Conjured or Conjured-space prefix, case sensitive; Conjuredness remains ordinary. All previous 47 cases still pass.
<!-- SECTION:NOTES:END -->

## Final Summary

<!-- SECTION:FINAL_SUMMARY:BEGIN -->
New feature tests demonstrated missing Conjured behavior before implementation.
<!-- SECTION:FINAL_SUMMARY:END -->
