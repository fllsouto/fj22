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

# Linearizando as coisas com um rebase
git rebase master
git log --all --oneline --graph

* ec33056 (work -> master) Adicionando gitignore
* 42bb1b9 Salvando alterações
* 5ad6988 (HEAD) atualizando mais uma vez  gitignore
* 07f03cd adicionando arquivos de configuração
* f7a09a0 Salvando alterações da master
* 08c69bb (origin/master) Adicionando arquivos do projeto do FJ22

git commit -am "Mais uma atualização"
git log --all --oneline --graph

* ce839ec (HEAD -> work) Mais uma atualização
* ec33056 Adicionando gitignore
* 42bb1b9 Salvando alterações
* 5ad6988 (master) atualizando mais uma vez  gitignore
* 07f03cd adicionando arquivos de configuração
* f7a09a0 Salvando alterações da master
* 08c69bb (origin/master) Adicionando arquivos do projeto do FJ22

git merge work

Updating 5ad6988..ce839ec
Fast-forward
 README.md                                                 | 12 ++++++++++++
 fj22-ingressos/.gitignore                                 |  1 +
 fj22-ingressos/src/main/webapp/WEB-INF/spring-context.xml |  2 +-
 3 files changed, 14 insertions(+), 1 deletion(-)
 create mode 100644 fj22-ingressos/.gitignore

# Todas mudanças estão na master, e tanto ela como a work está apontando para o mesmo
# commit, o ce839ec
git log --all --oneline --graph

* ce839ec (HEAD -> master, work) Mais uma atualização
* ec33056 Adicionando gitignore
* 42bb1b9 Salvando alterações
* 5ad6988 atualizando mais uma vez  gitignore
* 07f03cd adicionando arquivos de configuração
* f7a09a0 Salvando alterações da master
* 08c69bb (origin/master) Adicionando arquivos do projeto do FJ22

```