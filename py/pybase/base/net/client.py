import socket


def send():
    """客户端"""
    # 创建一个TCP/IP的socket对象。
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # 连接目录地址和端口。
    s.connect(("127.0.0.1", 2345))

    while True:
        msg = input("输入你要发送的消息：")
        # 发送消息
        data = (msg).encode("utf-8")
        s.send(data)


        # 接收返回的消息。
        data = s.recv(1024)
        received = data.decode("utf-8")
        print("返回的消息是：‘{}’.".format(received))

        # 退出程序
        if received == '再见':
            break

    # 关闭连接
    s.close()


if __name__ == "__main__":
    send()
