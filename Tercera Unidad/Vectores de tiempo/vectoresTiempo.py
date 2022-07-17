# -*- coding: utf-8 -*-
"""

@author: juanc
"""


def compararVectores(vector1, vector2):
    vector = [max(value) for value in zip(vector1, vector2)]
    return vector


P = {1: {}, 2: {}, 3: {}}  # Inició un diccionario vacío con 3 procesos

inc = 0

n1 = int(input("Introduzca el número de eventos en el Proceso 1 : "))
e1 = [i for i in range(1, n1 + 1)]
P[1] = {key: [inc + key, 0, 0] for key in e1}
print(P[1])
print("\n")

n2 = int(input("Introduzca el número de eventos en el Proceso 2 : "))
e2 = [i for i in range(1, n2 + 1)]
P[2] = {key: [0, inc + key, 0] for key in e2}
print(P[2])
print("\n")

n3 = int(input("Introduzca el número de eventos en el Proceso 3 : "))
e3 = [i for i in range(1, n3 + 1)]
P[3] = {key: [0, 0, inc + key] for key in e3}
print(P[3])
print("\n")

comm = int(input("Introduzca el número de líneas de comunicación  : "))
print("\n")

while inc < comm:
    sent = int(input("Introduzca el número de proceso de envío : "))
    recv = int(input("Introduzca el número de proceso de recepción : "))
    sent_event_no = int(input("Introduzca el número de evento de envío : "))
    recv_event_no = int(input("Introduzca el número de evento de recepción : "))
    if sent <= 3 and recv <= 3:
        print("P{} --> P{}".format(sent, recv))
        new_vector = compararVectores(
            P[sent][sent_event_no], P[recv][recv_event_no])
        P[recv][recv_event_no] = new_vector
        print("Nuevo valor vectorial de \"event {}\"  en proceso P{} es : {} \n".format(
            recv_event_no, recv, P[recv][recv_event_no]))

        # Cambio de vector para los próximos eventos.
        if (recv_event_no + 1) in P[recv]:
            for i in range(recv_event_no + 1, len(P[recv]) + 1):
                P[recv][i] = compararVectores(P[recv][i-1], P[recv][i])
    else:
        print("Introducir el envío/recv dentro del proceso existente")
    inc += 1

print("Los vectores finales de los 3 procesos son: ")
print(P[1])
print(P[2])
print(P[3])
