class Solution:
    def first_larger_one_in_both_sides(self, arr):
        n = len(arr)
        sta = []
        res = [[-1] * 2 for _ in range(n)]
        # not less than
        # for i in range(n):
        #     while sta and arr[sta[-1]] <= arr[i]:
        #         if res[i][0] == -1 and arr[sta[-1]] == arr[i]:
        #             res[i][0] = sta[-1]
        #         res[sta.pop()][1] = i
        #     if res[i][0] == -1:
        #         res[i][0] = sta[-1] if sta else -1
        #     sta.append(i)
        # return res
        # larger
        for i in range(n):
            while sta and arr[sta[-1]] < arr[i]:
                res[sta.pop()][1] = i
            if sta:
                if arr[sta[-1]] > arr[i]:
                    res[i][0] = sta[-1]
                else:
                    res[i][0] = res[sta[-1]][0]
            else:
                res[i][0] = -1
            sta.append(i)
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.first_larger_one_in_both_sides([1, 1, 1, 1, 1, 1]))
