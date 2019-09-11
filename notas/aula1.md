### Aula 1 - Anotações

### 1.2 Controle de versão com Git

```sh
# Criando uma pasta para testar os comenados dos Git
$ mkdir meusite
$ cd meusite

# Qual o status inicial da minha pasta?
$ git status
> fatal: not a git repository (or any of the parent directories): .git

# Criamos um novo repositório vazio do git (ver "man git init")
$ git init
> Initialized empty Git repository in <diretório-da-pasta>/fj22-8490/meusite/.git/
# A pasta .git/ contem vários arquivos que são responsáveis pelo funcionamento do repositório

# Vou criar o arquivo index.html utilizando o emmet para gerar a estrutura default
$ code .

# Executar o código com o atalho ALT+B (plugin open in browser)
```

Após esses passos quero ver qual o status do meu nome arquivo dentro do repositório:

```sh
$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	index.html

nothing added to commit but untracked files present (use "git add" to track)

# Meu git estava configurado para o português. Mudei isso adicionando uma linha no meu ~.zshrc "alias git='LANG=en_US git'"
```

Nosso arquivo não está sendo monitorado por enquando, podemos adicionar ele:

```sh
$ git add index.html 
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)

	new file:   index.html
```

Hora de commitar nosso trabalho

```sh
# ou "git commit --message <mensagem>"
$ git commit -m "Meu primeiro commit"

# Teremos um erro por que nossas credenciais não estão configuradas
$ git config --global user.name "<Seu nome>"
$ git config --global user.name "<Seu email>"

# Com a configuração --global isso fica gravado em ~/.gitconfig
 $ cat ~/.gitconfig 
[user]
	email = emai@email.com
	name = João da Silva
[core]
	editor = vim

# Sem o global estamos configurando para um repositório específico
$ git config user.name "João dos Santos"
$ cat .git/config
.
.
.
[user]
	name = João da Silva

# Agora sim podemos fazer nosso commit. Esse comando trás alguns dados para nós como resposta
$ git commit -m "Meu primeiro commit"
[master (root-commit) 9e7b3cb] Minha primeira mensagem
 1 file changed, 12 insertions(+)
 create mode 100644 index.html

# Podemos ver qual o status do repositório após o commit
$ git status
On branch master
nothing to commit, working tree clean

# Podemos ver que todas as mudanças foram salvas no commit anterior, e a árvore de trabalho está limpa, sem alterações
```

Um comando muito útil é o `git log`, que mostrará o registro das nossas atividades:

```sh
$ git log
commit 9e7b3cbe4f562762049ef9ec6a0059697c0c74ff (HEAD -> master)
Author: Fellipe Souto <fllsouto@gmail.com>
Date:   Wed Sep 11 11:38:58 2019 -0300

    Minha primeira mensagem


# Informações importantes
  # Hash
  # Autor
  # Data
  # Mensagem

# Existem diversas opções interessantes, como: 
  # --oneline -n <número>
  # --oneline --graph
  # --pretty=full -n <número>
```

Vamos adicionar um novo trecho ao HTML e salvar:

```sh
# Existe uma nova mudança no nosso sistema
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

	modified:   index.html

no changes added to commit (use "git add" and/or "git commit -a")
```

Podemos verificar quais foram as mudanças feitas no arquivo através do comando `git diff`:

```diff
diff --git a/index.html b/index.html
index a5d4306..5880ee5 100644
--- a/index.html
+++ b/index.html
@@ -8,5 +8,11 @@
 </head>
 <body>
   <h1>Hello world FJ22!</h1>
+  <p>
+    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam sed accumsan leo. Nam a maximus mi, sit amet lacinia eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus non metus dapibus, semper dolor in, bibendum lectus. Ut quis ante pellentesque, pretium ante ut, interdum neque. Morbi porta enim quis nisl hendrerit, non malesuada risus porta. Quisque pretium velit euismod semper pulvinar. Maecenas pellentesque scelerisque dolor sed efficitur. Donec pellentesque nisl vitae dapibus aliquam. Phasellus fringilla nibh eu ligula condimentum efficitur. Phasellus ac mi maximus, tincidunt erat sed, finibus ipsum. Suspendisse ultrices est vel urna aliquet sollicitudin. Pellentesque volutpat lectus ipsum, in laoreet lacus tristique et.
+  </p>
+  <p>
+    Sed ex leo, vulputate ac ante ultricies, vestibulum fermentum enim. Praesent vitae risus ullamcorper, rutrum nulla eu, porttitor orci. Morbi ullamcorper elit vitae ullamcorper suscipit. Ut feugiat ipsum volutpat, egestas diam dapibus, rhoncus nunc. Suspendisse eget blandit erat. Praesent quis imperdiet lacus. Nullam sagittis, justo quis congue tempus, est eros sodales lorem, sagittis ullamcorper massa eros eget sem. Cras auctor semper velit interdum aliquam. Curabitur tincidunt dui sit amet venenatis auctor.
+  </p>
 </body>
 </html>
\ No newline at end of file
```
O arquivo mudou de status quando editamos ele:

![File Status Lifecycle](https://image.slidesharecdn.com/git-tutorial-pranav-kulkarni-150129143414-conversion-gate02/95/git-tutorial-7-638.jpg?cb=1422629531)

Vamos adicionar um novo commit:

```sh
# -a serve para adicionar todos os editados/deletados
$ git -am "Adicionando dois parágrafos`
```
Referências sobre git:

- [Pro git book](https://git-scm.com/book/en/v2)
- [Controlando versões com Git e Github - Casa do código](https://www.casadocodigo.com.br/products/livro-git-github?)

