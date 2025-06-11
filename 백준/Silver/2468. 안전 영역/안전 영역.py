from collections import deque

n = int(input())
graph = []
num = 0

for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        if graph[i][j] > num:
            num = graph[i][j]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, value, visited):
    que = deque()
    que.append((x, y))
    visited[x][y] = 1

    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] > value and not visited[nx][ny]:
                que.append((nx, ny))
                visited[nx][ny] = 1

result = 0
for i in range(num):
    visited = [[0] * n for i in range(n)]
    cnt = 0
    
    for j in range(n):
        for k in range(n):
            if graph[j][k] > i and visited[j][k] == 0:
                bfs(j, k, i, visited)
                cnt += 1
    
    if result < cnt:
        result = cnt

print(result)