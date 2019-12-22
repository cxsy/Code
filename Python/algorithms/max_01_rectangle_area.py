class Solution:
    def helper(self, height):
        sta = []
        ret = 0
        for i in range(len(height)):
            ret = max(ret, height[i])
            while sta and height[sta[-1]] >= height[i]:
                ret = max(ret, (i - sta.pop() + 1) * height[i])
            sta.append(i)
        return max(ret, len(sta) * height[sta[0]])

    def solve(self, arr):
        n, m = len(arr), len(arr[0])
        height = [0] * m
        res = 0
        for i in range(n):
            for j in range(m):
                if arr[i][j] == 1:
                    height[j] += 1
                else:
                    height[j] = 0
            res = max(res, self.helper(height))
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.solve([[1, 1, 1], [1, 1, 0], [1, 0, 0], [1, 0, 0], [1, 0, 0]]))
