import sys
input = sys.stdin.readline

s = int(input())

for i in range(s):
    n = input()
    sum = 0
    score = 0
    for i in n:
        if i == 'O':
            score += 1
            sum += score
        else:
            score = 0
    
    print(sum)