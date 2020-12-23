import random

# 产生一个0-1000之间的数
ran = random.randint(0, 1000)

if ran % 2 == 0:
    print('-' * 30)
    print('%d,偶数' % ran)
    print('-' * 30)
elif ran %3 == 2:
    pass
else:
    print('-' * 30)
    print('%d,奇数' % ran)
    print('-' * 30)

a = 1+1+1+1+1+1\
    +1+1+\
    1
print(a)

s = 'china'\
    'good'\
    '.'
print(s)

s = '''I 
like 
python.'''
print(s)
