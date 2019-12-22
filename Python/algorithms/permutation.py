# from itertools import permutations
# print(list(permutations(range(1,5))))
class Solution:
    def dfs1(self, li, res, ans):
        if len(res) == len(li) - 1:
            ans.append(res)
            return
        for i in range(1, len(li)):
            if li[i] == 0:
                li[i] = 1
                self.dfs1(li, res + [i], ans)
                li[i] = 0

    def dfs2(self, dic, res, ans, n):
        if len(res) == n:
            ans.append(res)
            return
        for i in dic.keys():
            if dic[i] > 0:
                dic[i] -= 1
                self.dfs2(dic, res + [i], ans, n)
                dic[i] += 1

    def permutations1(self, n):
        li = [0] * (n + 1)
        ans = []
        self.dfs1(li, [], ans)
        print(ans)

    def permutations2(self, s):
        from collections import Counter
        dic = dict(Counter(s))
        ans = []
        self.dfs2(dic, [], ans, len(s))
        print(ans)


if __name__ == '__main__':
    s = Solution()
    # s.permutations1(5)
    s.permutations2('1122')