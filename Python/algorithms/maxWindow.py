class Solution:
    def __init__(self, num, size):
        from collections import deque
        self.num = num
        self.size = size
        self.remove_index = 0
        self.deque = deque()

    def add(self, i):
        while self.deque and self.num[self.deque[-1]] <= self.num[i]:
            self.deque.pop()
        self.deque.append(i)

    def remove(self):
        if self.deque[0] == self.remove_index:
            self.deque.popleft()
        self.remove_index += 1

    def get(self):
        return self.num[self.deque[0]]

    def maxInWindows(self):
        for i in range(self.size):
            self.add(i)
        res = [self.get()]
        for i in range(self.size, len(self.num)):
            self.remove()
            self.add(i)
            res.append(self.get())
        return res


if __name__ == "__main__":
    s = Solution([2, 3, 4, 2, 6, 2, 5, 1], 3)
    print(s.maxInWindows())
