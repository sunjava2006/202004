class Dog:
    def __init__(self, name):
        self.name = name
        self.__monery = 100

    def eat(self):
        print("%s吃骨头." % self.name)

    def eat(self, a):
        print("%s吃骨头.................." % self.name)


d = Dog("旺财")
print(d.name)
d.eat("")
d.age = 2
print(d.age)

def run():
    print("小狗在跑。")

d.run = run
d.run()

def run2(self):
    print(self.name + "在跑")

# d.run2 = run2

import types
d.run2 = types.MethodType(run2, d)
d.run2()

print(types.MethodType(run2, d))

del d.age
# print(d.age)

del d.name
# print(d.name)

print(d._Dog__monery)