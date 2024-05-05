file = open("TheMessage.txt", "r").read()
res = ""
for ch in file:
	if ord(ch) == 32:
		res += "0"
	else:
		res += "1"
print(res)