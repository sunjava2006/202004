class A:
    def __init__(self):
        self.v = 10

    def getV(self):
        return self.v

class B:
    def __init__(self):
        self.v = 20

class C(A, B):
    def __init__(self):
        self.v = 30
        A.__init__(self)
        B.__init__(self)

    def __str__(self):

        return str(self.v)
c = C()
print(c)
print(c.getV())