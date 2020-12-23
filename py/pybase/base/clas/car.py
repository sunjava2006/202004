class Car:
    """定义一个Car类型。有私有属性sid。"""
    def __init__(self, sid, brand):
        print("====================Car __init__ =======================")
        self.__sid = str(sid)+"AFJ"
        self.brand = brand

    @property  # 定义通过属性方式访问该方法。读。
    def sid(self):
        return self.__sid

    @sid.setter   # 定义通过属性方式访问该方法。写。
    def sid(self, sid):
        self.__sid = str(sid)+"AFJ"

    def run(self):
        print(self.brand + "run.......................")


car = Car(12345666, "QQ")
print(car.sid)
car.sid = 222333
print(car.sid)

class SUV(Car):
    """Car的子类。"""
    def __init__(self, model, sid, brand):
        self.model = model
        super(SUV, self).__init__(sid, brand) # 父类型中初始化的数据，要调用父类的初始函数来初始化。



suv = SUV("CRV", 3434324, "QQ")
suv.run()





