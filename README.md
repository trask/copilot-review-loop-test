# copilot-review-loop-test

Private, disposable Java/Gradle fixture for a real Copilot code review. `main` contains a correct array sum and four passing tests. The intentional regression PR skips the final array element, so three tests fail and the empty-array test still passes.

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

## Scope

This repository contains only the target build, source, and tests. Review-loop workflows, helpers, state, logs, and credentials belong in `trask/copilot-workflows`. Matching its Gradle task plan does not authorize a run: its current target policy and unauthenticated checkout do not support this private repository. Central integration requires separate authorization.

The draft PR is intentionally broken for review. Do not repair it before collecting a submitted Copilot review at that exact head. No merge or automatic publication is intended.
