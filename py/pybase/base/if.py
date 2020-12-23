import random

ran = random.randint(0, 10)

if ran <= 3:
    print("<=3")
elif 3 < ran <= 6:
    print("4<ran<=6")
elif 6 < ran <= 8:
    print("6<ran<=8")
else:
    print("ran>8")

print("random is {}".format(ran))
