import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
temp = list(map(int, sys.stdin.readline().split()))
que = deque(_ for _ in range(1, n+1))

count = 0
for i in temp:
    while True:
        if que[0] == i:
            que.popleft()
            break
        else:
            if que.index(i) < len(que) / 2:
                while que[0] != i:
                    que.append(que.popleft())
                    count += 1
            else:
                while que[0] != i:
                    que.appendleft(que.pop())
                    count += 1
print(count)