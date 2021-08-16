package site.abaaba;

import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.math.BigDecimal;
import java.util.Random;

public class ModeMannager {
    private static int i =0;

    public static void spreadAllPlayer(CommandSender commandSender){
        TimingChangePosition.instance.getServer().dispatchCommand(commandSender,"spreadplayers ~ ~ 300 1000 false @a");
    }

    public static void clearAllPlayer(CommandSender commandSender){
        TimingChangePosition.instance.getServer().dispatchCommand(commandSender,"clear @a");
    }

    public static void setAllPlayerSurvival(CommandSender commandSender){
        TimingChangePosition.instance.getServer().dispatchCommand(commandSender,"gamemode survival @a");
    }

    public static void bossbarTiming(BossBar bossBar){
        BigDecimal b = new BigDecimal((double)(60-i)/15);
        double doublef1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        new BukkitRunnable(){
            @Override
            public void run() {
                bossBar.setProgress(doublef1);
                bossBar.setTitle("§6§l距离交换还有 §e§l"+ (60-i) +" §6§l秒");
                if ( (60-i) == 0 ){
                    bossBar.removePlayer(Commander.p1);
                    bossBar.removePlayer(Commander.p2);
                }
                if ( (60-i) == 5 ){
                    bossBar.setColor(BarColor.RED);
                }
                if ( (60-i) == 15 ){
                    bossBar.addPlayer(Commander.p1);
                    bossBar.addPlayer(Commander.p2);
                }
            }


        }.runTaskAsynchronously(TimingChangePosition.instance);
    }

