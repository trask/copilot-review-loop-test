package fixture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ArraySumTest {
  @Test
  void emptyArrayHasZeroSum() {
    assertEquals(0, ArraySum.sum(new int[] {}));
  }

  @Test
  void includesTheOnlyElement() {
    assertEquals(7, ArraySum.sum(new int[] {7}));
  }

  @Test
  void includesTheFinalElement() {
    assertEquals(9, ArraySum.sum(new int[] {2, 3, 4}));
  }

  @Test
  void includesANegativeFinalElement() {
    assertEquals(-2, ArraySum.sum(new int[] {4, -6}));
  }
}
