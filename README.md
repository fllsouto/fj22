### FJ22 - Desenvolvendo na prática com Spring e testes

### Referências

- [Git config](https://git-scm.com/docs/git-config)
- [Git - external links](https://git-scm.com/doc/ext)


### Artigos

- [A successful git branching model](https://nvie.com/posts/a-successful-git-branching-model/)

#### Exemplo de grafo de commits

```sh
git log --all --oneline --graph

* bc93d1c (work) Adicionando gitignore
* 68e831c Salvando alterações
| * 07f03cd (HEAD -> master) adicionando arquivos de configuração
| * f7a09a0 Salvando alterações da master
|/  
* 08c69bb (origin/master) Adicionando arquivos do projeto do FJ22

git log --all --oneline --graph

* ec33056 (work -> master) Adicionando gitignore
* 42bb1b9 Salvando alterações
* 5ad6988 (HEAD) atualizando mais uma vez  gitignore
* 07f03cd adicionando arquivos de configuração
* f7a09a0 Salvando alterações da master
* 08c69bb (origin/master) Adicionando arquivos do projeto do FJ22

```