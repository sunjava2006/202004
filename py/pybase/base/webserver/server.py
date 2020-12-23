import socket


class WebServer:
    def __init__(self, host="127.0.0.1", port=8800):
        self.host = host
        self.port = port
        self.listener = None

    def start(self):
        self.listener = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.listener.bind((self.host, self.port))
        self.listener.listen(10)
        print("---------- server listen ---------")
        s, address = self.listener.accept()
        s.settimeout(0.1)

        data = s.recv(2024)
        if data:
            print(data)
            print("length:", len(data))
            print(data.decode("gbk"))
            print("=" * 200)
            # data = s.recv(2024)

        data = 'HTTP/1.1 200 OK\r\nContent-Type:text/html;charset=utf-8\r\n\r\n<html><title>hello</title><body><h1>Hi</h1></body></html>'.encode("utf-8")
        # data = "HTTP/1.1 302\r\nlocation:https://www.qq.com?fromdefault\r\n\r\n".encode("utf-8")
        s.send(data)

if __name__ == "__main__":
    server = WebServer()
    server.start()