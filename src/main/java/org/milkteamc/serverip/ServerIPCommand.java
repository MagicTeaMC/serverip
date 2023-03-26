package org.milkteamc.serverip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ServerIPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("serverip")) {
            if (sender.isOp() || sender.hasPermission("milkteamc.serverip")) {
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
            return true;
        }
        return false;
    }

}

