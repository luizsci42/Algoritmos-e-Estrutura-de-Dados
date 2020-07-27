/* 
 * Programa para ler e exibir informações de um estudante
 */
#include <stdio.h>

int main() {
    typedef struct student {
       int roll_no;
       char name[80];
       float fees;
       char DOB[80];
    };

    struct student estudante;

    printf("Digite o numero roll: \n");
    scanf("%d", &estudante.roll_no);
    printf("\n");
    printf("Digite o nome: \n");
    scanf("%s", &estudante.name);
    printf("\n");
    printf("Digite o fees: \n");
    scanf("%f", &estudante.fees);
    printf("\n");
    printf("Digite o DOB: \n");
    scanf("%s", &estudante.DOB);

    printf("\n === Informacoes === \n");
    printf("Numero rol: %d\n", estudante.roll_no);
    printf("Nome: %s\n", estudante.name);
    printf("Numero fees: %.2f\n", estudante.fees);
    printf("DOB: %s\n", estudante.DOB);
}