class MyException(Exception):
    def __init__(self, msg):
        super(MyException, self).__init__(msg)

def a(x, y):
    if x == None or y == None:
        ex = MyException("两个参数，都不可以为None。")
        raise ex
    return x + y


try:
    a(None, 1)
except MyException as ex:
    print(ex)

