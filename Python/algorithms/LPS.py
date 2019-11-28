def dfs(a, l, r, dp):
    if l > r:
        return ''
    if l == r:
        return a[l]
    if a[l] == a[r]:
        return a[l] + dfs(a, l + 1, r - 1, dp) + a[l]
    if dp[l + 1][r] >= dp[l][r - 1]:
        return dfs(a, l + 1, r, dp)
    else:
        return dfs(a, l, r - 1, dp)


def LPS(a):
    n = len(a)
    dp = [[0] * n for _ in range(n)]
    res = 1 if n else 0
    for i in range(n):
        dp[i][i] = 1
        for j in reversed(range(i)):
            if a[i] == a[j]:
                dp[j][i] = dp[j + 1][i - 1] + 2
            else:
                dp[j][i] = max(dp[j + 1][i], dp[j][i - 1])
    return dfs(a, 0, len(a) - 1, dp)


if __name__ == "__main__":
    print(LPS("aavcefewaefaf"))
