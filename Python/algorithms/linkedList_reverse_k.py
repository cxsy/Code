class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class LinkedList:
    def __init__(self, arr):
        self.head = Node(0)
        cur = self.head
        for num in arr:
            cur.next = Node(num)
            cur = cur.next

    @classmethod
    def show(cls, h):
        cur = h.next
        while cur:
            print(cur.val, end=' ')
            cur = cur.next
        print()

    def reverse_k(self, k):
        if k == 1:
            return
        prev = self.head
        p = None
        q = prev.next
        while q:
            cnt = 0
            h = q
            while q and cnt < k:
                temp = q.next
                q.next = p
                p = q
                q = temp
                cnt += 1
            if cnt == k:
                prev.next = p
                prev = h
            else:
                prev.next = LinkedList.reverse(p)
            p = None

    @classmethod
    def reverse(cls, h):
        p = None
        q = h
        while q:
            temp = q.next
            q.next = p
            p = q
            q = temp
        return p


if __name__ == '__main__':
    ll = LinkedList([1, 2, 3, 4, 5, 6, 7])
    ll.reverse_k(3)
    ll.show(ll.head)
