#include <stdio.h>

int main() {
    int num1 = 2, num2 = 3, sum = 0, mul = 0, div = 1;
    int *ptr1, *ptr2;

    // O caractere & refere-se ao espaço na memória alocado para a respectiva variável
    ptr1 = &num1;
    ptr2 = &num2;
    
    // Ponteiros também podem ser usados em expressões, assim como variáveis
    sum = *ptr1 + *ptr2;
    mul = sum * (*ptr1);
    *ptr2 += 1;
    div = 9 + (*ptr2)/(*ptr1) - 30;

    printf("Suma dos valores dos ponteiros: %d\n", sum);
    printf("Multiplicacao da soma pelo valor do ponteiro 1: %d\n", mul);
    printf("Valor do segundo ponteiro: %d\n", *ptr2);
    printf("Resultado da divisao dos valores dos ponteiros -21: %d\n", div);

    // Os operadores de incremendo e decremento tem precedência sobre o operador *, que pega o valor do ponteiro
    // Sendo assim, a expressão *ptr++ é equivalente a *(ptr++), que muda o local alocado na memória em 1
    printf("Valor do primeiro ponteiro: %d\n", *ptr1);
    // Logo, para incrementar o valor, devemos colocar o * entre parênteses: (*ptr1)++
    (*ptr1)++;
    printf("Novo valor: %d\n", *ptr1);
    *ptr1++;
    printf("A incrementacao errada muda a alocacao na memoria: %d", *ptr1);

    return 0;
}