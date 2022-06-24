#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

long suma = 0;
void *factorial(void *numero);

int main(){
    for (long i = 3; i <= 10; i++){
        long contador=i;
        pthread_t factorial_thread;
        pthread_create(&factorial_thread,NULL,factorial,&contador); 
        pthread_join(factorial_thread,NULL);
    }
    printf("El total de la suma de los factoriales es: %ld\n",suma);
    return 0;
}

void *factorial(void *numero){
    long *num = (long *)numero;
    long contador = 1;
    for (long j = 2; j <= *num; j++){
        contador *= j;
    }
    printf("Factorial de %ld es %ld\n",*num,contador);  
    suma+=contador;
    *num = contador;
    return NULL;
}
