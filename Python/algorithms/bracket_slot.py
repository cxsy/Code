class Solution:
    def bracket_slot(self, s):
        n = len(s)
        right = [0] * n
        cnt = 0
        li = list(s)
        for i in reversed(range(n)):
            if s[i] in (')', '?'):
                cnt += 1
            else:
                cnt -= 1
            if cnt < 0:
                return ''
            right[i] = cnt
        cnt = 0
        for i in range(n):
            if s[i] in ('(', '?'):
                li[i] = '('
                cnt += 1
                if cnt == right[i + 1]:
                    for j in range(i + 1, n):
                        if s[j] == '?':
                            li[j] = ')'
                    return ''.join(li)
            else:
                cnt -= 1
        return s


if __name__ == '__main__':
    s = Solution()
    print(s.bracket_slot("((??))"))
