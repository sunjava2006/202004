from threading import Timer
import time


if __name__ == "__main__":
    # 创建定时任务，时间：秒为单位。要执行的任务。
    t = Timer(10.0, lambda: print(time.ctime()))
    t.start()   # 启动定时任务。
    t.cancel()  # 取消定时任务