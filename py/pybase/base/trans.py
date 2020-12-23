a = "abcdef"
b = "148902"

tab = str.maketrans(a, b)
print(tab)

s = "I from china."

s2 = s.translate(tab)

print(s2)