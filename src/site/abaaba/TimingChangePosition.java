package site.abaaba;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TimingChangePosition extends JavaPlugin {
    public static JavaPlugin instance;
    public static boolean isGameStart;
    @Override
    public void onEnable() {
        if(Bukkit.getPluginCommand("exchange")!=null){
        Bukkit.getPluginCommand("exchange").setExecutor(new Commander());
            Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        this.getLogger().info("§a[TimingChangePosition]§e插件作者 大鸭梨 , QQ 2264117533");
        this.getLogger().info("§a[TimingChangePosition]§eTimingChangePosition v3.3 开启成功！");
        this.getLogger().info("§a[TimingChangePosition]§e快和你的好朋友一起玩耍吧！");
        }
        instance = this;
        isGameStart = false;
    }

    @Override
    public void onDisable() {
        this.getLogger().info("[TimingChangePosition]插件已卸载");
    }
}
