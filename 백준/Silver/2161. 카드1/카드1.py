from collections import deque

n = int(input())
que = deque(_ for _ in range(1, n+1))
answer = []

while (len(que) > 1):
    answer.append(que.popleft())
    que.append(que.popleft())

print(*answer, que[0])