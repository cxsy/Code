class Solution:
    def calc(self, x, y, op):
        if op == '+': return x + y
        if op == '-': return x - y
        if op == '*': return x * y
        if op == '/': return x // y if x * y >= 0 else -(abs(x) // abs(y))

    def calculate1(self, s: str) -> int:
        # return eval(s.replace('/', '//'))

        def findPaired(i, expr):
            cnt = 1
            for j in range(i + 1, len(expr)):
                if expr[j] == '(': cnt += 1
                elif expr[j] == ')': cnt -= 1
                if cnt == 0: return j
            return -1

        def dfs(expr):
            res = curRes = i = num = 0
            op = '+'
            while i <= len(expr):
                if i < len(expr) and expr[i].isdigit():
                    num = num * 10 + int(expr[i])
                elif i < len(expr) and expr[i] == '(':
                    j = i
                    i = findPaired(i, expr)
                    num = dfs(expr[j + 1:i])
                    i += 1
                if i == len(expr) or not expr[i].isdigit():
                    curRes = calc(curRes, num, op)
                    if i == len(expr) or expr[i] in ('+', '-'):
                        res += curRes
                        curRes = 0
                    num = 0
                    if i < len(expr): op = expr[i]
                i += 1
            return res

        s = s.replace(' ', '')
        return dfs(s)

    def calculate2(self, s):
        dic = dict(zip('*/+-()', [2, 2, 1, 1, 0, 0]))

        def getReversePolish(s):
            operators = []
            operands = [0] if s[0] in ('+', '-') else []
            num = ''
            for i, c in enumerate(s):
                if c == ' ': continue
                if c.isdigit():
                    num += c
                else:
                    if num:
                        operands.append(int(num))
                        num = ''
                    if c == '(':
                        operators.append('(')
                        if s[i + 1] in ('+', '-'):
                            operands.append(0)
                    elif c == ')':
                        while operators[-1] != '(':
                            operands.append(operators.pop())
                        operators.pop()
                    else:
                        while operators and dic[c] <= dic[operators[-1]]:
                            operands.append(operators.pop())
                        operators.append(c)
            if num: operands.append(int(num))
            while operators:
                operands.append(operators.pop())
            return operands

        reversePolish = getReversePolish(s)
        stack = []
        for item in reversePolish:
            if item not in dic:
                stack.append(item)
            else:
                a = stack.pop()
                b = stack.pop()
                stack.append(calc(b, a, item))
        return stack.pop()
