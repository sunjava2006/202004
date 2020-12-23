def a():
    v = 90

    def b():
        print("hello", v)

    return b


a()()