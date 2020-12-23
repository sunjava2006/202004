"""有默认值的参数"""


def add(collection, e=None):
    collection.add(e)


s = {1,2,3}
add(collection=s)

print(s)


"""不定长参数"""


def avg(a, *args):
    print(type(args), len(args))
    print(*args)
    v = a
    for i in args:
        v += i

    return v / (len(args)+1)


average = avg(40, 10, 20, 30)
print(average)

