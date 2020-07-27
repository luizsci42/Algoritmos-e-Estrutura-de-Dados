#include <stdio.h>

int main() {
    // Declaramos uma variável chamada x
    int x;
    // Ponteiros são definidos com um asterisco antes do nome
    int *ptr;

    // Atribuímos o valor 10 à variável x
    x = 10;
    // O caractere & faz referência ao local da memória em que a variável está alocada
    ptr = &x;

    // O print irá mostrar o local da memória em que o ponteiro está alocado
    printf("Este e o espaco na memoria alocado para a variavel: %d\n", ptr);
    // Este print irá mostrar o valor armazenado, que pode ser acessado com o *
    printf("O valor armazenado na variavel e: %d", *ptr);

    return 0;
}