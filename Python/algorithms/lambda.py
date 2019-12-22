class Solution:
    def solve(self, arr):
        from functools import cmp_to_key as ctk
        get = lambda x: x[0]**2 + x[1]**2
        comp = lambda x, y: get(x) - get(y)
        arr.sort(key=ctk(comp))


if __name__ == '__main__':
    arr = [(2, 0), (-1, 0), (-3, 0), (4, 0)]
    s = Solution()
    s.solve(arr)
    print(arr)
