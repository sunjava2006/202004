

li = [1,2,3]
li2 = [4,5,6]
sli = [li, li2]

sli2 = sli.copy()   # 浅复制

sli2[0][0] = 100

print(sli2)
print(sli)

sli2.append([7,8,9])
print(sli2)
print(sli)

