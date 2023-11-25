package org.milkteamc.serverip;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BungeeServerIPCommand extends Command {

    public BungeeServerIPCommand(Plugin plugin) {
        super("serverip");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof net.md_5.bungee.api.connection.ProxiedPlayer) {
            net.md_5.bungee.api.connection.ProxiedPlayer player = (net.md_5.bungee.api.connection.ProxiedPlayer) sender;
            if (player.hasPermission("milkteamc.serverip")) {
                try {
                    URL url = new URL("https://api.ipify.org");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String ip = reader.readLine();
                    reader.close();
                    sender.sendMessage(ChatColor.GREEN + "The server IP is: " + ChatColor.YELLOW + ip);
                } catch (IOException e) {
                    sender.sendMessage(ChatColor.RED + "Failed to retrieve server IP.");
                    e.printStackTrace();
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            }
        } else {
            try {
                URL url = new URL("https://api.ipify.org");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String ip = reader.readLine();
                reader.close();
                sender.sendMessage(ChatColor.GREEN + "The server IP is: " + ChatColor.YELLOW + ip);
            } catch (IOException e) {
                sender.sendMessage(ChatColor.RED + "Failed to retrieve server IP.");
                e.printStackTrace();
            }
        }
    }
}
