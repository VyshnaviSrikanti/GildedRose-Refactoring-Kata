---
id: doc-2
title: Validation matrix and refactoring decisions
type: other
created_date: '2026-10-28 10:43'
updated_date: '2026-10-28 10:43'
---
# Validation evidence

Upstream d640790; production unchanged at validation gate. Maven test: 47 passed, 0 failures/errors/skips. Java 8 source target retained.

| Task | GildedRoseTest method |
|---|---|
| TASK-13 | ordinaryItemsAgeAndDegrade |
| TASK-14 | ordinaryQualityNeverBecomesNegative |
| TASK-15 | brieImprovesWithAge |
| TASK-16 | brieQualityStopsAtFifty |
| TASK-17 | sulfurasNeverChanges |
| TASK-18 | passesImproveFasterAsConcertApproaches |
| TASK-19 | passesQualityStopsAtFifty |
| TASK-20 | passesBecomeWorthlessAfterConcert |
| TASK-21 | preservesNamesAndUpdatesOriginalItemsAndArray |
| TASK-22 | updatesMixedInventoryAcrossSeveralDays; acceptsEmptyInventory |

Brie after expiry gains two: observed legacy behavior, not an explicit numeric requirement. Conjured remains a separate feature.

Refactoring plan: first introduce a local item reference without changing branches; then separate per-item dispatch from aging rules. Prefer named methods for this fixed set, avoiding a strategy hierarchy until a demonstrated extension need exists. Preserve bounds behavior rather than normalizing invalid inputs.
