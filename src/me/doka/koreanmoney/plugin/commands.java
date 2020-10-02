package me.doka.koreanmoney.plugin;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("[ERROR] 콘솔에선 사용이 불가능 합니다!");
            return false;
        }
        else{
            Economy eco = Main.getEconomy();
            Player player = (Player) commandSender;

            if (args.length == 0)
            {


                String tmp = Double.toString(eco.getBalance((OfflinePlayer)player));
                player.sendMessage("");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix) + ChatColor.WHITE + " 소지금: " + ChatColor.GREEN + tmp + " 원");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix) + ChatColor.WHITE + " /돈 보내기 [플레이어] [금액] - [플레이어]에게 [금액] 만큼의 돈을 보냅니다.");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix) + ChatColor.WHITE + " /돈 순위 - 돈 순위를 확인합니다.");
                player.sendMessage("");
                if (!player.hasPermission("dokamoney.admin")) {
                    return true;
                }
                player.sendMessage(ChatColor.BLUE + "                        [관리자 명령어]");

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix) + ChatColor.WHITE + " /돈 주기 [플레이어] [금액] - [플레이어]에게 [금액] 만큼의 돈을 지급합니다.");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix) + ChatColor.WHITE + " /돈 뺏기 [플레이어] [금액] - [플레이어]에게 [금액] 만큼의 돈을 뻇습니다.");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix) + ChatColor.WHITE + " /돈 확인 [플레이어] - [플레이어]의 소지금을 확인합니다.");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix) + ChatColor.WHITE + " /돈 설정 [플레이어] [금액] - [플레이어]의 소지금을 [금액]으로 설정합니다.");
                player.sendMessage("");
            }
            if (args.length == 1)
            {
                if(args[0].equalsIgnoreCase("확인"))
                {
                    String tmp = Double.toString(eco.getBalance((OfflinePlayer)player));
                    player.sendMessage("");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix) + ChatColor.WHITE + " 소지금: " + ChatColor.GREEN + tmp + " 원");
                    player.sendMessage("");

                }
            }
        }


        return false;
    }
}
