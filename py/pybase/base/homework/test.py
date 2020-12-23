from base.homework.send_file import TransFile


if __name__ == "__main__":
    tf = TransFile("127.0.0.1", 1999)

    tf.send("d:/a.txt", "127.0.0.1", 1999)