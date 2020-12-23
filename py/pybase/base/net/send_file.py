import socket


def SendFile():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect(("127.0.0.1", 60000))
    f = open("d:/a.txt", 'rb')
    # data = f.read()
    # s.send(data)
    data = data = f.read(100)
    while data:
        data = f.read(100)
        print(data)
        s.send(data)

    f.close()
    s.close()

if __name__ == "__main__":
    SendFile()