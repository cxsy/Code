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
        return [head.next, cur]


class Solution:
    def two_list_join(self, l1, l2):
        if l1 is None or l2 is None:
            return None
        cur1, cur2 = l1, l2
        while cur1 != cur2:
            cur1 = cur1.next
            cur2 = cur2.next
            if cur1 is None and cur2 is None:
                return -1
            elif cur1 is None:
                cur1 = l2
            elif cur2 is None:
                cur2 = l1
        return cur1.val


if __name__ == '__main__':
    head1, tail1 = Node.toList([1, 2])
    head2, tail2 = Node.toList([3, 4])
    head3, _ = Node.toList([5, 6])
    tail1.next = head3
    tail2.next = head3
    s = Solution()
    print(s.two_list_join(head1, head2))
