
# Blackjack Console Quarkus
Este é um projeto que implementa o jogo de Blackjack em um console usando o framework Quarkus em Java.

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

```chmod +x mvnw``` (Mac)

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


---


# Blackjack Console Quarkus
This is a project that implements the game of Blackjack in a console using the Quarkus framework in Java.

## Game Rules
The objective of Blackjack is to beat the dealer by getting as close as possible to 21 without exceeding it. Here are the basic rules of the game:

Players start by receiving two cards face-up, while the dealer receives one card face-up and another face-down.
Players have the option to "Hit" (receive another card) or "Stand" (not receive more cards).
After the players' turn, the dealer will continue to draw cards until reaching or exceeding a minimum value of 17.
Players who have a total value greater than the dealer's or who exactly reach 21 will be the winners.

## Running the Project
Make sure you have the Java development environment and Maven installed. Follow the steps below to compile and run the project:

### Clone the project repository:
```git clone https://github.com/Perusso/blackjack-quarkus```

### Navigate to the project directory:
```cd blackjack-quarkus```

### Execute the following command to grant execution permissions to the mvnw file:
```chmod +x mvnw ```(Mac)

### Compile the project using Maven:
```./mvnw package -Dmaven.test.redirectTestOutputToFile=true``` (Mac/Linux)

```mvnw package -Dmaven.test.redirectTestOutputToFile=true``` (Windows)

### Run the project with the command:
```java -jar target/quarkus-app/quarkus-run.jar```

Refer to the official Quarkus documentation for more information on packaging and running the application.

## Contributing
If you want to contribute to this project, feel free to open an issue or submit a pull request. Any contribution is welcome!

## License
This project is licensed under the MIT License. See the LICENSE file for more information.


























