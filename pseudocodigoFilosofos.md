Dados:
  N = 5 filósofos
  Garfos numerados de 0 a N - 1
  O garfo i fica entre os filósofos i e (i + 1) mod N

Para cada filósofo p:
    esquerda = garfo à esquerda de p
    direita  = garfo à direita de p

    left  = min(esquerda, direita)
    right = max(esquerda, direita)

Loop infinito:
    pensar()
    estado[p] <- "com fome"

    adquirir(left)      // pega primeiro o garfo de menor índice
    adquirir(right)     // depois pega o de maior índice

    estado[p] <- "comendo"
    comer()

    liberar(right)
    liberar(left)

    estado[p] <- "pensando"
