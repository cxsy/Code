class Node:
    def __init__(self, val, h=0):
        self.val = val
        self.height = h
        self.left = self.right = None

    def getMin(self):
        return self.getMin(self.left) if self.left else self.val

    def renewHeight(self):
        self.height = max(Node.getHeight(self.left), Node.getHeight(
            self.right)) + 1

    @classmethod
    def getHeight(cls, node):
        return node.height if node else -1


class AVL:
    def __init__(self):
        self.root = None

    def printTree(self):
        cur = [self.root]
        while cur:
            nex = []
            for c in cur:
                if c is None:
                    print('#', end=' ')
                else:
                    print(c.val, end=' ')
                    nex.extend([c.left, c.right])
            print()
            cur = nex

    @classmethod
    def LLRotate(cls, node):
        nl = node.left
        node.left = nl.right
        nl.right = node
        node.renewHeight()
        nl.renewHeight()
        return nl

    @classmethod
    def RRRotate(cls, node):
        nr = node.right
        node.right = nr.left
        nr.left = node
        node.renewHeight()
        nr.renewHeight()
        return nr

    @classmethod
    def LRRotate(cls, node):
        node.left = cls.RRRotate(node.left)
        return cls.LLRotate(node)

    @classmethod
    def RLRotate(cls, node):
        node.right = cls.LLRotate(node.right)
        return cls.RRRotate(node)

    @classmethod
    def tryLeftBalance(cls, node):
        if Node.getHeight(node.left) == Node.getHeight(node.right) + 2:
            if Node.getHeight(node.left.left) >= Node.getHeight(
                    node.left.right):
                node = cls.LLRotate(node)
            else:
                node = cls.LRRotate(node)
        return node

    @classmethod
    def tryRightBalance(cls, node):
        if Node.getHeight(node.left) + 2 == Node.getHeight(node.right):
            if Node.getHeight(node.right.left) >= Node.getHeight(
                    node.right.right):
                node = cls.RLRotate(node)
            else:
                node = cls.RRRotate(node)
        return node

    @classmethod
    def insert(cls, node, val):
        if node is None:
            return Node(val)
        if node.val > val:
            node.left = cls.insert(node.left, val)
            node = cls.tryLeftBalance(node)
        elif node.val < val:
            node.right = cls.insert(node.right, val)
            node = cls.tryRightBalance(node)
        node.renewHeight()
        return node

    @classmethod
    def remove(cls, node, val):
        if node is None:
            return None
        if node.val > val:
            node.left = cls.remove(node.left, val)
            node = cls.tryRightBalance(node)
        elif node.val < val:
            node.right = cls.remove(node.right, val)
            node = cls.tryLeftBalance(node)
        elif node.left and node.right:
            node.val = node.right.getMin()
            node.right = cls.remove(node.right, node.val)
            node = cls.tryLeftBalance(node)
        else:
            node = node.left if node.left else node.right
        if node:
            node.renewHeight()
        return node

    @classmethod
    def search(cls, node, val):
        if node is None:
            return False
        if node.val == val:
            return True
        if node.val > val:
            return cls.search(node.left, val)
        else:
            return cls.search(node.right, val)


if __name__ == "__main__":
    avl = AVL()
    for i in range(10):
        avl.root = AVL.insert(avl.root, i)
    avl.printTree()
    for i in range(5):
        avl.root = AVL.remove(avl.root, i)
    avl.printTree()
