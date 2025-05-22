from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

n, m = map(int, input().split())
graph = []

for _ in range(m):
    graph.append(list(map(int, input().split())))
    
que = deque()
    
for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            que.append((i, j)) 
    
def bfs():
    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                que.append((nx, ny))

bfs()
day = 0
for i in graph:
    for tomato in i:
        if tomato == 0:
            print(-1)
            exit(0)
    
    day = max(day, max(i))
    
print(day-1)
            