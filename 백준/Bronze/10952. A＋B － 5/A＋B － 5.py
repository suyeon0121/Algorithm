import sys
input = sys.stdin.readline

while 1:
    a, b = list(map(int, input().split()))
    if a == 0 and b == 0:
        break
    else:
        print(a+b)