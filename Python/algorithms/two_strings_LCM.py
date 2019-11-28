class Solution:
    def dfs(self, s1, s2, i, j, dp):
        if i == 0:
            return s2[:j]
        if j == 0:
            return s1[:i]
        if s1[i - 1] == s2[j - 1]:
            return self.dfs(s1, s2, i - 1, j - 1, dp) + s1[i - 1]
        elif dp[i - 1][j] <= dp[i][j - 1]:
            return self.dfs(s1, s2, i - 1, j, dp) + s1[i - 1]
        else:
            return self.dfs(s1, s2, i, j - 1, dp) + s2[j - 1]

    def two_strings_LCM(self, s1, s2):
        n, m = len(s1), len(s2)
        dp = [[0] * (m + 1) for _ in range(n + 1)]
        for i in range(n):
            dp[i + 1][0] = i + 1
        for j in range(m):
            dp[0][j + 1] = j + 1
        for i in range(n):
            for j in range(m):
                if s1[i] == s2[j]:
                    dp[i + 1][j + 1] = 1 + dp[i][j]
                else:
                    dp[i + 1][j + 1] = 1 + min(dp[i][j + 1], dp[i + 1][j])
        print(dp[2][1])
        return self.dfs(s1, s2, n, m, dp)


if __name__ == "__main__":
    s = Solution()
    print(s.two_strings_LCM('abcd', 'acd'))
