# Summing integer sequences

`sum_values(values, initial=0)` adds every integer in a list or tuple to an optional initial value without modifying the input. Empty sequences return the initial value.

```python
from python_fixture import sum_values

sum_values([2, 3, 5])  # 10
sum_values([4, -7, 9], initial=10)  # 16
sum_values([], initial=12)  # 12
```

Run the contract tests from the repository root with Python 3.10 or newer:

```bash
python3 -m unittest python_fixture.test_sum_values -v
```

On Windows, use `python` instead of `python3`. The function and tests use only the Python standard library. The `Python unittest checks` CI job runs the same command against the exact pushed commit using the Python already installed on the Ubuntu Actions runner.
