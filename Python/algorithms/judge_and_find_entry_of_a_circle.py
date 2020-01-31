class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

    @classmethod
    def toList(cls, arr):
        cur = head = Node(arr[0])
        for num in arr[1:]:
            cur.next = Node(num)
            cur = cur.next
        return [head, cur]


class Solution:
    def solve(self, li):
        slow = li.next
        if slow is None:
            return -1
        fast = slow.next
        while slow != fast:
            slow = slow.next
            if fast.next is None or fast.next.next is None:
                return -1
            fast = fast.next.next
        slow = li
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return fast.val


if __name__ == '__main__':
    head1, end1 = Node.toList([1, 2, 3])
    end1.next = head1
    head2, end2 = Node.toList([4, 5, 6])
    end2.next = head1
    s = Solution()
    print(s.solve(head2))
