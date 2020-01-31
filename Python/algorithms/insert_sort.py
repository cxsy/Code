class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

    @classmethod
    def toList(cls, arr):
        dummy = tail = ListNode(0)
        for num in arr:
            tail.next = tail = ListNode(num)
        return dummy.next

    @classmethod
    def show(cls, head):
        li = []
        while head:
            li.append(head.val)
            head = head.next
        print(li)


class Solution:
    def insert_sort_array(self, arr):
        for i in range(1, len(arr)):
            tmp = arr[i]
            j = i
            while j:
                if arr[j - 1] > tmp:
                    arr[j] = arr[j - 1]
                else:
                    break
                j -= 1
            arr[j] = tmp

    def insert_sort_linkedlist(self, head):
        dummy = tail = ListNode(-1 << 32)
        dummy.next = head
        cur = head
        while cur:
            t = dummy
            while t != tail:
                if t.val < cur.val and t.next.val >= cur.val:
                    tail.next = cur.next
                    cur.next = t.next
                    t.next = cur
                    break
                t = t.next
            else:
                tail = tail.next
            cur = tail.next
        return dummy.next

    def sort_linkedlist(self, head):
        if head is None: return None
        if head.next is None: return head
        slow, fast = head, head.next.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        rh = slow.next
        slow.next = None
        left, right = self.sort_linkedlist(head), self.sort_linkedlist(rh)
        dummy = tail = ListNode(0)
        while left or right:
            if right is None or (left and left.val <= right.val):
                tail.next = tail = left
                left = left.next
            else:
                tail.next = tail = right
                right = right.next
        return dummy.next


if __name__ == "__main__":
    arr = [49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22]
    s = Solution()
    ListNode.show(s.sort_linkedlist(ListNode.toList(arr)))
