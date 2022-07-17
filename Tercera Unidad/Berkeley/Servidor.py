# -*- coding: utf-8 -*-
"""

@author: juanc
"""

from functools import reduce
from dateutil import parser
import threading
import datetime
import socket
import time


datos_cliente = {}


def recibirHoraReloj(conector, address):

    while True:
        # recibir la hora del reloj
        tiempoReloj_string = conector.recv(1024).decode()
        tiempoReloj = parser.parse(tiempoReloj_string)
        tiempoReloj_diff = datetime.datetime.now() - \
            tiempoReloj

        datos_cliente[address] = {
            "tiempoReloj": tiempoReloj,
            "diferenciaTiempo": tiempoReloj_diff,
            "conector": conector
        }

        print("Datos del cliente actualizados con: " + str(address),
              end="\n\n")
        time.sleep(5)


def empezarConexion(servidor_maestro):

    # obtener la hora del reloj en los esclavos / clientes
    while True:
        # aceptar un cliente/reloj esclavo cliente
        servidor_maestro_conector, addr = servidor_maestro.accept()
        direccion_esclavo = str(addr[0]) + ":" + str(addr[1])

        print(direccion_esclavo + " se ha conectado con éxito")

        hilo_actual = threading.Thread(
            target=recibirHoraReloj,
            args=(servidor_maestro_conector,
                  direccion_esclavo, ))
        hilo_actual.start()


# función de subrutina utilizada para obtener la diferencia de reloj media
def diferenciaMediaReloj():

    datos_cliente_actual = datos_cliente.copy()

    diferenciaTiempo_list = list(client['diferenciaTiempo']
                                 for client_addr, client
                                 in datos_cliente.items())

    suma_diferencia_reloj = sum(diferenciaTiempo_list,
                                datetime.timedelta(0, 0))

    diferencia_de_reloj_media = suma_diferencia_reloj \
        / len(datos_cliente)

    return diferencia_de_reloj_media


def sincronizarRelojes():

    while True:

        print("Nuevo ciclo de sincronización iniciado.")
        print("Número de clientes a sincronizar: " +
              str(len(datos_cliente)))

        if len(datos_cliente) > 0:

            diferencia_de_reloj_media = diferenciaMediaReloj()

            for client_addr, client in datos_cliente.items():
                try:
                    tiempo_sincronizado = \
                        datetime.datetime.now() + \
                        diferencia_de_reloj_media

                    client['conector'].send(str(
                        tiempo_sincronizado).encode())

                except Exception as e:
                    print(
                        "Algo salió mal al enviar la hora sincronizada a través de:  " + str(client_addr))

        else:
            print("Sin datos del cliente sincronización no aplicable.")

        print("\n\n")

        time.sleep(5)


# función utilizada para iniciar el Servidor de Relojes / Nodo Maestro
def iniciarRelojServidor(port=8080):

    servidor_maestro = socket.socket()
    servidor_maestro.setsockopt(socket.SOL_SOCKET,
                                socket.SO_REUSEADDR, 1)

    print("Socket en el nodo maestro creado con éxito\n")

    servidor_maestro.bind(('', port))

    # Empezar a escuchar las peticiones
    servidor_maestro.listen(10)
    print("El servidor del reloj comenzó...\n")

    # empezar a hacer conexiones
    print("Empezando a hacer conexiones...\n")
    hilo_maestro = threading.Thread(
        target=empezarConexion,
        args=(servidor_maestro, ))
    hilo_maestro.start()

    # iniciar la sincronización
    print("Iniciando la sincronización en paralelo...\n")
    sync_thread = threading.Thread(
        target=sincronizarRelojes,
        args=())
    sync_thread.start()


# Driver function
if __name__ == '__main__':

    # Trigger the Clock Server
    iniciarRelojServidor(port=8080)
