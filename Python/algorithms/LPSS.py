class Solution:
    def solve1(s):
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        res = 1 if n else 0
        for i in range(n):
            dp[i][i] = True
            for j in reversed(range(i)):
                if s[i] == s[j]:
                    dp[j][i] = True if i - j == 1 else dp[j + 1][i - 1]
                    if dp[j][i]:
                        res = max(res, i - j + 1)
        return res

    def solve2(self, s):
        if len(s) in (0, 1): return s
        n = len(s)
        li = ['$', '#'] + [''] * 2 * n
        li[2::2] = list(s)
        li[3::2] = ['#'] * n
        li.append('%')
        cur_end = cur_center = 0
        res_center = res_len = 0
        dp = [0] * len(li)
        for i in range(1, len(li) - 1):
            dp[i] = min(dp[2 * cur_center - i], cur_end -
                        i) if cur_end > i else 1
            while li[i + dp[i]] == li[i - dp[i]]:
                dp[i] += 1
            if cur_end < i + dp[i]:
                cur_end = i + dp[i]
                cur_center = i
            if res_len < dp[i]:
                res_len = dp[i]
                res_center = i
        left = (res_center - res_len) // 2
        return s[left:left + res_len - 1]


if __name__ == '__main__':
    s = Solution()
    print(s.solve2("aaba"))
