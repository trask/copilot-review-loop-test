package fixture;

public final class ArraySum {
  private ArraySum() {}

  public static int sum(int[] values) {
    int total = 0;
    for (int i = 0; i < values.length; i++) {
      total += values[i];
    }
    return total;
  }

  /**
   * Returns the sum of elements at indices from zero to {@code endExclusive}, exclusive.
   *
   * @throws IllegalArgumentException if {@code endExclusive} is outside {@code [0, values.length]}
   */
  public static int sum(int[] values, int endExclusive) {
    if (endExclusive < 0 || endExclusive > values.length) {
      throw new IllegalArgumentException("endExclusive must be between zero and the array length");
    }
    int total = 0;
    for (int i = 0; i < endExclusive; i++) {
      total += values[i];
    }
    return total;
  }
}
