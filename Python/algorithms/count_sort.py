class Solution:
    def count_sort(self, arr):
        minn, maxx = float('inf'), float('-inf')
        for num in arr:
            minn = min(minn, num)
            maxx = max(maxx, num)
        cnt = [0] * (maxx - minn + 1)
        for num in arr:
            cnt[num - minn] += 1
        i = 0
        for d, k in enumerate(cnt):
            for j in range(k):
                arr[i] = minn + d
                i += 1
        return arr


if __name__ == "__main__":
    s = Solution()
    print(s.count_sort([1, 4, 3, 1, 7, 5, 2, 5]))
