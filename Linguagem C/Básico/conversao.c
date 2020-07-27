#include <stdio.h>
/* Programa para converter um inteiro para seu correspondente em float */
int main() {
    float num_float;
    int num_int;

    printf("Digite um numero inteiro: ");
    scanf("%d", &num_int);

    num_float = (float) num_int;

    printf("O valor em ponto flutuante de %d e %.2f", num_int, num_float);

    return 0;
}

