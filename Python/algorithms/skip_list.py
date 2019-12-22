class Node:
    def __init__(self, val, right, down):
        self.right, self.down, self.val = right, down, val


class Skiplist:
    def __init__(self):
        self.head = Node(-1, None, None)

    def getTargetOrPrev(self, target):
        cur = self.head
        li = []
        seen = False
        while cur:
            while cur.right and cur.right.val < target:
                cur = cur.right
            if cur.right and cur.right.val == target:
                seen = True
            li.append(cur)
            cur = cur.down
        return [seen, li]

    def search(self, target: int) -> bool:
        return self.getTargetOrPrev(target)[0]

    def add(self, num: int) -> None:
        from random import choice
        li = self.getTargetOrPrev(num)[1]
        downNode = None
        insertUp = True
        for node in li[::-1]:
            if insertUp:
                node.right = Node(num, node.right, downNode)
                downNode = node.right
            else:
                break
            insertUp = choice([True, False])
        if insertUp:
            self.head = Node(-1, Node(num, None, downNode), self.head)

    def erase(self, num: int) -> bool:
        res, li = self.getTargetOrPrev(num)
        if not res: return False
        for node in li[::-1]:
            if node.right and node.right.val == num:
                node.right = node.right.right
            else:
                break
        return True
