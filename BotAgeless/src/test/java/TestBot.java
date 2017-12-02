/**
 * Created by Trevor on 7/28/2016.
 */

import sx.blah.discord.api.*;
import sx.blah.discord.util.DiscordException;

public class TestBot {
    public static IDiscordClient discordClient;
    private final static String botToken = "MjA4MjU3ODMzNzgxNjkwMzY5.CnvCuA.3qjhGsNI_Db9dcT1KracdN49rEY";


    public static void main(String args[]) {
        discordClient = getClient(botToken);
        discordClient.getDispatcher().registerListener(new EventHandler());
    }


    public static IDiscordClient getClient(String token) {
        try {
            return new ClientBuilder().withToken(token).login();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}