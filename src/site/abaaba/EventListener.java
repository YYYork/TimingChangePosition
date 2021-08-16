package site.abaaba;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerDie(PlayerDeathEvent e){

        if(Commander.player_list.contains(Commander.p2)&&Commander.player_list.contains(Commander.p1)){
            Player p = e.getEntity();
            Commander.p1.sendMessage("§8[TimingChangePosition] §7玩家§6"+p.getDisplayName()+"§7死亡,游戏结束");
            Commander.p2.sendMessage("§8[TimingChangePosition] §7玩家§6"+p.getDisplayName()+"§7死亡,游戏结束");
            if(p.getUniqueId() == Commander.p1.getUniqueId()){
                Commander.p2.sendTitle("§6恭喜您获得胜利","§e输入指令再来一把吧！");
                Commander.p1.sendTitle("§8很遗憾您失败了","§7输入指令再来一把吧！");
            }
            if(p.getUniqueId() == Commander.p2.getUniqueId()){
                Commander.p1.sendTitle("§6恭喜您获得胜利","§e输入指令再来一把吧！");
                Commander.p2.sendTitle("§8很遗憾您失败了","§7输入指令再来一把吧！");
            }
            Commander.player_list.remove(Commander.p1);
            Commander.player_list.remove(Commander.p2);
            TimingChangePosition.isGameStart = false;
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        if(Commander.player_list.contains(Commander.p2)&&Commander.player_list.contains(Commander.p1)){
            TimingChangePosition.instance.getServer().broadcastMessage("§8[TimingChangePosition] §7有玩家退出游戏，游戏结束");
            Commander.player_list.remove(Commander.p1);
            Commander.player_list.remove(Commander.p2);
            TimingChangePosition.isGameStart = false;
        }
    }

}