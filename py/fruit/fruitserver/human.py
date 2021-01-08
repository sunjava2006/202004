class Human():
    COUNTRY = "中国"

    def __init__(self, name):
        self.name = name

    @staticmethod  # 语法糖
    def about():
        print("about: ", Human.COUNTRY)

    @classmethod
    def say(cls):
        print(cls.COUNTRY)

class A():
    def __init__(self):
        pass


class B(A, Human):
    def __init__(self):
        pass

if __name__ == '__main__':
    h = Human("Wang")

    print(h.name)
    print(h.COUNTRY)
    print(Human.COUNTRY)


    Human.about()


    Human.say()


    b = B()
    print("---------------------", B.COUNTRY)
    B.about()

