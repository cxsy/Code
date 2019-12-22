class Node:
    def __init__(self, val):
        self.left = self.right = None
        self.val = val


class Solution:
    @classmethod
    def serialize(cls, root):
        res = '#'
        cur = [root]
        while cur:
            nex = []
            for node in cur:
                if node is None:
                    res += ',#'
                else:
                    res += ',' + str(node.val)
                    nex.append(node.left)
                    nex.append(node.right)
            cur = nex
        return res

    @classmethod
    def deserialize(cls, str):
        from collections import deque
        root = Node(-1)
        cur = deque([root])
        li = str.split(',')
        for i in range(0, len(li), 2):
            if li[i] == '#':
                cur[0].left = None
            else:
                left = Node(int(li[i]))
                cur[0].left = left
                cur.append(left)
            if li[i + 1] == '#':
                cur[0].right = None
            else:
                right = Node(int(li[i + 1]))
                cur[0].right = right
                cur.append(right)
            cur.popleft()
        return root.right


if __name__ == '__main__':
    s = Solution()
    print(s.serialize(s.deserialize("#,1,2,#,#,#")))
