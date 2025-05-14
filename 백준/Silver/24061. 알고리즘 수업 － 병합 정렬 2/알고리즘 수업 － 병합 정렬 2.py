def merge_sort(arr, left, right):
    global count, k, result_after_k

    if left < right:
        mid = (left + right) // 2
        merge_sort(arr, left, mid)
        merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)

def merge(arr, left, mid, right):
    global count, k, result_after_k

    temp = []
    i = left
    j = mid + 1

    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            temp.append(arr[i])
            i += 1
        else:
            temp.append(arr[j])
            j += 1

    while i <= mid:
        temp.append(arr[i])
        i += 1
    while j <= right:
        temp.append(arr[j])
        j += 1

    for i in range(len(temp)):
        arr[left + i] = temp[i]
        count += 1
        if count == k:
            result_after_k = arr[:]

n, k = map(int, input().split())
arr = list(map(int, input().split()))

count = 0
result_after_k = []

merge_sort(arr, 0, n - 1)

if result_after_k:
    print(' '.join(map(str, result_after_k)))
else:
    print(-1)