class Solution:
    def one_two_three_sort(self, arr):
        i1 = i2 = 0
        i3 = len(arr) - 1
        while i2 <= i3:
            if arr[i2] == 1:
                arr[i1], arr[i2] = 1, arr[i1]
                i1 += 1
                i2 += 1
            elif arr[i2] == 2:
                i2 += 1
            elif arr[i2] == 3:
                arr[i2], arr[i3] = arr[i3], 3
                i3 -= 1


if __name__ == "__main__":
    s = Solution()
    arr = [1, 3, 2, 3, 3, 2, 3, 2, 1, 1, 1]
    s.one_two_three_sort(arr)
    print(arr)
