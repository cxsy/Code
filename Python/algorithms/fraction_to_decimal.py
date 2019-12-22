class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        return '-' if numerator * denominator < 0 else '' + self.non_negtive(
            abs(numerator), abs(denominator))

    def non_negtive(self, numerator: int, denominator: int) -> str:
        decimal = []
        dic = {}
        int_part = numerator // denominator
        numerator %= denominator
        if numerator == 0:
            return str(int_part)
        while numerator:
            if numerator not in dic:
                dic[numerator] = len(decimal)
                decimal.append(str(numerator * 10 // denominator))
            else:
                i = dic[numerator]
                return str(int_part) + '.' + ''.join(
                    decimal[:i]) + '(' + ''.join(decimal[i:]) + ')'
            numerator = numerator * 10 % denominator
        return str(int_part) + '.' + ''.join(decimal)


if __name__ == '__main__':
    s = Solution()
    print(s.fractionToDecimal(1, 6))
