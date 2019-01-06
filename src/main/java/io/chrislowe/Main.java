package io.chrislowe;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Main {
    private static final String ERROR_LOGIN = "Could not login with your given token. " +
            "Please update your token in config.txt, verify internet connectivity, and restart.";

    private static JDA jda;

    public static void main(String[] args) throws InterruptedException {
        Config config = Config.Companion.fromFileName("config.txt");

        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken(config.get("discord_token"))
                    .addEventListener(new MessageListener())
                    .setGame(Game.playing("with your heart"))
                    .build().awaitReady();
        } catch (LoginException ex) {
            System.err.println(ERROR_LOGIN);
        }
    }
}
