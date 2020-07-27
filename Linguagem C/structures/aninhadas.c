#include <stdio.h>

int main() {
    typedef struct DOB {
        int day;
        int month;
        int year;
    };

    typedef struct student {
        int roll_no;
        char name[100];
        float fees;
        struct DOB date;
    };

    struct student estudante;
    printf("Digite o numero roll: \n");
    scanf("%d", &estudante.roll_no);
    printf("\n");
    printf("Digite o nome: \n");
    scanf("%s", &estudante.name);
    printf("\nDigite o fees: \n");
    scanf("%f", estudante.fees);
    printf("\nDigite o DOB: \n");
    scanf("%d %d %d", &estudante.date.day, &estudante.date.month, &estudante.date.year);

    return 0;
}