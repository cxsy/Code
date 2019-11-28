def quick_sort(arr, low, high):
    if low < high:
        index = getIndex(arr, low, high)
        quick_sort(arr, low, index - 1)
        quick_sort(arr, index + 1, high)


def getIndex(arr, low, high):
    tmp = arr[low]
    while low < high:
        while low < high and arr[high] >= tmp:
            high -= 1
        arr[low] = arr[high]
        while low < high and arr[low] <= tmp:
            low += 1
        arr[high] = arr[low]
    arr[low] = tmp
    return low


arr = [49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22]
quick_sort(arr, 0, len(arr) - 1)
print(arr)
