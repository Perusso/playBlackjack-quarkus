package com.dev.application;

import com.dev.usecase.Blackjack;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class BlackjackConsoleApplication implements QuarkusApplication {

    /*Ponto de entrada para inicializar o jogo*/
    @Override
    public int run(String... args) {
        Blackjack blackjack = new Blackjack();
        blackjack.startGame();
        return 0;
    }
}
