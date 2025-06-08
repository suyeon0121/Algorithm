from collections import deque
import sys
input = sys.stdin.readline

f, s, g, u, d = map(int, input().split())
visited = [0 for _ in range(f+1)]
count = [0 for _ in range(f+1)]

def bfs(v):
    que = deque([v])
    visited[v] = 1
    
    while que:
        v = que.popleft()
        
        if v == g:
            return count[g]
        for i in (v+u, v-d):
            if 0 < i <= f and not visited[i]:
                visited[i] = 1
                count[i] = count[v] + 1
                que.append(i)
        
    return "use the stairs"

print(bfs(s))