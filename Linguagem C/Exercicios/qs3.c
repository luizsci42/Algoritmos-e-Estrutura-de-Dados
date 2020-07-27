// Contar o número de vogais em um texto
#include <stdio.h>
int main() {
    char texto[9] = "Ola mundo";
    int i = 0;
    int numVogais = 0;

    for(i = 0; i < 9; i++) {
        printf("%c\n", texto[i]);
        switch (texto[i]) {
        case 'a':
            numVogais += 1;
            break;
        case 'e':
            numVogais += 1;
            break;
        case 'i':
            numVogais += 1;
            break;
        case 'o':
            numVogais += 1;
            break;
        case 'u':
            numVogais += 1;
            break;
        case 'A':
            numVogais += 1;
            break;
        case 'E':
            numVogais += 1;
            break;
        case 'I':
            numVogais += 1;
            break;
        case 'O':
            numVogais += 1;
            break;
        case 'U':
            numVogais += 1;
            break;
        }
    }

    printf("Numero de vogais: %d\n", numVogais);

    return 0;
}