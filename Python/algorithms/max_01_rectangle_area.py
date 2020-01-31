class Solution:
    def helper(self, heights):
        sta = []
        ret = 0
        for i in range(len(heights) + 1):
            while sta and (i == len(heights) or heights[sta[-1]] >= heights[i]):
                h = heights[sta.pop()]
                w = i - 1 - (sta[-1] if sta else -1)
                ret = max(ret, h * w)
            sta.append(i)
        return ret

    def solve(self, arr):
        n, m = len(arr), len(arr[0])
        heights = [0] * m
        res = 0
        for i in range(n):
            for j in range(m):
                if arr[i][j] == 1:
                    heights[j] += 1
                else:
                    heights[j] = 0
            res = max(res, self.helper(heights))
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.solve([[1, 1, 1], [1, 1, 0], [1, 0, 0], [1, 0, 0], [1, 0, 0]]))
