# Aula 1 - Anotações

## 1.2 Controle de versão com Git

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

## 1.2 Controle de versão com Git

- [How To Set Up a Private Git Server on a VPS Setup](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-private-git-server-on-a-vps)

Podemos visualizar a árvore de dependẽncia do projeto:

```text
 $ mvn dependency:tree -Dverbose                    
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< br.com.caelum:ingresso >-----------------------
[INFO] Building ingresso 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ ingresso ---
[INFO] br.com.caelum:ingresso:war:1.0-SNAPSHOT
[INFO] +- org.springframework:spring-core:jar:4.3.5.RELEASE:compile
[INFO] |  \- commons-logging:commons-logging:jar:1.2:compile
[INFO] +- org.springframework:spring-webmvc:jar:4.3.5.RELEASE:compile
[INFO] |  +- org.springframework:spring-aop:jar:4.3.5.RELEASE:compile
[INFO] |  |  +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  \- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- org.springframework:spring-beans:jar:4.3.5.RELEASE:compile
[INFO] |  |  \- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- org.springframework:spring-context:jar:4.3.5.RELEASE:compile
[INFO] |  |  +- (org.springframework:spring-aop:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  \- (org.springframework:spring-expression:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- org.springframework:spring-expression:jar:4.3.5.RELEASE:compile
[INFO] |  |  \- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  \- org.springframework:spring-web:jar:4.3.5.RELEASE:compile
[INFO] |     +- (org.springframework:spring-aop:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |     +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |     +- (org.springframework:spring-context:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |     \- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework:spring-orm:jar:4.3.5.RELEASE:compile
[INFO] |  +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- org.springframework:spring-jdbc:jar:4.3.5.RELEASE:compile
[INFO] |  |  +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  \- (org.springframework:spring-tx:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  \- org.springframework:spring-tx:jar:4.3.5.RELEASE:compile
[INFO] |     +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |     \- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework.security:spring-security-web:jar:4.2.1.RELEASE:compile
[INFO] |  +- aopalliance:aopalliance:jar:1.0:compile
[INFO] |  +- org.springframework.security:spring-security-core:jar:4.2.1.RELEASE:compile
[INFO] |  |  +- (aopalliance:aopalliance:jar:1.0:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-aop:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-context:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  \- (org.springframework:spring-expression:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-expression:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-web:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework.security:spring-security-config:jar:4.2.1.RELEASE:compile
[INFO] |  +- (aopalliance:aopalliance:jar:1.0:compile - omitted for duplicate)
[INFO] |  +- (org.springframework.security:spring-security-core:jar:4.2.1.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-aop:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework.data:spring-data-jpa:jar:1.10.6.RELEASE:compile
[INFO] |  +- org.springframework.data:spring-data-commons:jar:1.12.6.RELEASE:compile
[INFO] |  |  +- (org.springframework:spring-core:jar:4.2.9.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  +- (org.springframework:spring-beans:jar:4.2.9.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  +- (org.slf4j:slf4j-api:jar:1.7.22:compile - omitted for duplicate)
[INFO] |  |  \- (org.slf4j:jcl-over-slf4j:jar:1.7.22:runtime - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-orm:jar:4.2.9.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  +- (org.springframework:spring-context:jar:4.2.9.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  +- (org.springframework:spring-aop:jar:4.2.9.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  +- (org.springframework:spring-tx:jar:4.2.9.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  +- (org.springframework:spring-beans:jar:4.2.9.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  +- (org.springframework:spring-core:jar:4.2.9.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  +- org.aspectj:aspectjrt:jar:1.8.9:compile
[INFO] |  +- org.slf4j:slf4j-api:jar:1.7.22:compile
[INFO] |  \- org.slf4j:jcl-over-slf4j:jar:1.7.22:runtime
[INFO] |     \- (org.slf4j:slf4j-api:jar:1.7.22:runtime - omitted for duplicate)
[INFO] +- org.springframework.integration:spring-integration-mail:jar:4.3.5.RELEASE:compile
[INFO] |  +- org.springframework.integration:spring-integration-core:jar:4.3.5.RELEASE:compile
[INFO] |  |  +- (org.springframework:spring-core:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  +- (org.springframework:spring-aop:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  +- (org.springframework:spring-context:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  +- org.springframework:spring-messaging:jar:4.3.4.RELEASE:compile
[INFO] |  |  |  +- (org.springframework:spring-beans:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  |  +- (org.springframework:spring-context:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  |  \- (org.springframework:spring-core:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  +- (org.springframework:spring-tx:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |  |  \- org.springframework.retry:spring-retry:jar:1.1.3.RELEASE:compile
[INFO] |  \- org.springframework:spring-context-support:jar:4.3.4.RELEASE:compile
[INFO] |     +- (org.springframework:spring-beans:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |     +- (org.springframework:spring-context:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] |     \- (org.springframework:spring-core:jar:4.3.4.RELEASE:compile - omitted for conflict with 4.3.5.RELEASE)
[INFO] +- org.springframework.security:spring-security-taglibs:jar:4.2.1.RELEASE:compile
[INFO] |  +- org.springframework.security:spring-security-acl:jar:4.2.1.RELEASE:compile
[INFO] |  |  +- (aopalliance:aopalliance:jar:1.0:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework.security:spring-security-core:jar:4.2.1.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-aop:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-context:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-jdbc:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  \- (org.springframework:spring-tx:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework.security:spring-security-core:jar:4.2.1.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework.security:spring-security-web:jar:4.2.1.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-aop:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-expression:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-web:jar:4.3.5.RELEASE:compile - omitted for duplicate)
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] +- javax.servlet:jstl:jar:1.2:compile
[INFO] +- javax.servlet.jsp:javax.servlet.jsp-api:jar:2.3.1:compile
[INFO] +- org.hibernate:hibernate-core:jar:5.2.5.Final:compile
[INFO] |  +- org.jboss.logging:jboss-logging:jar:3.3.0.Final:compile
[INFO] |  +- org.hibernate.javax.persistence:hibernate-jpa-2.1-api:jar:1.0.0.Final:compile
[INFO] |  +- org.javassist:javassist:jar:3.20.0-GA:compile
[INFO] |  +- antlr:antlr:jar:2.7.7:compile
[INFO] |  +- org.apache.geronimo.specs:geronimo-jta_1.1_spec:jar:1.1.1:compile
[INFO] |  +- org.jboss:jandex:jar:2.0.3.Final:compile
[INFO] |  +- com.fasterxml:classmate:jar:1.3.0:compile
[INFO] |  +- dom4j:dom4j:jar:1.6.1:compile
[INFO] |  |  \- xml-apis:xml-apis:jar:1.0.b2:compile
[INFO] |  +- org.hibernate.common:hibernate-commons-annotations:jar:5.0.1.Final:compile
[INFO] |  |  \- (org.jboss.logging:jboss-logging:jar:3.3.0.Final:compile - omitted for duplicate)
[INFO] |  \- javax.enterprise:cdi-api:jar:1.1:compile
[INFO] |     +- javax.el:el-api:jar:2.2:compile
[INFO] |     +- org.jboss.spec.javax.interceptor:jboss-interceptors-api_1.1_spec:jar:1.0.0.Beta1:compile
[INFO] |     +- javax.annotation:jsr250-api:jar:1.0:compile
[INFO] |     \- javax.inject:javax.inject:jar:1:compile
[INFO] +- org.hibernate:hibernate-validator:jar:5.2.4.Final:compile
[INFO] |  +- javax.validation:validation-api:jar:1.1.0.Final:compile
[INFO] |  +- (org.jboss.logging:jboss-logging:jar:3.2.1.Final:compile - omitted for conflict with 3.3.0.Final)
[INFO] |  \- (com.fasterxml:classmate:jar:1.1.0:compile - omitted for conflict with 1.3.0)
[INFO] +- mysql:mysql-connector-java:jar:5.1.40:compile
[INFO] +- commons-dbcp:commons-dbcp:jar:1.4:compile
[INFO] |  \- commons-pool:commons-pool:jar:1.5.4:compile
[INFO] +- com.sun.mail:javax.mail:jar:1.5.6:compile
[INFO] |  \- javax.activation:activation:jar:1.1:compile
[INFO] +- javax.xml.bind:jaxb-api:jar:2.2.12:compile
[INFO] +- junit:junit:jar:4.12:compile
[INFO] |  \- org.hamcrest:hamcrest-core:jar:1.3:compile
[INFO] \- com.fasterxml.jackson.core:jackson-databind:jar:2.8.5:compile
[INFO]    +- com.fasterxml.jackson.core:jackson-annotations:jar:2.8.0:compile
[INFO]    \- com.fasterxml.jackson.core:jackson-core:jar:2.8.5:compile
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.053 s
[INFO] Finished at: 2019-09-11T15:41:31-03:00
[INFO] ------------------------------------------------------------------------
```

