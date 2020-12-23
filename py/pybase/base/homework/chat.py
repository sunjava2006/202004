import socket
from threading import Thread


class Chat(Thread):
    """用于实现用户聊天的处理线程。"""

    def __init__(self, sckt, address):
        """获取用户的连接和地址，"""
        super().__init__()
        self.__s = sckt
        self.__address = address

    def run(self):
        while True:
            data = self.__s.recv(1024)
            msg = data.decode('utf-8')
            returnmsg = "是的。"

            if msg in "你多大了？":
                returnmsg = "女生的年龄不能问噢。"
            elif msg in "你是男生还是女生":
                returnmsg = "我是女生。"
            elif msg in "吃了吗":
                returnmsg = "你要请我吃饭吗？"
            elif (msg in "再见") or (msg in "bye"):
                returnmsg = "再见"

            self.__s.send(returnmsg.encode("utf-8"))

            if (msg in "再见") or (msg in "bye") or (returnmsg == "再见"):
                break
        self.__s.close()


class ChatRoom:
    """定义一个多线程的聊天室类型。
       可以接入多个用户连接，第一个连接都可以独立的与用户进行通信聊天。
    """

    def __init__(self, localhost="127.0.0.1", port=2345):
        """初始化一聊天室，给定聊天室服务端的IP和port"""
        self.__localhost = localhost
        self.__port = port

    def start(self):
        """启动聊天室（启动用户接入监听）。有用户接入时，交给一个聊天线程处理。"""
        listener = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        listener.bind((self.__localhost, self.__port))
        listener.listen(2)

        while True:
            s, address = listener.accept()
            chat = Chat(s, address)
            chat.start()


if __name__ == "__main__":
    chatRoom = ChatRoom()
    chatRoom.start()