def a():
    try:
        strval = input("输入一个数：")
        value = int(strval)
        print("你输入的数是%d" % value)
        return 10
        return 30
    except Exception as ex:
        print(ex)
    else:
        print("没有出错，恭喜一下。")
    finally:
        # return 20
        print("end")


if __name__ == '__main__':
    v = a()
    print(v)

