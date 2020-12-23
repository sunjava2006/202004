import socket


def ReceiveFile():
    """"""

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind(("localhost", 60000))
    server.listen(1)

    s, addr = server.accept()
    data = s.recv(100)
    print("data:", data)
    while data:
        data = s.recv(100)
        print("data:",  data)

    s.close()
    server.close()


if __name__ == "__main__":
    ReceiveFile()
