package me.doka.koreanmoney.plugin;


import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String prefix = "&e[DOKA BANK]";
    public static Economy econ = null;
    @Override
    public void onEnable(){
        getLogger().info("DOKA's first plugin is Enable");
        getConfig().addDefault("prefix", this.prefix);
        getConfig().options().copyDefaults(true);
        saveConfig();
        this.prefix = getConfig().getString("prefix");
        if (!setupEconomy()) {
            getLogger().warning("Vault 플러그인을 찾을수 없습니다!!!");
            getLogger().warning("Vault 플러그인을 찾을수 없습니다!!!");
            getLogger().warning("Vault 플러그인을 찾을수 없습니다!!!");
            getLogger().warning("플러그인을 종료합니다.");

            getServer().getPluginManager().disablePlugin((Plugin)this);
            return;
        }
        getCommand("돈").setExecutor((CommandExecutor)new commands());
    }




    public static Economy getEconomy() {
        return econ;
    }
    public boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null)
            return false;
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null)
            return false;
        econ = (Economy)rsp.getProvider();
        return (econ != null);
    }
}
