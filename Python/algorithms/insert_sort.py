def insert_sort(arr):
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


if __name__ == "__main__":
    arr = [49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22]
    insert_sort(arr)
    print(arr)
