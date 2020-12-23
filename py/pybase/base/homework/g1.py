def a(n):
   for i in range(1, n, 2):
       yield i

i = a(4)

print(type(i))

try:
    while True:
        print(next(i))
except StopIteration as ex:
    print("end", "*" * 30, ex)


