from random import *


varlus = [1,2,3,4,5,6]


def f():
    v = choice(varlus)
    print("choice is {}".format(v))
    return v


i = iter(f, 7)  # f是迭代器，指明的回调函数。 7是停止迭代的标识值。


next(i)

