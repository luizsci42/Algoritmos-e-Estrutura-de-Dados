/* Demonstraremos algumas operações que podem ser feitas em arrays:
 * Percorrer a array
 * Inserir elemento
 * Deletar elemento
 * Mesclar duas arrays
 * Outras operações são busa e ordenação, que serão abordadas depois.
*/
#include <stdio.h>

void percorrer(int *array, unsigned int tamanho) {
    unsigned int i;


    for(i = 0; i < tamanho; i++) {
        printf("array[%d]: %d\n", i, array[i]);
    }
}

int main() {
    int numeros[] = { 5, 126, 48, 42, 50, 1055, 23 };
    unsigned int tamanho = sizeof(numeros) / sizeof(int);

    percorrer(numeros, tamanho);
    return 0;
}