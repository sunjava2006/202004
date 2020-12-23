a = 90


def ch(li, e):
    li.append(e)  # 改变入参。Python中入参是地址。内外都会变。


def ch2(li, e):
    ll = li.copy()  # 对可变数据类型，如果不想改变外部参数数据，就要产生一个复本。
    ll.append(e)
    return ll



li = [1, 2, 3]
li2 = ch2(li, 4)

print(li2)
print(li)