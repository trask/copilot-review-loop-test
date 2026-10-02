from collections.abc import Sequence


def sum_values(values: Sequence[int], initial: int = 0) -> int:
    """Return the sum of all values plus initial without modifying values."""
    total = initial
    for value in values:
        total += value
    return total
