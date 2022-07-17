# -*- coding: utf-8 -*-
"""

@author: juanc
"""


from timeit import default_timer as timer
from dateutil import parser
import threading
import datetime
import socket
import time


# función de hilo de cliente utilizada para enviar la hora en el lado del cliente
def inicio_hora_envio(cliente_esclavo):

    while True:
        # proporcionar al servidor la hora del reloj en el cliente
        cliente_esclavo.send(str(
            datetime.datetime.now()).encode())

        print("Hora reciente enviada con éxito",
              end="\n\n")
        time.sleep(5)


# función del hilo del cliente utilizada para recibir la hora sincronizada
def inicio_hora_recepcion(cliente_esclavo):

    while True:
        # recibir datos del servidor
        hora_sincronizada = parser.parse(
            cliente_esclavo.recv(1024).decode())

        print("La hora sincronizada en el cliente es: " +
              str(hora_sincronizada),
              end="\n\n")


# función utilizada para Sincronizar el tiempo del proceso del cliente
def inicio_cliente_esclavo(port=8080):

    cliente_esclavo = socket.socket()

    # conectarse al servidor del reloj en el ordenador local
    cliente_esclavo.connect(('127.0.0.1', port))

    # empezar a enviar la hora al servidor
    print("Empezando a recibir la hora del servidor\n")
    hilo_tiempo_envío = threading.Thread(
        target=inicio_hora_envio,
        args=(cliente_esclavo, ))
    hilo_tiempo_envío.start()

    # comenzar a recibir la sincronización desde el servidor
    print("Comienza a recibir la hora sincronizada del servidor\n")
    tiempo_recepción_hilo = threading.Thread(
        target=inicio_hora_recepcion,
        args=(cliente_esclavo, ))
    tiempo_recepción_hilo.start()


if __name__ == '__main__':

    inicio_cliente_esclavo(port=8080)
