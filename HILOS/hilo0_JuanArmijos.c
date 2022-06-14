#include <pthread.h>
#include <stdio.h>
#define MAX 100

void *inc_x(void *x_void_ptr);

int main(){
	int x = 0;
	int y = 0;
	printf("x: %d, y: %d\n", x, y); // imprimir los valores de x y y

	//int aux = inc_x(x);
    pthread_t inc_x_thread;
	pthread_create(&inc_x_thread, NULL, inc_x, &x );

	while (++y <MAX);
	printf("y terminó el incremento\n");
	printf("X: %d, Y: %d\n", x, y);
	return 0;
}

void *inc_x(void *x_void_ptr){
	//convertir a entero
    int *x_ptr = (int *)x_void_ptr;
	printf("Estoy en el método implementado\n");

	while (++*(x_ptr) < MAX);
	printf("x terminó el incremento\n");
	//printf("X: %ls\n", x_ptr);
    return NULL;    
}
