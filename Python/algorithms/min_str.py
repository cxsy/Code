class Solution:
    def solve(self, s):
        n = len(s)
        i, j, k = 0, 1, 0
        while i < n and j < n and k < n:
            t = ord(s[(i + k) % n]) - ord(s[(j + k) % n])
            if t == 0: k += 1
            else:
                if t > 0: i = max(i + k + 1, j + 1)
                else: j = max(j + k + 1, i + 1)
                k = 0
        st = min(i, j)
        return s[st:] + s[:st]


if __name__ == '__main__':
    s = Solution()
    print(s.solve('leetcode'))