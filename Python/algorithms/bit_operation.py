import numpy as np


class Solution:
    @classmethod
    def add(cls, num1, num2):
        while num2 != 0:
            temp = np.int32((num1 ^ num2))
            num2 = np.int32((num1 & num2) << 1)
            num1 = temp
        return num1

    @classmethod
    def neg(cls, num):
        return cls.add(np.int32(~num), 1)

    @classmethod
    def minus(cls, num1, num2):
        return cls.add(num1, cls.neg(num2))

    @classmethod
    def multi(cls, num1, num2):
        ans = 0
        while num2 != 0:
            if num2 & 1:
                ans = np.int32(cls.add(ans, np.int32(num1)))
            num2 >>= 1
            num1 <<= 1
        return ans


if __name__ == '__main__':
    s = Solution()
    print(s.multi(-99, 11000))
