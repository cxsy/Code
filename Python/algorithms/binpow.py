def binpow(a, b, m):
    a %= m
    res = 1
    while b:
        if b & 1:
            res = (res * a) % m
        a = (a * a) % m
        b >>= 1
    return res


if __name__ == "__main__":
    print(binpow(2, 10, 13))
