def writeTxt(filename, appendable=False, *txt):
    """写入文本内容到一个文件中。
       filename: 写入的目标文件。
       appandable: 是否在文件中追加内容。True为追加，False为覆盖。
       txt: 写入的内容。
    """
    try:
        mode = 'w'  # 只写模式
        if appendable:
            mode = 'a+'  # 追加可读模式， a只追加，但不可读。
        f = open(filename, mode)
        can_write = f.writable()    # 判断文件是否可写
        can_read = f.readable()     # 判断文件是否可读
        print("文件{}。".format("可写" if can_write else "不可写"))   # 条件表达式, 条件为True，返回值1，否则返回值2 : 值1 if 判断条件 else 值2
        print("文件{}。".format("可读" if can_read else "不可读"))

        f.writelines(txt)  # 写文件
    except Exception as ex:
        print(ex)
    else:
        print("文件写入完毕。")
    finally:
        f.close()   # 关闭文件，释放资源。


def readTxt(filename):
    """
    读取指定文件中的文本内容。
    :param filename: 指定的文件名
    :return: 读出的内容
    """
    try:
        f = open(filename, 'r')  # 以只读模式打开文件
        # data = f.readlines()
        data = f.read()  # 读出所有文本内容
    except Exception as ex:
        print(ex)
    else:
        print("读取成功。")
    finally:
        f.close()  # 关闭文件。
    return data


def copy(res, target):
    """
    文件复制功能。
    :param res: 源文件
    :param target: 目标文件
    """
    try:
        a = open(res, 'rb')  # 读取字节
        b = open(target, 'wb')  # 写入字节
        data = a.read(1024)
        """每次从a文件中读取1K数据，将这1K数据写入目标文件b中。
           当从a文件中读不到文件时，获取数据为b''。就退出循环体。
        """
        while True:
            if not data:
                break
            else:
                b.write(data)
                data = a.read(1024)
    finally:
        b.close()
        a.close()


def write_txt_enc(filename, appand=False, charset='utf-8', *txt):
    try:
        mode = 'wb'
        if appand:
            mode = 'ab'
        f = open(filename, mode)
        for s in txt:
            data = s.encode(charset)
            f.write(data)
    finally:
        f.close()

def read_ext_dec(filename, charset='utf-8'):
    """
    按指定的字符编码，读出文件中的内容。
    :param filename: 文件名
    :param charset: 字符编码
    :return:
    """
    try:
        f = open(filename, 'rb')
        result = []
        for data in f:          # 按行遍历文件。读出的数据为bytes类型
            s = data.decode(charset)   # 解码
            # print(s)
            result.append(s)
    finally:
        f.close()
    return ''.join(result)  # 将列出中的字符串元素，合并成一个字符串。


if __name__ == "__main__":
    # writeTxt("d:/a.txt", True, "我喜欢玩。", "I like Python。\n", "I like Sleep。\n", "I like Reading。\n")
    # data = readTxt("d:/a.txt")
    # print(data)

    # copy("D:\\_git_code_workspace\\202004\\weixin\\daily_news\\imgs\\3.jpg", "d:/b.jpg")

    # write_txt_enc("d:/aa.txt", True, "utf-8", "\n大家好\n", "\n我们好\n")
    # write_txt_enc("d:/bb.txt", True, "gbk", "\n大家好\n", "\n我们好\n")

    data =  read_ext_dec("d://bb.txt", "gbk")
    print(data)