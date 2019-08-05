### FJ22 - Desenvolvendo na prática com Spring e testes

### Referências

- [Git config](https://git-scm.com/docs/git-config)
- [Git - external links](https://git-scm.com/doc/ext)


### Artigos (Ler depois)

- [A successful git branching model](https://nvie.com/posts/a-successful-git-branching-model/)
- [Não posso descobrir nem instanciar tipos genericos! Porque ?](https://blog.caelum.com.br/nao-posso-descobrir-nem-instanciar-tipos-genericos-porque/)
- [Spring form tutorial](https://www.baeldung.com/spring-mvc-form-tutorial)
- [Três técnicas de ciclo de vida do Beans no Spring](https://imasters.com.br/back-end/tres-tecnicas-de-ciclo-de-vida-dos-beans-no-spring)
- [What is a Spring Bean?](https://www.baeldung.com/spring-bean)
- [Error codes with Spring](https://www.logicbig.com/tutorials/spring-framework/spring-core/error-codes.html)
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

#### Anotações JPA e outros conceitos
- [@Entity](https://www.oracle.com/technetwork/middleware/ias/entity-annotations-090770.html)
- [Why does Hibernate require no argument constructor?](https://stackoverflow.com/questions/2935826/why-does-hibernate-require-no-argument-constructor/29433238#29433238)
- [Como usar a anotação Generated Value](https://www.devmedia.com.br/jpa-como-usar-a-anotacao-generatedvalue/38592)
- [Conheça o Spring Transactional Annotation](https://www.devmedia.com.br/conheca-o-spring-transactional-annotations/32472)
- [Consultas fortemente tipadas com JPA](https://blog.caelum.com.br/consultas-fortemente-tipadas-com-jpa/)
- [JPQL - Using TypedQuery](https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/jpql-typed-query.html)
- [Spring Databinder Examples](https://www.logicbig.com/how-to/code-snippets/jcode-spring-framework-databinder.html)
- [What is unitName in @PersistenceContext?](https://coderanch.com/t/481448/certification/unitName-PersistenceContext)
- [@Autowired vs @PersistenceContext for EntityManager bean](https://stackoverflow.com/questions/31335211/autowired-vs-persistencecontext-for-entitymanager-bean)
- [Injection Of Entitymanager](https://tomee.apache.org/examples-trunk/injection-of-entitymanager/README.html)
- [Entendendo o Java PersistenceContext Extended e Transient](https://www.devmedia.com.br/entendendo-o-java-persistencecontext-extended-e-transient/30493)


#### Startup de um projeto novo

- [Spring MVC Framework Tutorial Simplest Hello World Example with UI (JSP) Page](https://crunchify.com/simplest-spring-mvc-hello-world-example-tutorial-spring-model-view-controller-tips/)
- [Configurando um projeto java com spring e maven](http://www.ciceroednilson.com.br/configurando-um-projeto-java-com-spring-mvc-e-maven/)
- [How to create a web project using maven in eclipse](https://dzone.com/articles/how-to-create-a-web-project-using-maven-in-eclipse-1)
- [Creating a Spring MVC project using Maven and Eclipse in one minute](https://www.codejava.net/frameworks/spring/creating-a-spring-mvc-project-using-maven-and-eclipse-in-one-minute)

Importante sobre startup de um novo projeto: 

> One thing to note here is the name of servlet in <servlet-name> tag in web.xml. Once the DispatcherServlet is initialized, it will looks for a file name [servlet-name]-servlet.xml  in WEB-INF folder of web application. In this example, the framework will look for file called crunchify-servlet.xml.

- [rejectValue from BindingResult](https://docs.spring.io/spring/docs/3.1.x/javadoc-api/org/springframework/validation/Errors.html#rejectValue%28java.lang.String,%20java.lang.String,%20java.lang.String%29)
- [Adding error message to Spring 3 DataBinder for custom object fields](https://stackoverflow.com/questions/12107503/adding-error-message-to-spring-3-databinder-for-custom-object-fields)

## Capítulo 3

Fiz alguns testes usando double e BigDecimal [aqui](https://gist.github.com/fllsouto/687e02c67d2b4f9d4f6a60a0bc464ef5).

- [Retain precision with double Java](https://stackoverflow.com/questions/322749/retain-precision-with-double-in-java)
- [Easiest ways to navigate with eclipse](https://dzone.com/articles/easiest-ways-navigate-methods)

## Capítulo 4

- [Consuming a RESTful Web Service](https://spring.io/guides/gs/consuming-rest/)
- [RestTemplate Javadoc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)