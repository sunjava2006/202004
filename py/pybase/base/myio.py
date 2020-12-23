import random
import math
ran = math.floor(random.random()*10)

msg = '输入一个0-9之间的数:'

while True:
    strValue = input(msg)  # 等待用户输入，直到回车为止。

    value = int(strValue)  # int是一个整型转换函数

    if value == ran:   # “：” 表示语句块的开头
        print("你真聪明，猜对了。这个数是%d" % ran)
        break     # 跳出循环
    elif value > ran:
        msg = '你刚才输入的是%d, %s。' % (value, '大了')  # 格式化语句中，有两个占位符，在%后用（）给定两个对应的值。
    else:
        msg = '你刚才输入的是%d, %s。' % (value, '小了')





