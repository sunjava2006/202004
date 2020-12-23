import time
class A:
    def __init__(self):
        print("__init__")

    def __del__(self):
        print("__del__")

    def __add__(self, other):
        return 10+other

if __name__ == "__main__":
    a = A()
    print(a + 5)

    time.sleep(5)

    del a

    time.sleep(5)

    print("end")
