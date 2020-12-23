import socket

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
data = "你好".encode("utf-8")
s.sendto(data, ("127.0.0.1", 5555))
print("消息已发送。")

data, addr = s.recvfrom(1024)
print("返回的消息：", data.decode("utf-8"))


s.close()