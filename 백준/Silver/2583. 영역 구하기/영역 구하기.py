import sys
input = sys.stdin.readline
from collections import deque
m, n, k = map(int, input().split())
arr = [[0] * m for _ in range(n)]

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(x1, x2):     
        for j in range(y1, y2): 
            arr[i][j] = 1       

answer = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    q = deque()
    q.append([x, y])
    arr[x][y] = 1  
    cnt = 1

    while q:
        x1, y1 = q.popleft()
        for i in range(4):
            nx = x1 + dx[i]
            ny = y1 + dy[i]

            if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 0:
                q.append([nx, ny])
                arr[nx][ny] = 1 
                cnt += 1
    return cnt

for i in range(n):
    for j in range(m):
        if arr[i][j] == 0:
            answer.append(bfs(i, j))

answer.sort()
print(len(answer))

for i in answer:
    print(i, end=" ")