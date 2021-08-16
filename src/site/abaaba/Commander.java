package site.abaaba;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Commander implements CommandExecutor {
   public static Player p1,p2;
    public static List player_list = new ArrayList();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length < 3 || args.length > 4) {
            commandSender.sendMessage("§f§l§m--------------------------------------------");
            commandSender.sendMessage("§8[TimingChangePosition] §7您的输入有误?！");
            commandSender.sendMessage("§8[TimingChangePosition] §7正确输入为 /exchange <玩家1> <玩家2> <随机时间(true/flase)> (<间隔时间(min)>)以开始游戏");
            commandSender.sendMessage("§f§l§m--------------------------------------------");
            return true;
        }
        if (args.length == 3) {
            if (Bukkit.getPlayer(args[0]) == null || Bukkit.getPlayer(args[1]) == null) {
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                commandSender.sendMessage("§8[TimingChangePosition] §7有至少一个输入的玩家不存在");
                commandSender.sendMessage("§8[TimingChangePosition] §7请检查输入的名字是否有误");
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                return true;
            }else if(!args[2].equals("true")){
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                commandSender.sendMessage("§8[TimingChangePosition] §7您输入的判断条件有误");
                commandSender.sendMessage("§8[TimingChangePosition] §7如果您想开始随机时间交换，请输入/exchange <玩家1> <玩家2> true");
                commandSender.sendMessage("§8[TimingChangePosition] §7如果您想开始自定义时间交换，请输入/exchange <玩家1> <玩家2> false <间隔时间(min)>");
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                return true;
            }
            if(!TimingChangePosition.isGameStart){
                TimingChangePosition.isGameStart = true;
                p1 = Objects.requireNonNull(Bukkit.getPlayer(args[0]));
                p2 = Objects.requireNonNull(Bukkit.getPlayer(args[1]));
                new BeginSetting(commandSender,p1,p2);
                player_list.add(p1);
                player_list.add(p2);
                ModeMannager.beginRandomTimeGame(p1,p2);
                return true;
            }else{
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                commandSender.sendMessage("§8[TimingChangePosition] §7游戏已经开始，退出游戏和死亡可结束游戏");
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                return true;
            }
        }
        if (args.length == 4) {
            if(args[2].equals("true")){
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                commandSender.sendMessage("§8[TimingChangePosition] §7鱼和熊掌不可兼得");
                commandSender.sendMessage("§8[TimingChangePosition] §7请正确输入指令");
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                return true;
            }
            if (Bukkit.getPlayer(args[0]) == null || Bukkit.getPlayer(args[1]) == null) {
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                commandSender.sendMessage("§8[TimingChangePosition] §7有至少一个输入的玩家不存在");
                commandSender.sendMessage("§8[TimingChangePosition] §7请检查输入的名字是否有误");
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                return true;
            }
            if(!TimingChangePosition.isGameStart){
            int gapTime = Integer.parseInt(args[3]);
            p1 = Objects.requireNonNull(Bukkit.getPlayer(args[0]));
            p2 = Objects.requireNonNull(Bukkit.getPlayer(args[1]));
            new BeginSetting(commandSender,p1,p2);
            TimingChangePosition.isGameStart = true;
            player_list.add(p1);
            player_list.add(p2);
            ModeMannager.beginCustomTimeGame(p1,p2,gapTime);
            return true;
            }else{
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                commandSender.sendMessage("§8[TimingChangePosition] §7游戏已经开始，退出游戏和死亡可结束游戏");
                commandSender.sendMessage("§f§l§m--------------------------------------------");
                return true;
            }
        }
        return true;
    }
}
