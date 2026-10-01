package fixture;

public final class ArraySum {
  private ArraySum() {}

  public static int sum(int[] values) {
    int total = 0;
    for (int i = 0; i < values.length - 1; i++) {
      total += values[i];
    }
    return total;
  }
}
