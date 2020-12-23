
def sm(a, b):
    """sum 方法，对传入数据求合。"""
    return a + b


def print_99():
    for i in range(1, 10):
        for j in range(1, i+1):
            print("{}*{}={}".format(j, i, j*i), end="\t")
        print()


v = sm(2, 3)
print(v)

print_99()

print(type(print_99))

p = print_99

p()

