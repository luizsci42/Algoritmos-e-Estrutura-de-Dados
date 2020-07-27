/* 
 * Considere uma array MARKS[5][3] que armazena as notas obtidas por 5 estudantes em 
 * 3 matérias. Agora escreva um programa para:
 * a) encontrar a média das notas em cada matéria
 * b) encontrar a média de um aluno em cada matéria
 * c) encontrar o número de estudantes que fez menos de 50 pontos na sua média
 * d) mostrar os pontos obtidos por cada estudante
 */
#include <stdio.h>

int main() {
    float notas[5][3] = {
        {6.0, 7.2, 4.0},
        {8.4, 9.0, 5.0},
        {7.5, 3.2, 10.0},
        {8.0, 9.0, 6.0},
        {4.9, 6.2, 9.0}
    };

    float media = 0;
    int aluno, materia;
    int alunos = 5, materias = 3;

    for(aluno = 0; aluno < alunos; aluno++) {
        media += notas[aluno][0];
    }

    media /= alunos;
    printf("Media geral das materias: %.2f\n", media);

    float medias[5];
    float soma = 0;

    for(aluno = 0; aluno < alunos; aluno++) {
        for(materia = 0; materia < materias; materia++) {
            soma += notas[aluno][materia];
        }
        medias[aluno] = soma / materias;
        soma = 0;
    }

    int i;
    printf("\n");
    for(i = 0; i < 5; i++) {
        printf("Media do aluno %d: %.2f\n", i+1, medias[i]);
    }

    int reprovados = 0;

    for(aluno = 0; aluno < alunos; aluno++) {
        for(materia = 0; materia < materias; materia++) {
            soma += notas[aluno][materia];
        }
        
        if(soma <= 50) {
            reprovados += 1;
        }
    }

    printf("\n");
    printf("%d alunos reprovaram\n", reprovados);
    printf("\n");
    
    soma = 0;

    for(aluno = 0; aluno < alunos; aluno++) {
        for(materia = 0; materia < materias; materia++) {
            soma += notas[aluno][materia];
        }
        
        printf("Pontuacao total do aluno %d: %.2f\n", aluno, soma);
        soma = 0;
    }

    return 0;
}