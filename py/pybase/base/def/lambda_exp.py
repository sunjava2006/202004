
p = lambda s, repeat: print(s * repeat)

p("*", 10)


people = {"name": "Wang", "age": 30}
people2 = {"name": "Jack", "age": 40}

li = [people, people2]

key = "age"

li.sort(key=lambda i: people[key])

print(li)