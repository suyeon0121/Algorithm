import sys
input = sys.stdin.readline

while True:
    try:
        a, b = list(map(int, input().split()))   
        print(a+b)
    except:
        break