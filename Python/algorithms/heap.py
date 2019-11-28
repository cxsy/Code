import heapq
arr = [(2, 0, 0), (1, 1, 1), (-1, 2, 3), (-5, 2, 1)]
heapq.heapify(arr)
print(heapq.nlargest(1, arr))
