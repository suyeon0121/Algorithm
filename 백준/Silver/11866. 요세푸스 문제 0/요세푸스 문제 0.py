from collections import deque

N, K = map(int, input().split())

queque = deque(range(1, N+1))
answer = []

while queque:
    for _ in range(K-1):
        queque.append(queque.popleft())
    answer.append(queque.popleft())
    
print(str(answer).replace('[', '<').replace(']', '>'))