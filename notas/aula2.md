# Aula 2 - Anotações

## Git branch

Considere o seguinte projeto: [learn-git-conflict](https://github.com/fllsouto/learn-git-conflict)

Ao clonar o projeto podemos ver a árvore de commits que foi criada ao longo do tempo com o seguinte comando `git log --all --oneline --graph`, teremos como resultado:

```git
* fc80d3c (HEAD -> carol, origin/carol) Adicionando video do Alura +
* 42bdfb8 Removendo alguns par<C3><A1>grafos
| * 4e2273d (origin/master, origin/HEAD, master) Adicionando mais paragrafos ao texto
|/  
| * b80add9 (origin/joao, joao) Terminado cabecalho e rodape
| * befc358 Corrigindo local dos Scripts
| * 51ce177 Adicionando Bootstrap
|/  
* bf2c730 Afastando elementos
* b0a6fdc Estilizando paragrafos
* 4cf644c Paragrafo 2 e 3
* 137e408 Primeiro paragrafo
* 52e4860 Adicionando rodape
* 3ea0d91 Adicionando cabecalho
* e7929e8 Initial commit
```
O objetivo agora é combinar as soluções do João e da Carol, como podemos fazer isso?

