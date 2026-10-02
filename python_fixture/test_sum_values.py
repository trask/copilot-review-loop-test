import unittest

from python_fixture import sum_values


class SumValuesTest(unittest.TestCase):
    def test_empty_values(self):
        self.assertEqual(sum_values([]), 0)

    def test_empty_values_preserve_initial(self):
        self.assertEqual(sum_values([], initial=12), 12)

    def test_single_value(self):
        self.assertEqual(sum_values([7]), 7)

    def test_multiple_values_without_mutation(self):
        values = [2, 3, 5]
        result = sum_values(values)
        self.assertEqual(values, [2, 3, 5])
        self.assertEqual(result, 10)

    def test_signed_values_with_initial(self):
        self.assertEqual(sum_values([4, -7, 9], initial=10), 16)

    def test_tuple_values(self):
        self.assertEqual(sum_values((1, 2, 4)), 7)


if __name__ == "__main__":
    unittest.main()
