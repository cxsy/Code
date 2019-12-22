#%%
class Solution:
    def solve(self, s):
        from math import factorial as f
        from collections import Counter as cnt
        from itertools import permutations, combinations
        print(list(permutations([1, 2, 2, 2], 4)))
        print(list(combinations([1, 2, 2, 2, 3, 4], 2)))
        res = f(len(s))
        for cnt in cnt(s).values():
            res //= f(cnt)
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.solve("abc"))

#%%
import random
for _ in range(10):
    print(random.randint(0, 10))


# %%
