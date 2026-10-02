# copilot-review-loop-test

Disposable Java/Gradle and Python fixtures in `trask`'s personal repository. The Java fixture on `main` contains a correct array sum and four passing tests. Its intentional regression PR skips the final array element, so three tests fail and the empty-array test still passes.

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

## Python fixture

`python_fixture.sum_values.sum_values(values, initial=0)` accepts an integer sequence, such as a list or tuple. Its contract is to add every element, including the final element, to `initial`. An empty sequence returns `initial`, which defaults to zero. It does not modify the input.

```python
from python_fixture.sum_values import sum_values

sum_values([2, 4, 0])  # 6
sum_values((), initial=7)  # 7
```

Run the standard-library smoke checks from the repository root:

```powershell
python -m unittest discover -s python_fixture -p 'test_*.py' -v
```

On Linux, including the central worker, use:

```bash
python3 -m unittest discover -s python_fixture -p 'test_*.py' -v
```

These checks need no dependencies or Gradle. They cover empty sequences and sequences ending in zero, not the complete summation contract.

The `Fixture Python smoke checks` job runs the same checks on the exact pushed SHA using Ubuntu 24.04's Python. It shares the workflow's read-only permissions and immutable checkout pin, and does not persist checkout credentials.

## Scope

This repository contains the target build, source, tests, and ordinary build/test CI. Review-loop workflows, helpers, state, logs, and credentials belong in `trask/copilot-workflows`. Matching its Gradle task plan does not authorize a review-loop run. Central integration and fix publication require separate authorization.

The Java regression PR is intentionally broken for review. Do not repair that Java fixture before collecting a submitted Copilot review at that exact head and completing central publication gates. Keep fixture PRs in draft; do not merge them.
