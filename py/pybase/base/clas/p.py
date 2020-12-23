class People:
    """定义一个People类型"""

    country = "China"   # 定义一个类变量。类变量是该类所有对象共有的。通过对象名或类名都可以访问。修改只能通过类名。

    def __init__(self, name, age):
        """类中定义的初始化（构造）方法"""
        self.name = name   # 定义成员变量（实例变量）
        self.age = age

    def work(self):
        print(self.name + "工作中.")

    def __str__(self):
        return "{name:%s, age:%d}" %(self.name, self.age)

    def sleep(self):
        print(self.name + "sleeping........")


class Student(People):
    def __init__(self, name, age, sid):
        su = super(Student, self)
        su.__init__(name, age)
        self.sid = sid

    def __str__(self):  # 方法重写(方法覆盖)
        return "{name:%s, age:%d, sid:%s}" % (self.name, self.age, self.sid)

    def study(self):
        print("good good study , day day up.")

    def work(self):   # 方法重写(方法覆盖)
        super(Student, self).work()    # 调用父类中的方法。
        self.study()
        print("新增加的工作内容................")
        self.sleep()
        super(Student, self).sleep()

    def todo(self):
        print("==================================================")
        self.work()
        print("==================================================")
        super().work()




def run():
    print("run.............")


p = People("wang", 22)
print(p)
p.work()
p.gender = "male"  # 对象可以动态添加属性和方法
p.run = run   # 对象可以动态添加属性和方法
p.run()
print(p.gender)
print(p.country)



p2 = People("Li", 11)
print(p2)
p2.work()
# print(p2.gender)
print(p2.country)

print(People.country)

People.country = "中国"
print(People.country)
print(p.country)
print(p2.country)

p.country = "法国"  # 动态属性
print(p.country)    # 动态属性
print(p2.country)
print(People.country)

s = Student("Xie", 20, "2020110201")
print(s)
s.study()

s.work()

s.todo()


