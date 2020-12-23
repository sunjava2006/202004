class A:
    def __init__(self):
        self.a = 10

    def ab(self):
        print("a")


class B:
    def __init__(self):
        self.b = 20

    def ab(self):
        print("ab")

    def b(self):
        print("b")


class C(A, B):
    def __init__(self):
        # super(C, self).__init__() 不能指定是哪一个父类的__init__
        super(C, self).__init__() # 按继承顺序从前向后找。
        A.__init__(self)  # 指定中一个类的方法。

    def ab(self):
        B.ab(self)

c = C()
print(c)
print(c.a)
print(c.b)
c.ab()
