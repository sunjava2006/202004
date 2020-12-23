for i in range(1, 11):
    print("*" * i)
else:
    print("-"*20)

for i in range(10, 0, -1):
    print("*" * i)

for i in ["java", "python", "js"]:
    print(i)

for i in ("java", "python", "js"):
    print(i)

for i in {"java", "python", "js"}:
    print(i)
else:
    print('-' * 20)

d = {"zero": 0, "one": 1, "two": 2}
for i in d:
    print("{}:{}".format(i, d.get(i)))
else:
    print("*" * 30)

for i in "china":
    print(i)



