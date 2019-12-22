class Solution:
    def solve(self, num):
        temp = num
        res = []
        while temp:
            res.append(temp)
            temp = (temp - 1) & num
        return res


if __name__ == '__main__':
    s = Solution()
    print(s.solve(13))