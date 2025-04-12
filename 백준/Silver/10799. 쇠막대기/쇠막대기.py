question = input()
stack = []
answer = 0

for i in range(len(question)):
    if question[i] == '(':
        stack.append('(')
    else:
        stack.pop()
        if question[i-1] == '(':
            answer += len(stack)
        else: answer += 1
    
print(answer)