    public static void beginCustomTimeGame(Player p1, Player p2,int gapTime){
        new BukkitRunnable() {
            @Override
            public void run() {
                BossBar bossBar = Bukkit.createBossBar(
                        new NamespacedKey(TimingChangePosition.instance, "Timing_bar"),
                        "§6§l距离交换还有 §e§l"+ (60-i) +" §6§l秒",
                        BarColor.GREEN,
                        BarStyle.SOLID,
                        BarFlag.DARKEN_SKY
                );
                p1.sendTitle("§4§l游戏开始", "§7坑死你的好基友吧");
                p2.sendTitle("§4§l游戏开始", "§7坑死你的好基友吧");
                while (TimingChangePosition.isGameStart) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;

                    if (i == 2) {
                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_ENDER_DRAGON_GROWL, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_ENDER_DRAGON_GROWL, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );
                    }

                    if (i == gapTime * 60 - 15)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 14)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 13)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 12)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 11)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 10) {
                        p1.sendTitle("§4交换将在 §c10 §4秒 §4后开始", "§6请注意");
                        p2.sendTitle("§4交换将在 §c10 §4秒 §4后开始", "§6请注意");
                        bossbarTiming(bossBar);
                    }

                    if (i == gapTime * 60 - 9)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 8)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 7)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 6)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 5){
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                    }
                    if (i == gapTime * 60 - 4){
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );


                    }

                    if (i == gapTime * 60 - 3) {
                        p1.sendMessage("§8[TimingChangePosition] §7交换将在3秒后开始");
                        p2.sendMessage("§8[TimingChangePosition] §7交换将在3秒后开始");
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );


                    }

                    if (i == gapTime * 60 - 2) {
                        p1.sendMessage("§8[TimingChangePosition] §7交换将在2秒后开始");
                        p2.sendMessage("§8[TimingChangePosition] §7交换将在2秒后开始");
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );


                    }

                    if (i == gapTime * 60 - 1) {
                        p1.sendMessage("§8[TimingChangePosition] §7交换将在1秒后开始");
                        p2.sendMessage("§8[TimingChangePosition] §7交换将在1秒后开始");
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );


                    }

                    if (i == gapTime * 60) {
                        Bukkit.getScheduler().runTask(TimingChangePosition.instance, () -> {
                            Location p1l = p1.getLocation();
                            p1.teleport(p2.getLocation());
                            p2.teleport(p1l);
                            p1.sendMessage("§8[TimingChangePosition] §7您的位置已成功交换");
                            p2.sendMessage("§8[TimingChangePosition] §7您的位置已成功交换");

                            World overworld1 = p1.getWorld();
                            World overworld2 = p2.getWorld();
                            overworld1.playSound(
                                    p1.getLocation(), // Location 对象确定位置
                                    Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                    SoundCategory.HOSTILE, // 可选，音效分类
                                    1, // 音量，参考下面的说明
                                    1 // 播放速度
                            );

                            overworld2.playSound(
                                    p2.getLocation(), // Location 对象确定位置
                                    Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                    SoundCategory.HOSTILE, // 可选，音效分类
                                    1, // 音量，参考下面的说明
                                    1 // 播放速度
                            );

                        });
                        i = 0;
                        bossbarTiming(bossBar);
                    }
                }
            }
        }.runTaskAsynchronously(TimingChangePosition.instance);
    }

    public static void beginRandomTimeGame(Player p1, Player p2){
        new BukkitRunnable() {
            @Override
            public void run() {
                Random a = new Random();
                int gapTime = a.nextInt(10);
                int i = 0;
                p1.sendTitle("§4§l游戏开始", "§7坑死你的好基友吧");
                p2.sendTitle("§4§l游戏开始", "§7坑死你的好基友吧");
                while (TimingChangePosition.isGameStart) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    BossBar bossBar = Bukkit.createBossBar(
                            new NamespacedKey(TimingChangePosition.instance, "Timing_bar"),
                            "§6§l距离交换还有 §e§l"+ (60-i) +" §6§l秒",
                            BarColor.GREEN,
                            BarStyle.SOLID,
                            BarFlag.DARKEN_SKY
                    );

                    i++;

                    if (i == 2){
                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_ENDER_DRAGON_GROWL, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_ENDER_DRAGON_GROWL, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                    }
                    if (i == gapTime * 60 - 15)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 14)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 13)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 12)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 11)
                        bossbarTiming(bossBar);

                    if (i == gapTime * 60 - 10) {
                        p1.sendTitle("§4交换将在 §c10 §4秒 §4后开始", "§6请注意");
                        p2.sendTitle("§4交换将在 §c10 §4秒 §4后开始", "§6请注意");
                        bossbarTiming(bossBar);
                    }
                    if (i == gapTime * 60 - 9)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 8)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 7)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 6)
                        bossbarTiming(bossBar);
                    if (i == gapTime * 60 - 5){
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                    }
                    if (i == gapTime * 60 - 4){
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );


                    }

                    if (i == gapTime * 60 - 3) {
                        p1.sendMessage("§8[TimingChangePosition] §7交换将在3秒后开始");
                        p2.sendMessage("§8[TimingChangePosition] §7交换将在3秒后开始");
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );


                    }
                    if (i == gapTime * 60 - 2) {
                        p1.sendMessage("§8[TimingChangePosition] §7交换将在2秒后开始");
                        p2.sendMessage("§8[TimingChangePosition] §7交换将在2秒后开始");
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );


                    }
                    if (i == gapTime * 60 - 1) {
                        p1.sendMessage("§8[TimingChangePosition] §7交换将在1秒后开始");
                        p2.sendMessage("§8[TimingChangePosition] §7交换将在1秒后开始");
                        bossbarTiming(bossBar);

                        World overworld1 = p1.getWorld();
                        World overworld2 = p2.getWorld();
                        overworld1.playSound(
                                p1.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );

                        overworld2.playSound(
                                p2.getLocation(), // Location 对象确定位置
                                Sound.ENTITY_EXPERIENCE_ORB_PICKUP, // 音效
                                SoundCategory.HOSTILE, // 可选，音效分类
                                1, // 音量，参考下面的说明
                                1 // 播放速度
                        );


                    }
                    if (i == gapTime * 60) {
                        Bukkit.getScheduler().runTask(TimingChangePosition.instance, () -> {
                            Location p1l = p1.getLocation();
                            p1.teleport(p2.getLocation());
                            p2.teleport(p1l);
                            p1.sendMessage("§8[TimingChangePosition] §7您的位置已成功交换");
                            p2.sendMessage("§8[TimingChangePosition] §7您的位置已成功交换");

                            World overworld1 = p1.getWorld();
                            World overworld2 = p2.getWorld();
                            overworld1.playSound(
                                    p1.getLocation(), // Location 对象确定位置
                                    Sound.ENTITY_ENDERMAN_TELEPORT, // 音效
                                    SoundCategory.HOSTILE, // 可选，音效分类
                                    1, // 音量，参考下面的说明
                                    1 // 播放速度
                            );

                            overworld2.playSound(
                                    p2.getLocation(), // Location 对象确定位置
                                    Sound.ENTITY_ENDERMAN_TELEPORT, // 音效
                                    SoundCategory.HOSTILE, // 可选，音效分类
                                    1, // 音量，参考下面的说明
                                    1 // 播放速度
                            );

                        });
                        i = 0;
                        bossbarTiming(bossBar);
                        gapTime = a.nextInt(10);
                    }
                }
            }
        }.runTaskAsynchronously(TimingChangePosition.instance);
    }

}
