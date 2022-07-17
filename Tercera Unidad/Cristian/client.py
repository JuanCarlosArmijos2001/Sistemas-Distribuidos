# -*- coding: utf-8 -*-
"""

@author: juanc
"""


import socket
import datetime
from dateutil import parser
from timeit import default_timer as timer


def cliente():

    socketCliente = socket.socket()
    port = 8000
    socketCliente.connect(('127.0.0.1', port))
    t0 = timer()
    tiempoServidor = parser.parse(socketCliente.recv(1024).decode())
    t1 = timer()
    tiempoActual = datetime.datetime.now()
    print("Algoritmo de Cristian")
    print("Desarrollado por: Juan Armijos")
    print("Hora del servidor: " + str(tiempoServidor))
    print("T0 = "+str(t0))
    print("T1 = "+str(t1))
    process_delay_latency = t1 - t0
    print("T1 - T0 = " + str(process_delay_latency) + " segundos")
    print("C = Cs + (T1 - T0)/2")
    client_time = tiempoServidor + \
        datetime.timedelta(seconds=(process_delay_latency) / 2)
    print("C= " + str(client_time))
    error = tiempoActual - client_time
    print("Tiempo a sincronizar : " + str(error.total_seconds()) + " segundos")
    socketCliente.close()


if __name__ == '__main__':
    cliente()
