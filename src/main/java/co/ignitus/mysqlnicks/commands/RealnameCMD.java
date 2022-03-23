package co.ignitus.mysqlnicks.commands;

import co.ignitus.mysqlnicks.MySQLNicks;
import co.ignitus.mysqlnicks.util.DataUtil;
import co.ignitus.mysqlnicks.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.sql.Connection;

public class RealnameCMD implements CommandExecutor{
    final MySQLNicks mySQLNicks = MySQLNicks.getInstance();

    @Override
    public  boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(MessageUtil.getMessage("nick.insufficient-arguments"));
            return true;
        }

    }

}
