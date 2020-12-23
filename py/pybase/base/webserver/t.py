from threading import Thread
import types


def target(self):
    print("------------------------",self.name)

def threadbody(*args, **keyargs):
    print("====================", args, keyargs)

if __name__ == '__main__':

    # 创建一个线程对象
    t = Thread(name="my-thread")

    # 获取名字
    print(t.name)

    t.run = types.MethodType(target, t)

    # 启动一个线程
    t.start()

    # ===========================================
    t2 = Thread(None, threadbody, "print_thread",("hi", "ok", "good"),{"one":1})
    t2.start()