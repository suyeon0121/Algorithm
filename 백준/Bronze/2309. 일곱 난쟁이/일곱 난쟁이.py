short_men = [int(input()) for _ in range(9)]
seven_short_temp = []

def dfs(depth, start):
    if depth == 7:
        if sum(seven_short_temp) == 100:
            for j in sorted(seven_short_temp):
                print(j)
            exit()
        else:
            return 

    for i in range(start, len(short_men)):
        seven_short_temp.append(short_men[i])
        dfs(depth + 1, i + 1)
        seven_short_temp.pop()

dfs(0, 0)