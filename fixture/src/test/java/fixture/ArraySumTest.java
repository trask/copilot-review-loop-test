package fixture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  void emptyPrefixHasZeroSum() {
    assertEquals(0, ArraySum.sum(new int[] {}, 0));
    assertEquals(0, ArraySum.sum(new int[] {7}, 0));
  }

  @Test
  void singleElementPrefixIncludesItsElement() {
    assertEquals(7, ArraySum.sum(new int[] {7}, 1));
  }

  @Test
  void prefixExcludesElementsAfterTheBound() {
    assertEquals(5, ArraySum.sum(new int[] {2, 3, 4}, 2));
  }

  @Test
  void fullLengthPrefixIncludesTheFinalElement() {
    assertEquals(-2, ArraySum.sum(new int[] {4, -6}, 2));
  }

  @Test
  void rejectsNegativePrefixBound() {
    assertThrows(IllegalArgumentException.class, () -> ArraySum.sum(new int[] {7}, -1));
  }

  @Test
  void rejectsPrefixBoundBeyondArrayLength() {
    assertThrows(IllegalArgumentException.class, () -> ArraySum.sum(new int[] {7}, 2));
  }
}
