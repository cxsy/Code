class LFU:
    def __init__(self, capacity):
        import heapq
        self.capacity = capacity
        self.dic = {}

    def push(self, val):
        if val not in self.dic:
            if len(self.dic) == self.capacity:
                self.pop()
            self.dic[val] = 0
        self.dic[val] += 1

    def pop(self):
        val = sorted(self.dic.items(), key=lambda x: x[1])[0][0]
        self.dic.pop(val)

    def show(self):
        print(list(self.dic.items()))


if __name__ == '__main__':
    lfu = LFU(2)
    for i in [1, 1, 1, 2, 3, 2, 2, 2, 1]:
        lfu.push(i)
    lfu.show()
