# Microsservices Payment App
Projeto de folha de pagamento cujo bjetivo é apresentar uma aplicação distribuída, onde diferentes serviços autônomos se comunicam de maneira eficiente, segura e escalável.

<br>
<h2>Principais Tecnologias</h2>

```
Java 11                # Versão LTS da linguagem
Spring Boot 2          # Framework para desenvolvimento ágil
Spring Cloud           # Para orquestração de microserviços.
Spring Security        # Segurança e autenticação
Maven                  # Gerenciamento de dependências e build
Banco de dados H2      # Usado em desenvolvimento/testes
```


<br>
<h2>Arquitetura</h2>
A arquitetura adotada segue os padrões de microsserviços, separando responsabilidades em diferentes serviços que podem ser implementados, escalados e atualizados independentemente. Utiliza ferramentas como Eureka para descoberta de serviços, Zuul para gateway de API, Config Server para centralização de configurações com OAuth para segurança.


<br>
<br>
<h2>Microsserviços presentes</h2>
<ul>
    <li>hr-api-gateway-zuul: Gateway que centraliza o acesso aos microsserviços, gerenciando roteamento e filtros de segurança.</li>
    <li>hr-config-server: Centraliza as configurações dos microsserviços, facilitando gestão e versionamento.</li>
    <li>hr-eureka-server: Serviço de descoberta, permitindo que microsserviços se registrem e encontrem uns aos outros dinamicamente.</li>
    <li>hr-oauth: Gerencia autenticação e autorização via OAuth2 e <i>token JWT</i> .</li>
    <li>hr-user: Responsável pelo direcionamento de usuários.</li>
    <li>hr-worker: Gestão de informações de colaboradores.</li>
    <li>hr-payroll: Serviço de folha de pagamento.</li>
</ul>


<br>
<h2>Estrutura de diretórios</h2>
<code>microsservices-app/</code><br>
<code>├── hr-api-gateway-zuul/</code><br>
<code>├── hr-config-server/</code><br>
<code>├── hr-eureka-server/</code><br>
<code>├── hr-oauth/</code><br>
<code>├── hr-payroll/</code><br>
<code>├── hr-user/</code><br>
<code>├── hr-worker/</code><br>
<code>├── README.md</code><br>
<code>└── LICENSE</code><br>


<br>
<h2>Repositório de Configurações</h2>

As configurações dos microsserviços estão centralizadas no repositório [ms-course-configs](https://github.com/filipeluisgg/ms-course-configs), que é privado.  
Para rodar o Config Server corretamente, pode-se fornecer as configurações localmente se preferir, ou criar um repositório próprio no gitHub e usar credenciais de acesso ao GitHub via Personal Access Token (PAT) nas configurações do serviço. Para documentação de como gerar um PAT no gitHub, clique [aqui](https://docs.github.com/pt/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#como-criar-um-personal-access-token-classic).


<br>
<h2>Como executar</h2>
1. Clone o repositório <br>

```
git clone [url-do-repositorio]
```
<br>
2. (Opcional) Configure o banco de dados: <br>
Por padrão, os microsserviços utilizam H2 Database para testes/desenvolvimento.
Caso queira usar outro banco (como PostgreSQL ou MySQL), mude o arquivo application.properties de cada microsserviço (também funciona para bancos em docker):

```
spring.datasource.url=jdbc:seu-banco://localhost:XXXX/nome_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
<br>3. Configure o acesso ao repositório privado de configurações: <br>
O Config Server depende do repositório privado ms-course-configs.
Após ler a orientação sobre o repositório privado de configurações acima e ter criado seu PAT, adicione as seguintes variáveis de ambiente na máquina:

```
export SPRING_CLOUD_CONFIG_SERVER_GIT_URI=https://github.com/filipeluisgg/ms-course-configs
export SPRING_CLOUD_CONFIG_SERVER_GIT_USERNAME=seu_usuario_github
export SPRING_CLOUD_CONFIG_SERVER_GIT_PASSWORD=seu_token
```
<br>4. Faça o build do projeto
```
mvn clean package
```
<br>5. Inicie cada microsserviço individualmente <br>
Entre na pasta de cada serviço e execute:
```
mvn spring-boot:run
```


<br>
<h2>Contribuindo</h2>

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

Obs: Para a mensagem do commit, utilize [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/).


<br>
<h2>Versionamento</h2>

Para versionamento do projeto utiliza-se o [Semantic Versioning](http://semver.org/).


<br>
<h2>Autores</h2>
<ul> <li><b>Luis Felipe<b> - <i>Trabalho inicial</i></li> </ul>


<br>
<h2>Licença</h2>

Este projeto está sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.
