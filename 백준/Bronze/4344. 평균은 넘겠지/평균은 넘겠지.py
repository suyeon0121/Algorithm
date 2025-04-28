import sys
input = sys.stdin.readline

c = int(input())

for i in range(c):
    data = list(map(int, input().split()))
    
    n = data[0]
    scores = data[1:]
    
    average = sum(scores)/n
    count = sum(1 for s in scores if s > average)
    percentage = float((count/n)*100)
    
    print(f"{percentage:.3f}%")