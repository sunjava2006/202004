def sum(ite):
    """sum 自定义的一个全局对象"""
    v = 0
    for i in ite:
        v += i
    return float(v)


value = sum((1, 2, 3, 4, 5))
print(value)

g = 900

def fn():
    i = 1
    print(id(i))
    j = [2]
    global g   # 在函数执行过程中，申明一个全局变量
    g = 200

    def b():
        nonlocal i  # 申明，下面我要用到的i，不是一个本地变量。
        i = 10
        print(id(i))
        print("in b()：", i)
        print("g:", g)

    b()

    print("in fn(), after b()之后。", i)





fn()

print(g)