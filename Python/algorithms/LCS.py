def dfs(a, b, i, j, dp):
    if i == 0 or j == 0:
        return ''
    if a[i - 1] == b[j - 1]:
        return dfs(a, b, i - 1, j - 1, dp) + a[i - 1]
    if dp[i - 1][j] >= dp[i][j - 1]:
        return dfs(a, b, i - 1, j, dp)
    else:
        return dfs(a, b, i, j - 1, dp)


def LCS(a, b):
    n, m = len(a), len(b)
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    res = 0
    for i in range(n):
        for j in range(m):
            if a[i] == b[j]:
                dp[i + 1][j + 1] = dp[i][j] + 1
            else:
                dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j])
    return dfs(a, b, len(a), len(b), dp)


if __name__ == "__main__":
    print(LCS("avcds", "acds"))
