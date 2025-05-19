import sys
sys.setrecursionlimit(5000)
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
cnt = 0

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n + 1)
def dfs(e):
    visited[e] = True
    for i in graph[e]:
        if not visited[i]:
            dfs(i)

cnt = 0
for i in range(1, n+1):
    if not visited[i]:
        dfs(i)
        cnt += 1

print(cnt)  