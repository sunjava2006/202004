def fib():
    a = 1
    b = 1
    yield a
    for i in range(10):
        print("generate")
        t = a
        yield t
        a = b+a
        b = t


ite = fib()
next(ite)
next(ite)
next(ite)
next(ite)