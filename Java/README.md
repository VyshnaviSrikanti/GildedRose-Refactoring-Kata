# Gilded Rose starting position in Java

## Refactored solution

Run the 60 JUnit cases and package the project with Maven 3 and a JDK:

```sh
mvn --batch-mode verify
```

The existing Java 8 source target is retained. CI uses JDK 8 and 17; local
validation used JDK 26. JDK 8 runtime compatibility is checked by CI, not by the
local run. Existing Gradle/TextTest instructions below remain upstream guidance;
this solution was verified through Maven.

### Design and assumptions

`GildedRose` routes names to small methods for Brie, passes, and degrading items.
Sulfuras returns without changing either field. Quality helpers enforce the
upper/lower bounds at the point of change. The day advances once per item;
expiry checks use the updated sellIn, preserving the legacy update order.
`Item` and the `items` property are unchanged.

Ordinary and Conjured items share the same aging sequence with a daily decay
rate of one or two. Conjured names are case-sensitive: exactly `Conjured` or
starting with `Conjured `; `Conjuredness` is ordinary. This naming convention is
an explicit assumption because the requirements do not define classification.
Brie's increase of two after expiry is characterized legacy behavior.

Named methods fit this small fixed set of rules. A new category needs a routing
case and its rule; an independently growing catalog could justify extracting
policies later. There is no registry, dependency injection or class hierarchy
because the current extension does not need one. Public mutable items remain
because kata compatibility requires them; null inputs and invalid initial
quality are outside the specified contract, with no new validation added.

### Evidence and task tracking

All 47 existing-behavior cases passed before production changes. The first
commit replaced indexed access; the next separated routing and item rules.
Before Conjured, 262,440 daily-state comparisons matched upstream. The 13 new
feature cases produced eight expected failures, then all 60 passed with the
feature implemented. Tests stay in one class and assert observable behavior.

The repository uses the Backlog.md package (not a checklist named backlog.md):

```sh
backlog task list --plain
backlog board
```

Task files and decisions are under `../backlog/`. Use the CLI to update them.

## Run the TextTest Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

You should make sure the gradle commands shown above work when you execute them in a terminal before trying to use TextTest (see below).


## Run the TextTest approval test that comes with this project

There are instructions in the [TextTest Readme](../texttests/README.md) for setting up TextTest. What's unusual for the Java version is there are two executables listed in [config.gr](../texttests/config.gr) for Java. The first uses Gradle wrapped in a python script. Uncomment these lines to use it:

    executable:${TEXTTEST_HOME}/Java/texttest_rig.py
    interpreter:python

The other relies on your CLASSPATH being set correctly in [environment.gr](../texttests/environment.gr). Uncomment these lines to use it instead:

    executable:com.gildedrose.TexttestFixture
    interpreter:java
