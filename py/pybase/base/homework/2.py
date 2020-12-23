# 输入三个整数x,y,z，请把这三个数由小到大输出。

string = input('输入3个数，用“，”分隔：')

array = string.split(',')
print(array)

for i in range(len(array)):
    array[i]=int(array[i])

print(array)

array.sort()

for i in array:
    print(i)


