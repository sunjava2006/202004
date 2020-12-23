class People:
    __country = "china"

    def __init__(self, name, age, monery):
        self.name = name
        self.age = age
        self.__monery = monery   # 以  "__"开头的属性

    def __sleep(self):
        print("sleep........................")

    def how(self):
        return self.__monery * 5

    def like(self):
        self.__sleep()


class Student(People):
    def  __init__(self, name, age, monery):
        super(Student, self).__init__(name,age, monery)
    def say(self):
        print(super().__monery)

if __name__ == "__main__":
    # p = People("wang", 10, 100000)
    # print(p.name)
    # print(p.age)
    # # print(p.__monery)
    # print(p._People__monery)  # 访问私有属性
    # # p.__sleep()
    # p._People__sleep()  # 访问私有方法
    #
    # print(p.how())
    # p.like()
    # print(People._People__country)   # 访问类的私有属性

    s = Student("wang", 30, 100000)
    s.say()

    print(s._People__monery)



