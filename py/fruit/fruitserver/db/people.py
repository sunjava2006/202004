class People():
    def __init__(self, name, age):
        self.name = name
        self.age = age

    # def __init__(self, name):
    #     self.name = name
    #     self.age = None

    def work(a):
        print("{} working now".format(a.name))

    ''' Python 没有方法重载， 同名方法会覆盖之前定义的方法。'''
    # def work(a, task):
    #     print("{}do {} working now".format(a.name, task))

    def __str__(self):
        if self.age:
            return '{name:%s, age:%d}' %(self.name, self.age)
        else:
            return '{name:%s}' % (self.name)

    def __repr__(self):
        return self.__str__()


# p = People('wang')
# print(p)

p2 = People("Xie", 20)
print(p2)
p2.work()




