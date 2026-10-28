---
id: TASK-12
title: >-
  B12: Add reproducible validation instructions and Java CI; publish the branch
  in the fork.
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
ordinal: 12000
---

## Description

<!-- SECTION:DESCRIPTION:BEGIN -->
Migrated from the agreed Java kata workflow. Source: GildedRoseRequirements.md. Validate existing behavior against unchanged production code before refactoring. Preserve Item and items; keep the full suite green before each commit.
<!-- SECTION:DESCRIPTION:END -->

## Acceptance Criteria
<!-- AC:BEGIN -->
- [x] #1 Add reproducible validation instructions and Java CI; publish the branch in the fork.
- [x] #2 Record relevant evidence and test results in this task.
<!-- AC:END -->

## Implementation Plan

<!-- SECTION:PLAN:BEGIN -->
Add Maven validation instructions and Java CI. Publish the tested java-kata branch to the user fork, preserving the incremental commit history.
<!-- SECTION:PLAN:END -->

## Implementation Notes

<!-- SECTION:NOTES:BEGIN -->
Branch java-kata published to user fork. README documents Maven verify and Backlog.md CLI; Java CI matrix added for JDK 8/17. Local verify: 60 passed on JDK 26. Remote CI not yet verified.
<!-- SECTION:NOTES:END -->

## Final Summary

<!-- SECTION:FINAL_SUMMARY:BEGIN -->
Published incremental solution with package-managed task history, reproducible instructions, and Java CI configuration.
<!-- SECTION:FINAL_SUMMARY:END -->
