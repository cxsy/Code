class Solution:
    def digitsCount(self, d: int, low: int, high: int) -> int:

        def helper(n):
            if n < 10:  return int(d <= n)
            res = 0
            i = 1
            while i <= n:
                high = n // (i * 10)
                cur = (n // i) % 10
                low = n % i
                if cur < d:
                    res += high * i
                elif cur == d:
                    res += max(0, high - int(d == 0)) * i + low + 1
                else:
                    res += (high + int(d > 0)) * i
                i *= 10
            return res if d else res + 1

        return helper(high) - helper(low - 1)