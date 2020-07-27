#include <stdio.h>

// Declaramos a função para que o compilador possa saber da sua existência antes de ser definida
// Aqui estamos usando argumentos por referência, o que quer dizer que, quando a função é chamada,
// uma referência para as variáveis são passadas como argumento. Ou seja, toda modificação
// que a função sum() fizer nas variáveis irá refletir nas variáveis de main(). Por isso,
// não é necessário utilizar o return
void sum(int*, int*, int*);

int main() {
    int num1, num2;
    int *total;
    printf("Digite o primeiro numero: \n");
    scanf("%d", &num1);

    printf("Digite o segundo numero: \n");
    scanf("%d", &num2);

    sum(&num1, &num2, &total);
    printf("Total da soma: %d\n", total);

    return 0;
}

// Definimos a função declarada anteriormente
void sum(int *a, int *b, int *t) {
    *t = *a + *b;
}
