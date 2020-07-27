/*
 * Implementação de uma array de tamanho expansível em C.
 * Ao contrário de uma array padrão, essa expansão permite adicionar e remover elementos.
 */
#include <stdlib.h> 

int array[1] = NULL;

void adicionar(int n) {
    if(array[0] == NULL) {
        array[0] = n;
        return array;
    }
    else {
        int tamanho = (sizeof(array) / sizeof(int)) + 1;
        int aux[tamanho];
        int i;

        aux[tamanho - 1] = n;

        for(i = 0; i < tamanho; i++) {
            aux[i] = array[i];
        }

        return aux;
    }
}