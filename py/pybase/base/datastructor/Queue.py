class Queue:
    """队列，一个先进，先出的有序数据集合。"""

    def __init__(self):
        """初始化一个空的列表，用来存储数据。"""
        self.value = []

    def offer(self, e):
        """添加一个元素，到队列的尾部。"""
        self.value.append(e)

    def poll(self):
        """从队列的头部，取出一个元素并返回。"""
        return self.value.pop(0)

    def peek(self):
        """查看队列头的元素。"""
        return self.value[0]

    def __len__(self):
        return len(self.value)


if __name__ == "__main__":
    q = Queue()
    print("空队列长度为：%d。" % len(q))

    q.offer(100)
    q.offer(200)
    q.offer(300)
    print("加入三个数据后，队列长度为：%d。" % len(q))

    print(q.peek())

    print(q.poll())
    print(q.poll())
    print(q.poll())
    print(q.poll())
