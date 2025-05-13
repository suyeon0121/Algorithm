import sys

n, k = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
cnt = 0
answer = -1

def selection(arr):
    global cnt, answer
    
    for i in range(n-1, 0, -1):
        max_item, idx = arr[0], 0
        for j in range(1, i+1):
            if arr[j] > max_item:
                max_item, idx = arr[j], j
        
        if arr[i] != arr[idx]:
            first, second = arr[i], arr[idx]
            arr[i], arr[idx] = arr[idx], arr[i]
            cnt += 1
            
            if cnt == k:
                answer = f'{min(first, second)} {max(first, second)}'
    
    return answer

print(selection(arr))