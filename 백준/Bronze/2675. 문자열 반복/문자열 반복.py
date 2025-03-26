t = int(input())

for _ in range(t):
	R, S = input().split()

	for i in S:
		print(i*int(R), end='')
	print()