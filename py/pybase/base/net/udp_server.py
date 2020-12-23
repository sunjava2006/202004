import socket

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

s.bind(("127.0.0.1", 5555))

data, addr = s.recvfrom(1024)

print(data.decode("utf-8"))
data = input("输入返回的消息：").encode("utf-8")
s.sendto(data, addr)


s.close()