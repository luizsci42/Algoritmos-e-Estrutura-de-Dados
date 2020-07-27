#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node *next;
} node;

int add_element(struct node **start, int value) {
    node *new_node = malloc( sizeof( struct node ) );

    if(start != NULL) {
        new_node->value = value;
        new_node->next  = NULL;

        while(*start != NULL) {
            start = &(*start)->next;
        }

        *start = new_node;
    } else {
        printf("Nulo\n");
    }
}

node *transverse_list(struct node *start) {
    node *last;

    for(struct node *current = start; current != NULL; current = current->next) {
        last = current;
        printf("%d -> ", current->value);
    }
    printf("end\n");
    printf("Last: %d\n", last->value);

    return last;
}

int main(void) {
    struct node *start = NULL;

    add_element(&start, 2);
    add_element(&start, 3);
    add_element(&start, 5);
    add_element(&start, 7);
    add_element(&start, 11);
    add_element(&start, 13);
    add_element(&start, 17);

    transverse_list(start);
    
    return 0;
}