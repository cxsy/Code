class LFU:
    def __init__(self, capacity):
        import heapq
        self.capacity = capacity
        self.dic = {}
        self.pq = []
        heapq.heapify(self.pq)

    def push(self, val):
        import heapq
        if val not in self.dic:
            if len(self.dic) == self.capacity:
                self.pop()
            self.dic[val] = 0
        self.dic[val] += 1
        heapq.heappush(self.pq, (self.dic[val], val))

    def pop(self):
        import heapq
        cnt, val = heapq.heappop(self.pq)
        while cnt < self.dic[val]:
            cnt, val = heapq.heappop(self.pq)
        self.dic.pop(val)

    def show(self):
        print(list(self.dic.items()))


if __name__ == '__main__':
    lfu = LFU(2)
    for i in [1, 1, 1, 2, 3, 2, 2, 2, 1]:
        lfu.push(i)
    lfu.show()
