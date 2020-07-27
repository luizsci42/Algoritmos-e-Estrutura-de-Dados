// Faça um programa para mostrar a contagem de números pares de 2 a 100.
// Também mostre a soma desses números
#include <stdio.h>

int main() {
    int i;
    int soma = 0;

    for(i = 2; i < 102; i+=2) {
        printf("%d\n", i);
        soma+=i;
    }

    printf("Soma: %d\n", soma);

    return 0;
}