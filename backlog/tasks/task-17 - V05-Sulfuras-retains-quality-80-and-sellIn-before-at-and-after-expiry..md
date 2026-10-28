---
id: TASK-17
title: 'V05: Sulfuras retains quality 80 and sellIn before, at, and after expiry.'
status: Done
assignee:
  - '@codex'
created_date: '2026-10-28 10:42'
updated_date: '2026-10-28 10:43'
labels:
  - validation
dependencies: []
references:
  - GildedRoseRequirements.md
ordinal: 17000
---

## Description

<!-- SECTION:DESCRIPTION:BEGIN -->
Migrated from the agreed Java kata workflow. Source: GildedRoseRequirements.md. Validate existing behavior against unchanged production code before refactoring. Preserve Item and items; keep the full suite green before each commit.
<!-- SECTION:DESCRIPTION:END -->

## Acceptance Criteria
<!-- AC:BEGIN -->
- [x] #1 Sulfuras retains quality 80 and sellIn before, at, and after expiry.
- [x] #2 Record relevant evidence and test results in this task.
<!-- AC:END -->

## Implementation Plan

<!-- SECTION:PLAN:BEGIN -->
Map requirements and existing behavior to explicit JUnit cases in one test class. Run against unchanged production code; record method names and full-suite evidence before accepting.
<!-- SECTION:PLAN:END -->

## Implementation Notes

<!-- SECTION:NOTES:BEGIN -->
Maven full suite: 47 passed. Production diff against d640790 is empty. Requirements reviewed; test methods: sulfurasNeverChanges
<!-- SECTION:NOTES:END -->

## Final Summary

<!-- SECTION:FINAL_SUMMARY:BEGIN -->
Maven full suite: 47 passed. Production diff against d640790 is empty. Requirements reviewed; test methods: sulfurasNeverChanges
<!-- SECTION:FINAL_SUMMARY:END -->
