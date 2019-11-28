class MINQueue():
    def __init__(self):
        self.deque = []
        self.add_index = 0
        self.remove_index = 0

    def push(self, val):
        while self.deque and self.deque[-1][1] > val:
            self.deque.pop()
        self.deque.append([self.add_index, val])
        self.add_index += 1

    def pop(self):
        if self.remove_index == self.deque[0][0]:
            self.deque.pop(0)
        self.remove_index += 1

    def getMin(self):
        return self.deque[0][1]


if __name__ == '__main__':
    minq = MINQueue()
    arr = [1, 2, -1, 1, 2, 6, 7, 8]
    k = 3
    for i in range(k):
        minq.push(arr[i])
    print(minq.getMin())
    for i in range(k, len(arr)):
        minq.pop()
        minq.push(arr[i])
        print(minq.getMin())
