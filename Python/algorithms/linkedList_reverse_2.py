class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

    @classmethod
    def toList(cls, arr):
        cur = head = Node(0)
        for num in arr:
            cur.next = Node(num)
            cur = cur.next
        return head.next

    @classmethod
    def printList(cls, li):
        while li:
            print(li.val, end=' ')
            li = li.next
        print()


class Solution:
    def solve(self, li):
        prev = head = Node(0)
        p = li
        while p:
            q = p.next
            if q is None:
                prev.next = p
                break
            temp = q.next
            prev.next = q
            q.next = p
            p.next = None
            prev = p
            p = temp
        return head.next


if __name__ == '__main__':
    li = Node.toList([1, 2, 3, 4, 5, 6])
    s = Solution()
    Node.printList(s.solve(li))
