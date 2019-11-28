def LPSS(a):
    n = len(a)
    dp = [[False] * n for _ in range(n)]
    res = 1 if n else 0
    for i in range(n):
        dp[i][i] = True
        for j in reversed(range(i)):
            if a[i] == a[j]:
                dp[j][i] = True if i - j == 1 else dp[j + 1][i - 1]
                if dp[j][i]:
                    res = max(res, i - j + 1)
    return res

print(LPSS("abcbaa"))
