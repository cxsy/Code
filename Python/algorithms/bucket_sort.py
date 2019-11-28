class Solution:
    def bucket_sort(self, arr, bucket_num):
        from itertools import chain
        minn, maxx = int(1e9), int(-1e9)
        for num in arr:
            minn = min(minn, num)
            maxx = max(maxx, num)
        tw = (maxx - minn) + 1
        w = tw // bucket_num + 1
        buckets = [[] for _ in range(bucket_num)]
        for num in arr:
            buckets[(num - minn) // w].append(num)
        for bucket in buckets:
            bucket.sort()
        return list(chain(*buckets))


if __name__ == "__main__":
    s = Solution()
    print(s.bucket_sort([1, 2, 3, 5, 1, 2, 3, 8, 1, 2, 4], 4))
