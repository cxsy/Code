def KMP(s, t):
    n = len(s)
    s += '#' + t
    # pi[i]: 满足s[:k] == s[i+1-k:i+1]的最大k
    pi = [0] * len(s)
    for i in range(1, len(s)):
        j = pi[i - 1]  # 找到 前缀 待匹配索引
        while j and s[i] != s[j]:  # 由 长 至 短 搜索 可能匹配字段
            j = pi[j - 1]
        if s[i] == s[j]:  # 若前后缀 待匹配项 相等
            j += 1
        pi[i] = j
        if pi[i] == n:
            return i - 2 * n
    return -1


if __name__ == "__main__":
    print(KMP('abcd', 'vabcd'))
