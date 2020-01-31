class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = self.next = None


class LRUCache:
    def __init__(self, capacity: int):
        self.dummy = self.tail = Node(0, 0)
        self.dic = dict()
        self.capacity = capacity

    def moveToTail(self, key):
        if self.dic[key] == self.tail: return
        self.dic[key].prev.next = self.dic[key].next
        self.dic[key].next.prev = self.dic[key].prev
        self.dic[key].prev = self.tail
        self.tail.next = self.tail = self.dic[key]

    def tryDeleteHead(self):
        if len(self.dic) < self.capacity: return
        dt = self.dummy.next
        self.dic.pop(dt.key)
        self.dummy.next = dt.next
        if self.dummy.next is None: return
        self.dummy.next.prev = self.dummy

    def createAtEnd(self, key, value):
        self.tail.next = self.dic[key] = Node(key, value)
        self.dic[key].prev = self.tail
        self.tail = self.tail.next

    def get(self, key: int) -> int:
        if key not in self.dic: return -1
        self.moveToTail(key)
        return self.tail.val

    def put(self, key: int, value: int) -> None:
        if key not in self.dic:
            self.tryDeleteHead()
            self.createAtEnd(key, value)
        else:
            self.moveToTail(key)
            self.tail.val = value

if __name__ == '__main__':
    lru = LRUCache(3)
