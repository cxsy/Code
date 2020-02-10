class Node:
    def __init__(self):
        self.cur = 0  #cur为上层lazy尚未传递下来时的当前值
        self.lazy = 0  #lazy为待传递给下层的值


class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.T = [Node() for _ in range(4 * self.n)]
        self.build(arr)

    def build(self, arr):
        for i, num in enumerate(arr):
            self.add(i, num)

    def renew(self, tn):
        self.T[tn].cur = self.T[tn << 1].cur + self.T[tn << 1 | 1].cur

    # def add(self, index, val):
    #     self.__add_helper(1, 0, self.n, index, val)

    # def __add_helper(self, tn, tl, tr, index, val):
    #     if tl + 1 == tr:
    #         self.T[tn].cur += val
    #     else:
    #         tm = (tl + tr) >> 1
    #         if index < tm:
    #             self.__add_helper(tn << 1, tl, tm, index, val)
    #         else:
    #             self.__add_helper(tn << 1 | 1, tm, tr, index, val)
    #         self.renew(tn)

    def add_range(self, l, r, val):
        self.__add_range_helper(1, 0, self.n, l, r, val)

    def __add_range_helper(self, tn, tl, tr, l, r, val):
        if l >= r: return
        if tl == l and tr == r:
            self.T[tn].cur += (r - l) * val
            self.T[tn].lazy += val
        else:
            self.__push_down(tn, tl, tr)
            tm = (tl + tr) >> 1
            self.__add_range_helper(tn << 1, tl, tm, l, min(tm, r), val)
            self.__add_range_helper(tn << 1 | 1, tm, tr, max(tm, l), r, val)
            self.renew(tn)

    def __push_down(self, tn, tl, tr):
        if self.T[tn].lazy != 0:
            tm = (tl + tr) >> 1
            self.T[tn << 1].cur += (tm - tl) * self.T[tn].lazy
            self.T[tn << 1].lazy += self.T[tn].lazy
            self.T[tn << 1 | 1].cur += (tr - tm) * self.T[tn].lazy
            self.T[tn << 1 | 1].lazy += self.T[tn].lazy
            self.T[tn].lazy = 0

    def get(self, l, r):
        return self.__get_helper(1, 0, self.n, l, r)

    def __get_helper(self, tn, tl, tr, l, r):
        if l >= r: return 0
        if tl == l and tr == r:
            return self.T[tn].cur
        self.__push_down(tn, tl, tr)
        tm = (tl + tr) >> 1
        return self.__get_helper(tn << 1, tl, tm, l, min(
            tm, r)) + self.__get_helper(tn << 1 | 1, tm, tr, max(tm, l), r)


if __name__ == '__main__':
    s = SegmentTree([1, 2, 3, 4, 5, 6])
    s.add_range(0, 3, 2)
    s.add_range(0, 4, 1)
    s.add_range(0, 5, 1)
    print(s.get(0, 4))
