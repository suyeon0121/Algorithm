from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    que = deque()
    que.append((x, y))
    graph[x][y] = 0
    
    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and graph[nx][ny] == 1:
                graph[nx][ny] = 0
                que.append([nx, ny])

t = int(input())

for _ in range(t):
    m, n, k = map(int, input().split())
    graph = [[0] * n for _ in range(m)]
    for i in range(k):
        x, y = map(int, input().split())
        graph[x][y] = 1
        
    cnt1 = 0
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                bfs(i, j)
                cnt1 += 1

    print(cnt1)
