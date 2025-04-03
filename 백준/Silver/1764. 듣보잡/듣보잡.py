import sys
N, M = map(int, sys.stdin.readline().strip().split())

a = set()
b = set()

for _ in range(N):
    a.add(sys.stdin.readline().strip())

for _ in range(M):
    b.add(sys.stdin.readline().strip())

result = sorted(list(a & b))

print(len(result))

for x in result:
    print(x)
