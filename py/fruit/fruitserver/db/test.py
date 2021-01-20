from threading import Thread


class MyTask(Thread):
    def __init__(self):
        super(MyTask, self).__init__()

    def run(self):
        print("-----------------------------")


t = MyTask()
t.start()

