import socket


class TransFile:
    """实现文件传输的类。提供实现网络传输文件和接收文件的功能"""
    def __init__(self, hostname, port):
        self.hostname = hostname
        self.port = port

    def send(self, filename, target_host, target_port):
        # 创建socket，TCP/IP 协议的。
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:

            # 连接目标主机
            s.connect((target_host, target_port))

            with open(filename, 'rb') as f:
                data = f.read(100)
                while data:
                    print(data)
                    s.send(data)
                    data = f.read(100)


    def receive(self, savefile):
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as listener:
            listener.bind((self.hostname, self.port))
            listener.listen(4)
            print("------------listen------------------")
            s, addr = listener.accept()
            print("addr:", addr)

            data = s.recv(200)
            if data:
                with open(savefile, 'wb') as f:
                    while data:
                        f.write(data)
                        data = s.recv(200)

            s.close()


if __name__ == "__main__":
    tf = TransFile("127.0.0.1", 1999)
    tf.receive("d:/b.txt")


