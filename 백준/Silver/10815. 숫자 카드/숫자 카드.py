n = int(input())
temp = set(map(int, input().split()))
m = int(input())
arr = list(map(int, input().split()))

for num in arr:
    if num in temp:
        print(1, end=' ')
    else:
        print(0, end=' ')
