i = 1
while i <= 10:
    j = 1
    while j <= i:
        print('*', end="")
        j += 1
    i += 1
    print()


i = 1
while i <= 10:
    print("*" * i)
    i += 1

abs(33)


def pr(p):
    print(f'我的名字是{p["name"]},今年{p["age"]}岁了')


pr({'name':'小张', 'age':40})
