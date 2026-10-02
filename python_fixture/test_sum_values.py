import unittest

from python_fixture.sum_values import sum_values


class SumValuesSmokeTest(unittest.TestCase):
    def test_empty_list_returns_zero(self):
        self.assertEqual(sum_values([]), 0)

    def test_empty_tuple_preserves_initial(self):
        self.assertEqual(sum_values((), initial=7), 7)

    def test_positive_values_ending_in_zero(self):
        self.assertEqual(sum_values([2, 4, 0]), 6)

    def test_signed_values_ending_in_zero_with_initial(self):
        self.assertEqual(sum_values((5, -3, 0), initial=4), 6)

    def test_final_nonzero_value_is_included(self):
        self.assertEqual(sum_values([2, 4, 5]), 11)


if __name__ == "__main__":
    unittest.main()
