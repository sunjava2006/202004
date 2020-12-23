class Stack:
    """定义一个栈数据类型"""

    def __init__(self):
        """为栈对象，初始化一个空的列表"""
        self.value = []
        self.iter = None

    def size(self):
        """返回列表的大小"""
        return len(self.value)

    def push(self, e):
        """向列表尾部添加数据，进行入栈操作。"""
        self.value.append(e)

    def pop(self):
        """将列表尾部元素，取出并返回。进行出栈操作。"""
        if self.size() > 0:

            return self.value.pop()
        else:
            return None

    def __str__(self):
        return str(self.value)

    def __repr__(self):
        return "Stack:"+str(self.value)

    def __iter__(self):
        print("in __iter__")
        return iter(self.value)

    def __next__(self):
        try:
            if not self.iter:
                self.iter = iter(self.value)
            val = next(self.iter)
            return val
        except StopIteration as ex:
            self.iter = None
            raise ex

    def __len__(self):
        return self.size()

from collections import Iterable, Iterator
if __name__ == "__main__":
    try:
        s = Stack()  # 创建一个对象
        s.push(10)
        s.push(20)
        print(next(s))
        print(next(s))
        print(next(s))
    except StopIteration as ex:
        print("end")

    print(len(s))

