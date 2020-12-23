# 冒泡排序
import random

li = []   # 定义一个空列表

#  产生10个随机整数
for i in range(10):   # range(beg=0, end, step)
    ran = random.randint(0, 100)
    li.append(ran)

print("随机数，产生的列表是：{}".format(li))

for i in range(len(li)-1):
    flag = True
    for j in range(len(li)-i-1):
        if li[j] > li[j+1]:
            t = li[j]
            li[j] = li[j+1]
            li[j+1] = t
            flag = False
    if flag:
        break

print("排序完毕{}".format(li))



