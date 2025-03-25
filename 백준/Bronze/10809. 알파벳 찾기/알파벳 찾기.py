arr = input()
cnt = [-1] * 26

for i in range(len(arr)):
	if cnt[ord(arr[i])-97] != -1:
		continue
	else:
		cnt[ord(arr[i])-97] = i
	
for i in range(26):
	print(cnt[i], end=' ')