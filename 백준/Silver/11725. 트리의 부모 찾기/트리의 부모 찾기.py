import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
parent = [0] * (n+1)

for _ in range(n-1):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def dfs(n):
    visited[n] = True
    for node in graph[n]:
        if not visited[node]:
            parent[node] = n
            dfs(node)

dfs(1)

for i in range(2, n+1):
    print(parent[i])