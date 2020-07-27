#include <stdio.h>

typedef struct estudante {
    int r_no;
    char name[20];
    char course[25];
    int fees;
};

int main() {
    struct estudante est01, *ptr_est01;

    // Passamos para o pontiero o enderço da estrutua estudante
    ptr_est01 = &est01;

    printf("\nDigite o nome: \n");
    gets(ptr_est01->name);
    printf("Digite o numero roll: \n");
    scanf("%d", &ptr_est01->r_no);
    printf("\nDigite o curso: \n");
    gets(ptr_est01->course);
    printf("\nDigite o fees: \n");
    scanf("%d", &ptr_est01->fees);
    printf("\n== Informacoes do estudante == \n");
    printf("Nome: %s\n", ptr_est01 -> name);
    printf("Curso: %s\n", ptr_est01 -> course);
    printf("Numero de matricula: %d\n", ptr_est01 -> r_no);
    printf("FEES: %d\n", ptr_est01 -> fees);

    return 0;
}