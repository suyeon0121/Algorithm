n = int(input())
graph = []

for i in range(n):
    graph.append(list(map(int, input())))
    
def dfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    graph[x][y] = 0
    cnt = 1
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1:
            cnt += dfs(nx, ny)
    
    return cnt

result = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            result.append(dfs(i, j))

print(len(result))
result.sort()
for i in result:
    print(i)