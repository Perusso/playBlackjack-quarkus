package com.dev.application;

import com.dev.application.usecase.Blackjack;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class BlackjackConsoleApplication implements QuarkusApplication {

    @Override
    public int run(String... args) {
        Blackjack blackjack = new Blackjack();
        blackjack.startGame(true);
        return 0;
    }
}
