package site.abaaba;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class BeginSetting {
    CommandSender commandSender;
    BeginSetting(CommandSender commandSender,Player p1,Player p2){
        this.commandSender = commandSender;
        PotionEffect pe = new PotionEffect(PotionEffectType.HEAL,100,3);
        PotionEffect pe2 = new PotionEffect(PotionEffectType.SATURATION,100,1);
        pe.apply(Objects.requireNonNull(p1));
        pe.apply(Objects.requireNonNull(p2));
        pe2.apply(Objects.requireNonNull(p1));
        pe2.apply(Objects.requireNonNull(p2));
        ModeMannager.spreadAllPlayer(commandSender);
        ModeMannager.setAllPlayerSurvival(commandSender);
        ModeMannager.clearAllPlayer(commandSender);
    }
}
