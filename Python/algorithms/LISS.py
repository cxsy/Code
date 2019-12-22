class Solution:
    def solve1(self, arr):
        from bisect import bisect_left as bl
        li = []
        prev = dict()
        for num in arr:
            i = bl(li, num)
            if i == len(li):
                li.append(num)
            else:
                li[i] = num
            prev[num] = li[i - 1] if i > 0 else -1
        cur = li[-1]
        while cur >= 0:
            print(cur, end=' ')
            cur = prev[cur]
        print()
        return len(li)

    def solve2(self, arr):
        from bisect import bisect_left as bl
        n = len(arr)
        li = []
        prev = dict()
        for i, num in enumerate(arr):
            num += i / n
            i = bl(li, num)
            if i == len(li):
                li.append(num)
            else:
                li[i] = num
            prev[num] = li[i - 1] if i > 0 else -1
        cur = li[-1]
        while cur >= 0:
            print(int(cur), end=' ')
            cur = prev[cur]
        print()
        return len(li)


if __name__ == '__main__':
    s = Solution()
    print(s.solve2([1, 3, 1, 1, 1, 1, 2, 6, 5, 7, 9, 8, 10]))
