def merge_sort_main(arr):
    return merge_sort(arr, 0, len(arr))


def merge_sort(arr, l, r):
    if l >= r - 1: return 0
    mid = (l + r) >> 1
    return merge_sort(arr, l, mid) + merge_sort(arr, mid, r) + merge(
        arr, l, arr[l:mid], arr[mid:r])


def merge(arr, l, arr1, arr2):
    i = l
    i1 = i2 = 0
    rp = 0
    while i1 < len(arr1) or i2 < len(arr2):
        if i2 == len(arr2) or (i1 < len(arr1) and arr1[i1] <= arr2[i2]):
            arr[i] = arr1[i1]
            i1 += 1
        else:
            rp += len(arr1) - i1
            arr[i] = arr2[i2]
            i2 += 1
        i += 1
    return rp


if __name__ == '__main__':
    arr = [3, 5, 1, 2, 8, 4]
    print(merge_sort_main(arr))