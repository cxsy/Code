class Solution:
    def bisect_left(self, arr, target):
        low, high = 0, len(arr) - 1
        while low <= high:
            mid = (low + high) >> 1
            if arr[mid] >= target:
                high = mid - 1
            elif arr[mid] < target:
                low = mid + 1
        return low if 0 <= low < len(arr) and arr[low] == target else -1

    def bisect_right(self, arr, target):
        low, high = 0, len(arr) - 1
        while low <= high:
            mid = (low + high) >> 1
            if arr[mid] > target:
                high = mid - 1
            elif arr[mid] <= target:
                low = mid + 1
        return high if 0 <= low < len(arr) and arr[high] == target else -1


if __name__ == '__main__':
    s = Solution()
    # print(s.bisect_left([1, 2, 3, 3, 3, 4], 3))
    print(s.bisect_right([1, 2, 3, 3, 3, 4], 3))
