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

import static org.bukkit.Bukkit.getServer;

public class RealnameCMD implements CommandExecutor{
    final MySQLNicks mySQLNicks = MySQLNicks.getInstance();
    private final CommandSender cs = Bukkit.getConsoleSender();
    @Override
    public  boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(MessageUtil.getMessage("nick.insufficient-arguments"));
            return true;
        }
        //get nickname from args[0]
        String nickname = args[0];
        //get UUID from database
        String uuid = String.valueOf(DataUtil.getUUID(nickname));
        //get player from UUID
        if (uuid == null) {
            sender.sendMessage(MessageUtil.getMessage("nick.realname-failure"));
            return true;
        }
        cs.sendMessage(uuid);
        Player player = getServer().getPlayer(uuid);
        if (player != null) {
            //send player name to sender
            sender.sendMessage(MessageUtil.getMessage("nick.realname-success").replace("%player%", player.getName()));
            return true;
        }
        else {
            sender.sendMessage(MessageUtil.getMessage("nick.realname-failure"));
            return true;
        }
    }

}
