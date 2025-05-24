from collections import deque
from itertools import combinations

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

empty = []
virus = []

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            empty.append((i, j))
        elif graph[i][j] == 2:
            virus.append((i, j))

def bfs(temp):
    que = deque(virus)
    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and temp[nx][ny] == 0:
                temp[nx][ny] = 2
                que.append((nx, ny))
    return sum(row.count(0) for row in temp)

answer = 0
for walls in combinations(empty, 3):
    temp_graph = [row[:] for row in graph]  
    for x, y in walls:
        temp_graph[x][y] = 1
    safe = bfs(temp_graph)
    answer = max(answer, safe)

print(answer)