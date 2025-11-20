# Concorrência em Java — Filósofos Jantando + Threads & Semáforos

Esse meu projeto é sobre **Concorrência, Sincronização e Semáforos em Java**!  
Aqui você encontrará implementações práticas que demonstram problemas clássicos de Sistemas Operacionais e como resolvê-los.

# Objetivo Geral

Demonstrar, na prática, como funcionam:

✔ Threads  
✔ Race conditions  
✔ Semáforos  
✔ Exclusão mútua  
✔ Deadlock e como evitá-lo  
✔ Trade-offs entre desempenho e sincronização  

# Parte 1 — Filósofos Jantando

O clássico problema dos Filósofos Jantando envolve:

- 5 filósofos sentados em uma mesa  
- Cada um alterna entre *pensar* e *comer*  
- Para comer, precisa pegar **dois garfos**  
- Garfos são recursos compartilhados  

Sem uma boa estratégia, todos pegam um garfo e ficam bloqueados, gerando **deadlock**.

## Solução implementada (sem deadlock)

Cada filósofo:

1. Pega **primeiro o garfo de menor índice**
2. Depois pega o garfo de maior índice
3. Come
4. Libera os garfos

Isso impede a espera circular, eliminando completamente o impasse.
Essa solução é simples, eficiente e correta — e ainda mantém fairness entre os filósofos.

# Parte 2 — Threads & Semáforos

Nesta parte, executei dois testes com múltiplas threads incrementando um contador global.

## Teste 1: Sem controle

- Muitas threads fazem `count++` ao mesmo tempo  
- O valor final NÃO é o esperado  
- Resultado incorreto devido a race conditions  

Demonstra que operações aparentemente simples não são atômicas.

## Teste 2: Com Semáforo (correto)

- Uso de `Semaphore(1, true)`  
- Garante acesso exclusivo à seção crítica  
- Nenhum incremento é perdido  
- O valor final fica **exatamente correto**

 Porém o tempo total aumenta, pois as threads esperam umas pelas outras.

## Conclusões

- **Sem semáforo:** rápido, mas incorreto  
- **Com semáforo:** correto, porém mais lento  

Mostra o trade-off clássico entre **desempenho** e **segurança na concorrência**.

# Vídeo Explicativo

Assista ao vídeo com a explicação completa do projeto:

**LINK DO VÍDEO:** https://youtu.be/n1jtTATggQQ?si=rsvzesPh237itFdz


