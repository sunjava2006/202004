import socket

def receive_data():
    """服务端
    该方法，在9999端口上进行监听（侦听），获取对方发送来的数据"""

    # 创建一个socket对象。基于TCP/IP协议。
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # 定义一个元组表示的地址，并将socket绑定到这个地址。
    address = ("127.0.0.1", 9999)
    server.bind(address)

    # 监听。
    server.listen(1)
    print("----------listen-----------")

    # 等待、接收客户端的请求。没有请求的情况下，一直等待下去（阻塞）。
    # 返回与客户端的连接socket，对方的地址。
    cli_socket, cli_addr = server.accept()
    # cli_socket.setblocking(0)
    cli_socket.settimeout(20)


    print("对方的地址是：", cli_addr)

    # 获取收到的消息。bytes类型。
    while True:
        data = cli_socket.recv(200)
        msg = data.decode("utf-8")
        print("接收到的消息是:{}.".format(msg))

        # 返回一个消息，给客户端。
        msg = input("输入返回的消息：")
        msg += '\n'
        data = msg.encode("utf-8")
        cli_socket.send(data)

        if(msg == "bye"):
            break

    # 关闭与客户端的连接
    cli_socket.close()

    # 关闭监听
    server.close()
    print("----------end---------")


if __name__ == "__main__":
    receive_data()