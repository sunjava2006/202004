from threading import Thread, currentThread
import time


class MyThread(Thread):
    def __init__(self, msg, times, daemon=False):
        super().__init__(daemon=daemon)
        self.__msg = msg
        self.__times = times

    def run(self):
        for i in range(200):
            print(self.__msg * self.__times, self.name)
            time.sleep(0.2)


if __name__ == "__main__":
    t = MyThread("hello", 3, True)
    t2 = MyThread("world", 3, True)
    t2.daemon = False  # 也可以直接设置守护线程属性
    t2.setDaemon(True)

    t.start()
    t2.start()

    t.join(1)  # 将t线程“加入”到主线程中，等t线程结束，或超时。
    t2.join(1)  # join方法没有指定时间，将等待t、t2线程结束。

    print("=============================", __name__)
    print(currentThread().name)  # threading.currentThread()方法获取当前线程。