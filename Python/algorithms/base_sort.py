class Solution:
    def base_sort(self, arr):
        for i in range(31):
            buckets = [[] for _ in range(2)]
            for num in arr:
                buckets[num >> i & 1].append(num)
            arr = buckets[0] + buckets[1]
        return arr


if __name__ == "__main__":
    s = Solution()
    print(s.base_sort([1, 5, 4, 3, 6, 1, 2, 4, 143414, 314, 134, 5132]))
