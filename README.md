
# Blackjack Console Quarkus
Este é um projeto de exemplo que implementa o jogo de Blackjack em um console usando o framework Quarkus em Java.

## Regras do Jogo
O objetivo do Blackjack é vencer o dealer, chegando o mais próximo possível de 21 sem ultrapassar esse valor. Aqui estão as regras básicas do jogo:

Os jogadores começam recebendo duas cartas viradas para cima, enquanto o dealer recebe uma carta virada para cima e outra virada para baixo.
Os jogadores têm a opção de "Hit" (receber outra carta) ou "Stand" (não receber mais cartas).
Após a vez dos jogadores, o dealer continuará comprando cartas até atingir ou ultrapassar um valor mínimo de 17.
Os jogadores que tiverem um valor total maior que o do dealer ou que somarem exatamente 21 serão os vencedores.

## Executando o Projeto
Certifique-se de ter o ambiente de desenvolvimento Java e o Maven instalados. Siga as etapas abaixo para compilar e executar o projeto:

### Clone o repositório do projeto:

```git clone https://github.com/Perusso/blackjack-quarkus```

### Navegue até o diretório do projeto:

```cd blackjack-quarkus```

### Execute o seguinte comando para conceder permissões de execução ao arquivo mvnw:

```chmod +x mvnw```

### Compile o projeto usando o Maven:

```./mvnw package -Dmaven.test.redirectTestOutputToFile=true``` (Mac/Linux)

```mvnw package -Dmaven.test.redirectTestOutputToFile=true``` (Windows)

### Execute o projeto com o comando:

```java -jar target/quarkus-app/quarkus-run.jar```

Consulte a documentação oficial do Quarkus para obter mais informações sobre o empacotamento e a execução do aplicativo.

## Contribuindo
Se você quiser contribuir para este projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request. Toda contribuição é bem-vinda!

## Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais informações.
