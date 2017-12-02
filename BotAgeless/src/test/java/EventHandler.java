/**
 * Created by Trevor on 7/28/2016.
 */

import sx.blah.discord.api.*;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.*;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.ArrayList;

public class EventHandler {


    @EventSubscriber
    public void onReadyEvent(ReadyEvent event) {
        System.out.println("The bot is now ready");
        //try {
        //TestBot.discordClient.getChannelByID("208016460289671169").sendMessage("Hi Siku, I'm a bot");

        /**} catch (MissingPermissionsException e) {
         e.printStackTrace();
         } catch (RateLimitException e) {
         e.printStackTrace();
         } catch (DiscordException e) {
         e.printStackTrace();
         }**/

    }

    @EventSubscriber
    public void onUserJoinEvent(UserJoinEvent event) {
        System.out.println("hi");
        Member names = new Member();
        names.writeJson();
        names.setNames();
        ArrayList<String> name = names.getNames();
        if (name.contains(event.getUser().getName().toLowerCase())) {
            IGuild guild = event.getGuild();
            IRole role = guild.getRoles().get(3);
            try {
                guild.editUserRoles(event.getUser(), new IRole[]{role});
            } catch (MissingPermissionsException e) {
                e.printStackTrace();
            } catch (RateLimitException e) {
                e.printStackTrace();
            } catch (DiscordException e) {
                e.printStackTrace();
            }
        }
    }

    @EventSubscriber
    public void onPresenceUpdateEvent(PresenceUpdateEvent event) {
        System.out.println(event.getNewPresence());
        System.out.println(event.getUser());
        Member names = new Member();
        ArrayList<String> name = names.getNames();
        if (name.contains(event.getUser().getName().toLowerCase())) {
            IGuild guild = event.getGuild();
            IRole role = guild.getRoles().get(3);
            try {
                guild.editUserRoles(event.getUser(), new IRole[]{role});
            } catch (MissingPermissionsException e) {
                e.printStackTrace();
            } catch (RateLimitException e) {
                e.printStackTrace();
            } catch (DiscordException e) {
                e.printStackTrace();
            }
        }


    }

    @EventSubscriber
    public void onMessageEvent(MessageReceivedEvent event) {
        System.out.println(event.getMessage().getAuthor().getName() + ": " + event.getMessage().getContent());
    }
}