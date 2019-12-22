class Node:
    def __init__(self, val):
        self.val = val
        self.prev = None
        self.next = None


class LRU:
    def __init__(self, capacity):
        self.capacity = capacity
        self.tail = self.head = Node(-1)
        self.dic = {}

    def push(self, val):
        if val in self.dic:
            self.remove(self.dic[val])
        elif len(self.dic) == self.capacity:
            self.remove(self.head.next)
        self.tail.next = Node(val)
        self.tail.next.prev = self.tail
        self.tail = self.tail.next
        self.dic[val] = self.tail

    def remove(self, node):
        if node == self.tail:
            self.tail = self.tail.prev
            self.tail.next = None
        elif node == self.head.next:
            self.head.next = self.head.next.next
            self.head.next.prev = self.head
        else:
            node.prev.next = node.next
            node.next.prev = node.prev
        self.dic.pop(node.val)

    def show(self):
        cur = self.head.next
        while cur:
            print(cur.val, end=' ')
            cur = cur.next
        print()


if __name__ == '__main__':
    lru = LRU(3)
    for i in [1, 1, 1, 2, 2, 1, 1, 3, 3, 3]:
        lru.push(i)
    lru.show()
