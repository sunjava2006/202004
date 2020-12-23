class A:
    def __enter__(self):
        print("__enter__")
        return self

    def close(self):
        print("关闭文件")


    def __exit__(self, exc_type, exc_val, exc_tb):
        print("__exit__")
        self.close()

    def __repr__(self):
        return "A对象："

    def __str__(self):
        return "A对象："





with A() as a:
    print("----------------", str(a))
    raise Exception()

