class A:
    country = "china"
    def __init__(self, x, y):
        self.x = x
        self.__y = y   # 定义一个私有的属性

    def todo(self):
        print("todo.....................")

    def gety(self):
        return self.__y  # _A__y


class B(A):
    def __init__(self, x, y, z):
        # A.__init__(self, x, y)
        super(B, self).__init__(x, y)
        self.__y = y**2
        self.x = x**2  # 子类属性覆盖了父类的属性。只有一个。
        self.z = z

    def about(self):
        print(self.__y)  #子类不能直接访问父类的私有属性。_B__y
        print("gety",self.gety())
        self.todo()    # 调用自己重写的方法
        super(B, self).todo()   # 调用父类的方法

    def todo(self):   # 方法覆盖（重写）
        print("============================")

a = A(100, 200)
print(a.x)

b = B(10, 20, 30)
print(b.x, b.z)
b.todo()
print(b.country)
b.about()

