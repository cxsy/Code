import heapq
arr = []
heapq.heapify(arr)
for num in [2, 1, 3, 6, 2, 43, 2, 1]:
    heapq.heappush(arr, num)
print(heapq.heappop(arr))
