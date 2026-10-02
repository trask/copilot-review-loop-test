# Python fixture

For changes under `python_fixture/` or to `.github/workflows/python-fixture-ci.yml`, validate from the repository root with:

```bash
python3 -m unittest python_fixture.test_sum_values -v
```

Use `python` instead of `python3` on Windows. Python 3.10 or newer is required. Do not use Gradle to validate Python-only changes.

Use only the Python standard library. Do not add dependencies or install formatters. Follow PEP 8 with four-space indentation, standard-library imports before local imports, and lines no longer than 88 characters.

Preserve the documented behavior and contract assertions when fixing the implementation.
