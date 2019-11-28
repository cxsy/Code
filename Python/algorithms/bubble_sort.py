def bubble_sort(arr):
    n = len(arr)
    for i in reversed(range(n)):
        for j in range(i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


if __name__ == "__main__":
    arr = [49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22]
    bubble_sort(arr)
    print(arr)