n, m = list(map(int, input().split()))
box = [0]*n

for _ in range(m):
    i, j, k = list(map(int, input().split()))
    
    for idx in range(i, j+1):
        box[idx-1] = k
    
for i in range(n):
    print(box[i], end=' ')