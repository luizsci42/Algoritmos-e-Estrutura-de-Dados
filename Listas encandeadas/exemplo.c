#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int valor;
    struct node *proximo;
};

struct node criar_lista(struct node *inicial) {
    struct node *novo_no, *ptr;
    int num;

    printf("Enter -1 to end\n");
    printf("Enter the data: ");
    scanf("%d", &num);

    while(num != -1) {
        novo_no = (struct node *) malloc(sizeof(struct node));
        novo_no -> valor = num;

        if(inicial == NULL) {
            novo_no -> proximo =  NULL;
            inicial = novo_no;
        }
        else {
            ptr = inicial;
            // Percorremos a lista até encontrar um nó cujo próximo aponte para NULL
            while(ptr -> proximo != NULL) {
                // Passamos para o ponteiro atual o próximo nó 
                ptr = ptr -> proximo;
                ptr -> proximo = novo_no;
                novo_no -> proximo = NULL;
            }
        }
    }
    return *inicial;
}

int main() {
    struct node *inicial;
    inicial = NULL;
    criar_lista(inicial);
    return 0;
}