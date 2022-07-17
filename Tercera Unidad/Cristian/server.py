# -*- coding: utf-8 -*-
"""

@author: juanc
"""

import socket
import datetime


def servidor():

    socketServer = socket.socket()
    print("Socket creado")
    port = 8000
    socketServer.bind(('', port))
    socketServer.listen(5)
    print("Socket escuchando...")
    while True:
        connection, address = socketServer.accept()
        print('Server conectado con', address)
        connection.send(str(datetime.datetime.now()).encode())
        connection.close()


if __name__ == '__main__':
    servidor()