Podemos baixar o hibernate através do site: [hibernate](http://hibernate.org/)

Existem diversas formas de como resolver problemas de dependência, esse artigo detalha de forma didática por que esse problema ocorre: [Solving dependency conflicts in maven](https://dzone.com/articles/solving-dependency-conflicts-in-maven).

Nosso pom.xml tem a seguinte estrutura:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>br.com.caelum</groupId>
	<artifactId>ingresso</artifactId>
	<version>1.0-SNAPSHOT</version>
	<packaging>war</packaging>

	<dependencies>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>4.3.5.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.3.5.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>4.3.5.RELEASE</version>
		</dependency>
	</dependencies>

	<build>
		<finalName>ingresso</finalName>

		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.6.1</version>
				<configuration>
					<compilerArgs>
						<arg>-parameters</arg>
					</compilerArgs>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```

- [A descrição do que significa cada elemento do pom pode ser encontrado](https://maven.apache.org/pom.html)
- [Aqui tem tutorial de como usar o maven](https://www.baeldung.com/maven)
- [O que o -parameter faz](https://stackoverflow.com/questions/44067477/drawbacks-of-javac-parameters-flag)*
- [Method Parameter Reflection in Java](https://www.baeldung.com/java-parameter-reflection)*

Diagrama com as lifecycle, phases, goal e plugins do Maven:

![Maven build](https://i.stack.imgur.com/DU5hL.png)

Referências na discussão do stack overflow: [Maven: Lifecycle vs. Phase vs. Plugin vs. Goal](https://stackoverflow.com/questions/26607834/maven-lifecycle-vs-phase-vs-plugin-vs-goal).

Exemplo de um plugin com goals diferentes dos originais que vimos no lifecycle, o [plugin dependency](https://maven.apache.org/plugins/maven-dependency-plugin/index.html).

Podemos ainda ver todos os plugins que vem com o Maven nessa lista [aqui](https://maven.apache.org/plugins/index.html).

Vou executar alguns comandos do Maven para testar. O primeiro será o comando para limpar os arquivos que geramos no processo de build.

```sh
$ ls
bin  pom.xml  README.md  src  target
$ mvn clean
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< br.com.caelum:ingresso >-----------------------
[INFO] Building ingresso 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ ingresso ---
[INFO] Deleting /home/fsouto/workspace/caelum/fj22/fj22-ingressos/target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.494 s
[INFO] Finished at: 2019-09-12T18:04:14-03:00
[INFO] ------------------------------------------------------------------------
$ ls
bin  pom.xml  README.md  src
```
O goal package irá executar todas as phases anteriores até chegar no package:

```sh
$ mvn package
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< br.com.caelum:ingresso >-----------------------
[INFO] Building ingresso 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ ingresso ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.6.1:compile (default-compile) @ ingresso ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 48 source files to /home/fsouto/workspace/caelum/fj22/fj22-ingressos/target/classes
[INFO] /home/fsouto/workspace/caelum/fj22/fj22-ingressos/src/main/java/br/com/caelum/ingresso/model/form/ConfirmacaoLoginForm.java: Some input files use unchecked or unsafe operations.
[INFO] /home/fsouto/workspace/caelum/fj22/fj22-ingressos/src/main/java/br/com/caelum/ingresso/model/form/ConfirmacaoLoginForm.java: Recompile with -Xlint:unchecked for details.
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ ingresso ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/fsouto/workspace/caelum/fj22/fj22-ingressos/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.6.1:testCompile (default-testCompile) @ ingresso ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /home/fsouto/workspace/caelum/fj22/fj22-ingressos/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ ingresso ---
[INFO] Surefire report directory: /home/fsouto/workspace/caelum/fj22/fj22-ingressos/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running br.com.caelum.ingresso.model.SessaoTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.147 sec
Running br.com.caelum.ingresso.model.descontos.DescontoTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.003 sec
Running br.com.caelum.ingresso.validacao.GerenciadorDeSessaoTest
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.033 sec

Results :

Tests run: 10, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-war-plugin:2.2:war (default-war) @ ingresso ---
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.thoughtworks.xstream.core.util.Fields (file:/home/fsouto/.m2/repository/com/thoughtworks/xstream/xstream/1.3.1/xstream-1.3.1.jar) to field java.util.Properties.defaults
WARNING: Please consider reporting this to the maintainers of com.thoughtworks.xstream.core.util.Fields
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[INFO] Packaging webapp
[INFO] Assembling webapp [ingresso] in [/home/fsouto/workspace/caelum/fj22/fj22-ingressos/target/ingresso]
[INFO] Processing war project
[INFO] Copying webapp resources [/home/fsouto/workspace/caelum/fj22/fj22-ingressos/src/main/webapp]
[INFO] Webapp assembled in [400 msecs]
[INFO] Building war: /home/fsouto/workspace/caelum/fj22/fj22-ingressos/target/ingresso.war
[INFO] WEB-INF/web.xml already added, skipping
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.202 s
[INFO] Finished at: 2019-09-12T18:05:59-03:00
[INFO] ------------------------------------------------------------------------
```

Podemos usar diretamente um plugin:goal :

```sh
$ mvn compiler:compile
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< br.com.caelum:ingresso >-----------------------
[INFO] Building ingresso 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- maven-compiler-plugin:3.6.1:compile (default-cli) @ ingresso ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 48 source files to /home/fsouto/workspace/caelum/fj22/fj22-ingressos/target/classes
[INFO] /home/fsouto/workspace/caelum/fj22/fj22-ingressos/src/main/java/br/com/caelum/ingresso/model/form/ConfirmacaoLoginForm.java: Some input files use unchecked or unsafe operations.
[INFO] /home/fsouto/workspace/caelum/fj22/fj22-ingressos/src/main/java/br/com/caelum/ingresso/model/form/ConfirmacaoLoginForm.java: Recompile with -Xlint:unchecked for details.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.072 s
[INFO] Finished at: 2019-09-12T18:11:20-03:00
[INFO] ------------------------------------------------------------------------
```

Podemos também empacotar nosso software da forma como quisermos:

```sh
$ mvn war:war
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< br.com.caelum:ingresso >-----------------------
[INFO] Building ingresso 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- maven-war-plugin:2.2:war (default-cli) @ ingresso ---
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.thoughtworks.xstream.core.util.Fields (file:/home/fsouto/.m2/repository/com/thoughtworks/xstream/xstream/1.3.1/xstream-1.3.1.jar) to field java.util.Properties.defaults
WARNING: Please consider reporting this to the maintainers of com.thoughtworks.xstream.core.util.Fields
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[INFO] Packaging webapp
[INFO] Assembling webapp [ingresso] in [/home/fsouto/workspace/caelum/fj22/fj22-ingressos/target/ingresso]
[INFO] Processing war project
[INFO] Copying webapp resources [/home/fsouto/workspace/caelum/fj22/fj22-ingressos/src/main/webapp]
[INFO] Webapp assembled in [210 msecs]
[INFO] Building war: /home/fsouto/workspace/caelum/fj22/fj22-ingressos/target/ingresso.war
[INFO] WEB-INF/web.xml already added, skipping
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.065 s
[INFO] Finished at: 2019-09-12T18:14:34-03:00
[INFO] ------------------------------------------------------------------------
```

Podemos executar também o plugin dependency, que é responsável por gerenciar nossas dependências. Em especial o goal tree mostra nossa árvore de dependências:

```sh
 $ mvn dependency:tree   
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< br.com.caelum:ingresso >-----------------------
[INFO] Building ingresso 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ ingresso ---
[INFO] br.com.caelum:ingresso:war:1.0-SNAPSHOT
[INFO] +- org.springframework:spring-core:jar:4.3.5.RELEASE:compile
[INFO] |  \- commons-logging:commons-logging:jar:1.2:compile
[INFO] +- org.springframework:spring-webmvc:jar:4.3.5.RELEASE:compile
[INFO] |  +- org.springframework:spring-aop:jar:4.3.5.RELEASE:compile
[INFO] |  +- org.springframework:spring-beans:jar:4.3.5.RELEASE:compile
[INFO] |  +- org.springframework:spring-context:jar:4.3.5.RELEASE:compile
[INFO] |  +- org.springframework:spring-expression:jar:4.3.5.RELEASE:compile
[INFO] |  \- org.springframework:spring-web:jar:4.3.5.RELEASE:compile
[INFO] +- org.springframework:spring-orm:jar:4.3.5.RELEASE:compile
[INFO] |  +- org.springframework:spring-jdbc:jar:4.3.5.RELEASE:compile
[INFO] |  \- org.springframework:spring-tx:jar:4.3.5.RELEASE:compile
[INFO] +- org.springframework.security:spring-security-web:jar:4.2.1.RELEASE:compile
[INFO] |  +- aopalliance:aopalliance:jar:1.0:compile
[INFO] |  \- org.springframework.security:spring-security-core:jar:4.2.1.RELEASE:compile
[INFO] +- org.springframework.security:spring-security-config:jar:4.2.1.RELEASE:compile
[INFO] +- org.springframework.data:spring-data-jpa:jar:1.10.6.RELEASE:compile
[INFO] |  +- org.springframework.data:spring-data-commons:jar:1.12.6.RELEASE:compile
[INFO] |  +- org.aspectj:aspectjrt:jar:1.8.9:compile
[INFO] |  +- org.slf4j:slf4j-api:jar:1.7.22:compile
[INFO] |  \- org.slf4j:jcl-over-slf4j:jar:1.7.22:runtime
[INFO] +- org.springframework.integration:spring-integration-mail:jar:4.3.5.RELEASE:compile
[INFO] |  +- org.springframework.integration:spring-integration-core:jar:4.3.5.RELEASE:compile
[INFO] |  |  +- org.springframework:spring-messaging:jar:4.3.4.RELEASE:compile
[INFO] |  |  \- org.springframework.retry:spring-retry:jar:1.1.3.RELEASE:compile
[INFO] |  \- org.springframework:spring-context-support:jar:4.3.4.RELEASE:compile
[INFO] +- org.springframework.security:spring-security-taglibs:jar:4.2.1.RELEASE:compile
[INFO] |  \- org.springframework.security:spring-security-acl:jar:4.2.1.RELEASE:compile
[INFO] +- javax.servlet:javax.servlet-api:jar:3.1.0:provided
[INFO] +- javax.servlet:jstl:jar:1.2:compile
[INFO] +- javax.servlet.jsp:javax.servlet.jsp-api:jar:2.3.1:compile
[INFO] +- org.hibernate:hibernate-core:jar:5.2.5.Final:compile
[INFO] |  +- org.jboss.logging:jboss-logging:jar:3.3.0.Final:compile
[INFO] |  +- org.hibernate.javax.persistence:hibernate-jpa-2.1-api:jar:1.0.0.Final:compile
[INFO] |  +- org.javassist:javassist:jar:3.20.0-GA:compile
[INFO] |  +- antlr:antlr:jar:2.7.7:compile
[INFO] |  +- org.apache.geronimo.specs:geronimo-jta_1.1_spec:jar:1.1.1:compile
[INFO] |  +- org.jboss:jandex:jar:2.0.3.Final:compile
[INFO] |  +- com.fasterxml:classmate:jar:1.3.0:compile
[INFO] |  +- dom4j:dom4j:jar:1.6.1:compile
[INFO] |  +- org.hibernate.common:hibernate-commons-annotations:jar:5.0.1.Final:compile
[INFO] |  \- javax.enterprise:cdi-api:jar:1.1:compile
[INFO] |     +- javax.el:el-api:jar:2.2:compile
[INFO] |     +- org.jboss.spec.javax.interceptor:jboss-interceptors-api_1.1_spec:jar:1.0.0.Beta1:compile
[INFO] |     +- javax.annotation:jsr250-api:jar:1.0:compile
[INFO] |     \- javax.inject:javax.inject:jar:1:compile
[INFO] +- org.hibernate:hibernate-validator:jar:5.2.4.Final:compile
[INFO] |  \- javax.validation:validation-api:jar:1.1.0.Final:compile
[INFO] +- mysql:mysql-connector-java:jar:5.1.40:compile
[INFO] +- commons-dbcp:commons-dbcp:jar:1.4:compile
[INFO] |  \- commons-pool:commons-pool:jar:1.5.4:compile
[INFO] +- com.sun.mail:javax.mail:jar:1.5.6:compile
[INFO] |  \- javax.activation:activation:jar:1.1:compile
[INFO] +- javax.xml.bind:jaxb-api:jar:2.2.12:compile
[INFO] +- junit:junit:jar:4.12:compile
[INFO] |  \- org.hamcrest:hamcrest-core:jar:1.3:compile
[INFO] \- com.fasterxml.jackson.core:jackson-databind:jar:2.8.5:compile
[INFO]    +- com.fasterxml.jackson.core:jackson-annotations:jar:2.8.0:compile
[INFO]    \- com.fasterxml.jackson.core:jackson-core:jar:2.8.5:compile
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.426 s
[INFO] Finished at: 2019-09-12T18:32:40-03:00
[INFO] ------------------------------------------------------------------------
```
