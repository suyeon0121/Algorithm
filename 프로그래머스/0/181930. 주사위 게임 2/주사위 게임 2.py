def solution(a, b, c):
    answer = a + b + c
    if a == b == c:
        return answer * (a**2 + b**2 + c**2) * (a**3 + b**3 + c**3)
    elif a != b and a != c and c != b:
        return answer
    else:
        return answer * (a**2 + b**2 + c**2)