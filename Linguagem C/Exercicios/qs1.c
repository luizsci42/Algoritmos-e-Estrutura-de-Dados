// Faça um programa para ler 10 números.
// Mostre esses números printando 3 numeros por linha,
// separados por vírgula
// OBS: sem usar array
#include <stdio.h>

void jeitoIneficiente();
void jeitoInteressante();

int main() {
    jeitoInteressante();

    return 0;
}

void jeitoInteressante() {
    int numeros[10];
    int i;
    int num;

    for(i = 0; i < 10; i++) {
        printf("Digite um numero: (%d/10): \n", (i+1));
        scanf("%d", &num);
        numeros[i] = num;
    }

    printf("%d, %d, %d\n", numeros[0], numeros[1], numeros[2]);
    printf("%d, %d, %d\n", numeros[3], numeros[4], numeros[5]);
    printf("%d, %d, %d\n%d\n",  numeros[6], numeros[7], numeros[8], numeros[9]);
}

void jeitoIneficiente() {
    int n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;

    printf("Digite um número (1/10): \n");
    scanf("%d", &n1);
    printf("Digite um número (2/10): \n");
    scanf("%d", &n2);
    printf("Digite um número (3/10): \n");
    scanf("%d", &n3);
    printf("Digite um número (4/10): \n");
    scanf("%d", &n4);
    printf("Digite um número (5/10): \n");
    scanf("%d", &n5);

    printf("Digite um número (6/10): \n");
    scanf("%d", &n6);
    printf("Digite um número (7/10): \n");
    scanf("%d", &n7);
    printf("Digite um número (8/10): \n");
    scanf("%d", &n8);
    printf("Digite um número (9/10): \n");
    scanf("%d", &n9);
    printf("Digite um número (10/10): \n");
    scanf("%d", &n10);

    printf("%d, %d, %d\n%d, %d, %d\n%d, %d, %d\n%d\n", n1, n2, n3, n4, n5, n6, n7, n8, n9, n10);
}