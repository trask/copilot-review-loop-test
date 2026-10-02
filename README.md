# copilot-review-loop-test

Disposable Java/Gradle fixture for a real Copilot code review in `trask`'s personal repository.

`ArraySum.sum(int[] values)` sums an integer array. `ArraySum.sum(int[] values, int initialValue)` adds every array element to an initial total. For example, `ArraySum.sum(new int[] {2, 3, 4}, 10)` returns `19`. Tests cover empty arrays, single elements, and positive and negative final elements for both overloads.

## Validation

Use JDK 17 or newer, with `JAVA_HOME` pointing to the JDK that provides `java` on `PATH`. Gradle 8.14.3 is pinned by the wrapper and its distribution SHA-256 checksum.

On Windows:

```powershell
.\gradlew.bat --no-daemon :fixture:spotlessApply
.\gradlew.bat --no-daemon :fixture:spotlessJavaCheck :fixture:test
```

On Linux, the central validator's plan for a change under `fixture/src/main/java` or `fixture/src/test/java` is:

```bash
/bin/bash ./gradlew --no-daemon :fixture:spotlessJavaCheck :fixture:test
```

The module uses standard Java main/test source sets, JUnit 5.11.4, and Spotless 7.0.4 with Google Java Format 1.24.0. Spotless supplies the formatting task required by the existing central validator.

`.github/workflows/fixture-ci.yml` runs these check/test tasks on every push, including `main` and the PR's source branch. The `Fixture Gradle checks` job checks out the exact pushed SHA and uses Ubuntu 24.04 with Temurin JDK 21.0.12+8, pinned as `21.0.12+8.0.LTS` in `setup-java`. It has read-only permissions, does not persist checkout credentials, and does not restore caches. There is no PR merge-commit check; the intentional bug must produce a failed check at the source head.

## Scope

This repository contains the target build, source, tests, and ordinary build/test CI. Review-loop workflows, helpers, state, logs, and credentials belong in `trask/copilot-workflows`. Matching its Gradle task plan does not authorize a review-loop run. Central integration and fix publication require separate authorization.

The draft PR is intentionally broken for review. Do not repair it before collecting a submitted Copilot review at that exact head and completing central publication gates. Keep the PR in draft; do not merge it.
