def solution(code):
    ret = ''
    mode = 0
    
    for idx in range(len(code)):
        if mode == 0:
            if code[idx] != '1' and idx%2 == 0:
                ret += code[idx]
            elif code[idx] == '1':
                mode = 1
        else:
            if code[idx] != '1' and idx%2 != 0:
                ret += code[idx]
            elif code[idx] == '1':
                mode = 0
    if ret == '':
        return "EMPTY"
    
    return ret