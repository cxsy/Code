class Solution:
    def LSB1(self, s):
        sta = []
        res = 0
        for i, c in enumerate(s):
            if c == ')' and sta and s[sta[-1]] == '(':
                sta.pop()
                res = max(res, i - (sta[-1] if sta else -1))
            else:
                sta.append(i)
        return res

    def LSB2(self, s):
        n = len(s)
        dp = [0] * n
        res = 0
        l = r = -1
        for i in range(n):
            if s[i] == ')':
                prev = i - 1 - dp[i - 1]
                if prev >= 0 and s[prev] == '(':
                    dp[i] = 2 + dp[i - 1] + (dp[prev - 1] if prev else 0)
                    if dp[i] > res:
                        l = i - dp[i] + 1
                        r = i
                        res = max(res, dp[i])
        return s[l:r + 1]


if __name__ == "__main__":
    s = Solution()
    print(s.LSB1('()()()()())))()))(()()))))))((()(())'))
    print(s.LSB2('()()()()())))()))(()()))))))((()(())'))
