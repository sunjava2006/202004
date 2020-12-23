import socket


with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect(("127.0.0.1", 8800))
    data = "hello\r\n\r\n\r\nworld\r\n\r\n!\r\n".encode("gbk")
    s.send(data)
