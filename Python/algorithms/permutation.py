# from itertools import permutations
# print(list(permutations(range(1,5))))
def dfs(li, res, ans):
    if len(res) == len(li) - 1:
        ans.append(res)
        return
    for i in range(1, len(li)):
        if li[i] == 0:
            li[i] = 1
            dfs(li, res + [i], ans)
            li[i] = 0


def permutations(n):
    li = [0] * (n + 1)
    ans = []
    dfs(li, [], ans)
    print(ans)


if __name__ == '__main__':
    permutations(5)