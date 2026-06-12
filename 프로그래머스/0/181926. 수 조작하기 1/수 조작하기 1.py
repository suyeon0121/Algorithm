def solution(n, control):
    for word in range(len(control)):
        if control[word] == 'w':
            n += 1
        elif control[word] =='s':
            n -= 1
        elif control[word] == 'd':
            n += 10
        else:
            n -= 10
        
    return n