class BIT:
    def __init__(self, arr):
        self.n = len(arr) + 1
        self.bit = [0] * self.n
        for i, num in enumerate(arr):
            self.add(i, num)

    def add(self, i, val):
        i += 1
        while i < self.n:
            self.bit[i] += val
            i += (i & -i)

    def get(self, l, r):
        return self.__get_helper(r) - self.__get_helper(l - 1)

    def __get_helper(self, i):
        i += 1
        ret = 0
        while i > 0:
            ret += self.bit[i]
            i -= (i & -i)
        return ret


if __name__ == '__main__':
    bit = BIT([1, 2, 3, 4, 5, 6])
    bit.add(0, 6)
    print(bit.get(0, 4))
