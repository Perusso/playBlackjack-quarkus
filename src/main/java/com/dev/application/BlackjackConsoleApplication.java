package com.dev.application;

import com.dev.application.usecase.PlayBlackjack;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class BlackjackConsoleApplication implements QuarkusApplication {

    @Override
    public int run(String... args) {
        PlayBlackjack playBlackjack = new PlayBlackjack();
        playBlackjack.startGame(true);
        return 0;
    }
}
