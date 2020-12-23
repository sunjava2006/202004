def create_people(name, gender, **args):
    print(type(args), len(args))
    p = {"name": name, "gender": gender}
    for i in args:
        p[i] = args[i]
    return p


p = create_people('wang', 'male', age=20, phoneNo=12345678901, id="2343243434x8899")
print(p)
