n, m = map(int, input().split())
result = []
visited = [0] * (n+1)

def dfs():
    if len(result) == m:
        print(' '.join(map(str, result)))
        return
    for i in range(1, n+1):
        if visited[i]:
            continue
        visited[i] = 1
        result.append(i)
        dfs()
        result.pop()
        visited[i] = 0

dfs()