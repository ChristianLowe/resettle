package io.chrislowe;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        var channel = event.getChannel();
        var author = event.getAuthor();
        var message = event.getMessage();

        if (!channel.getName().equalsIgnoreCase("resettle") || author.isBot()) {
            return;
        }

        System.out.printf("%s: %s\n", author.getName(), message.getContentDisplay());

        String[] messageParams = message.getContentDisplay().trim().split("\\s+");

        // TODO: expand
        // messageParams[0] is the user command, the rest of the indices are the arguments
        switch (messageParams[0]) {
            case "ping": channel.sendMessage("Pong!").complete(); break;
        }
    }
}
