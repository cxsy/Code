class Solution:
    def two_sorted_array_k_smallest(self, arr1, arr2, k):
        from bisect import bisect_right as br
        minn = min(min(arr1), min(arr2))
        maxx = max(max(arr1), max(arr2))
        l, r = minn, maxx
        while l <= r:
            mid = (l + r) >> 1
            cnt = br(arr1, mid) + br(arr2, mid)
            if cnt >= k:
                r = mid - 1
            else:
                l = mid + 1
        return l

    def two_sorted_array_median(self, arr1, arr2):
        tlen = len(arr1) + len(arr2)
        if tlen % 2 == 1:
            return self.two_sorted_array_k_smallest(arr1, arr2, tlen // 2)
        return (self.two_sorted_array_k_smallest(arr1, arr2, tlen // 2 - 1) +
                self.two_sorted_array_k_smallest(arr1, arr2, tlen // 2)) / 2


if __name__ == "__main__":
    s = Solution()
    print(
        s.two_sorted_array_k_smallest([1, 3, 5, 6, 7, 8], [1, 4, 5, 6, 7, 7],
                                      5))
    print(s.two_sorted_array_median([1, 3, 5, 6, 7, 8], [1, 4, 5, 6, 7, 7]))
