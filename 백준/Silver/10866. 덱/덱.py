from collections import deque
from sys import stdin

n = int(stdin.readline())
dequeue = deque()

for _ in range(n):
    command = stdin.readline().split()
    if command[0] == 'push_front':
        dequeue.appendleft(command[1])
    elif command[0] == 'push_back':
        dequeue.append(command[1])
    elif command[0] == 'pop_front':
        if dequeue:
            print(dequeue[0])
            dequeue.popleft()
        else:
            print(-1)
    elif command[0] == 'pop_back':
        if dequeue:
            print(dequeue[len(dequeue)-1])
            dequeue.pop()
        else:
            print(-1)
    elif command[0] == 'size':
        print(len(dequeue))
    elif command[0] == 'empty':
        if dequeue:
            print(0)
        else:
            print(1)
    elif command[0] == 'front':
        if dequeue:
            print(dequeue[0])
        else:
            print(-1)
    elif command[0] == 'back':
        if dequeue:
            print(dequeue[-1])
        else:
            print(-1)