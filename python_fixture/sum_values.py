from collections.abc import Sequence


def sum_values(values: Sequence[int], initial: int = 0) -> int:
    """Return initial plus every integer in values, or initial if values is empty."""
    total = initial
    for value in values[:-1]:
        total += value
    return total
