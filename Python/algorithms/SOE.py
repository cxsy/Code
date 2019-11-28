from math import sqrt


def SOE(n):
    p = [0, 0] + [1] * (n - 1)
    for i in range(2, int(sqrt(n)) + 1):
        if not p[i]:
            continue
        for t in range(i * i, n + 1, i):
            p[t] = 0
    print(p)


SOE(20)
