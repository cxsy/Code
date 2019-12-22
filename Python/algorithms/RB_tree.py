class Color:
    RED = 1
    BLACK = 2


class Node:
    key = -1
    p = left = right = None
    color = Color.RED


class RB_tree:
    def __init__(self):
        self.NIL = Node()
        self.NIL.color = Color.BLACK
        self.root = self.NIL

    def RB_TRANSPLANT(self, x, y):
        if x.p == self.NIL:
            self.root = y
        elif x == x.p.left:
            x.p.left = y
        else:
            x.p.right = y
        y.p = x.p

    def INIT_AND_GET_NODE(self, key):
        n = Node()
        n.key = key
        n.p = n.left = n.right = self.NIL
        return n

    def LEFT_ROTATE(self, x):
        y = x.right
        x.right = y.left
        if y.left != self.NIL:
            y.left.p = x
        self.RB_TRANSPLANT(x, y)
        y.left = x
        x.p = y

    def RIGHT_ROTATE(self, x):
        y = x.left
        x.left = y.right
        if y.right != self.NIL:
            y.right.p = x
        self.RB_TRANSPLANT(x, y)
        y.right = x
        x.p = y

    def RB_INSERT(self, key):
        y = self.NIL
        x = self.root
        while x != self.NIL:
            y = x
            if key < x.key:
                x = x.left
            else:
                x = x.right
        z = self.INIT_AND_GET_NODE(key)
        z.p = y
        if y == self.NIL:
            self.root = z
        elif z.key < y.key:
            y.left = z
        else:
            y.right = z
        self.RB_INSERT_FIXUP(z)

    def SOLVE_CASE1(self, y, z):
        z.p.color = Color.BLACK
        y.color = Color.BLACK
        z.p.p.color = Color.RED
        z = z.p.p

    def RB_INSERT_FIXUP(self, z):
        while z.p.color == Color.RED:
            if z.p == z.p.p.left:
                y = z.p.p.right
                if y.color == Color.RED:
                    self.SOLVE_CASE1(y, z)
                else:
                    if z == z.p.right:
                        self.LEFT_ROTATE(z.p)
                        z = z.left
                    z.p.color = Color.BLACK
                    z.p.p.color = Color.RED
                    self.RIGHT_ROTATE(z.p.p)
            else:
                y = z.p.p.left
                if y.color == Color.RED:
                    self.SOLVE_CASE1(y, z)
                else:
                    if z == z.p.left:
                        self.RIGHT_ROTATE(z.p)
                        z = z.right
                    z.p.color = Color.BLACK
                    z.p.p.color = Color.RED
                    self.LEFT_ROTATE(z.p.p)
        self.root.color = Color.BLACK

    def TREE_MINIMUM(self, z):
        while z.left != self.NIL:
            z = z.left
        return z

    def RB_DELETE(self, key):
        z = self.SEARCH(key)
        if z == self.NIL:
            return False
        y = z
        y_original_color = y.color
        if z.left == self.NIL:
            x = z.right
            self.RB_TRANSPLANT(z, z.right)
        elif z.right == self.NIL:
            x = z.left
            self.RB_TRANSPLANT(z, z.left)
        else:
            y = self.TREE_MINIMUM(z.right)
            y_original_color = y.color
            x = y.right
            if y.p == z:
                x.p = y
            else:
                self.RB_TRANSPLANT(y, y.right)
                y.right = z.right
                y.right.p = y
            self.RB_TRANSPLANT(z, y)
            y.left = z.left
            y.left.p = y
            y.color = z.color
        if y_original_color == Color.BLACK:
            self.RB_DELETE_FIXUP(x)

    def RB_DELETE_FIXUP(self, x):
        while x != self.root and x.color == Color.BLACK:
            if x == x.p.left:
                w = x.p.right
                if w.color == Color.RED:
                    w.color = Color.BLACK
                    x.p.color = Color.RED
                    self.LEFT_ROTATE(x.p)
                    w = x.p.right
                if w.left.color == Color.BLACK and w.right.color == Color.BLACK:
                    w.color = Color.RED
                    x = x.p
                else:
                    if w.right.color == Color.BLACK:
                        w.left.color = Color.BLACK
                        w.color = Color.RED
                        self.RIGHT_ROTATE(w)
                        w = x.p.right
                    w.color = x.p.color
                    x.p.color = Color.BLACK
                    w.right.color = Color.BLACK
                    self.LEFT_ROTATE(x.p)
                    x = self.root
            else:
                w = x.p.left
                if w.color == Color.RED:
                    w.color = Color.BLACK
                    x.p.color = Color.RED
                    self.RIGHT_ROTATE(x.p)
                    w = x.p.left
                if w.left.color == Color.BLACK and w.right.color == Color.BLACK:
                    w.color = Color.RED
                    x = x.p
                else:
                    if w.left.color == Color.BLACK:
                        w.right.color = Color.BLACK
                        w.color = Color.RED
                        self.LEFT_ROTATE(w)
                        w = x.p.left
                    w.color = x.p.color
                    x.p.color = Color.BLACK
                    w.left.color = Color.BLACK
                    self.RIGHT_ROTATE(x.p)
                    x = self.root
            x.color = Color.BLACK

    def SEARCH(self, key):
        x = self.root
        while x != self.NIL and key != x.key:
            if key < x.key:
                x = x.left
            else:
                x = x.right
        return self.NIL if x == self.NIL else x


if __name__ == '__main__':
    rb_tree = RB_tree()
    for num in range(10):
        rb_tree.RB_INSERT(num)
    for num in range(3, 7):
        rb_tree.RB_DELETE(num)
    for num in range(0, 15):
        print(rb_tree.SEARCH(num) != rb_tree.NIL)
