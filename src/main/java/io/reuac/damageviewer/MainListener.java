package io.reuac.damageviewer;

import java.text.DecimalFormat;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

public class MainListener implements Listener {
    static String message_normal;
    static String message_die;
    static String title_normal;
    static String title_normal_sub;
    static String title_die;
    static String title_die_sub;

    static boolean OnlyPlayer;

    static boolean enableTitle;
    static boolean enableMessage;
    static boolean titleOnShot;
    static boolean titleOnAttack;
    static boolean messageOnShot;
    static boolean messageOnAttack;

    static DecimalFormat df;

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.isCancelled()){return;}

        LivingEntity Damagee = (LivingEntity) event.getEntity();
        Entity damager = event.getDamager();
        if (OnlyPlayer && !(Damagee instanceof Player)){return;}

        Player attacker;

        if (damager instanceof Player) {
            attacker = (Player) damager;

            if (Damagee.getHealth() - event.getFinalDamage() > 0) {
                if (enableTitle && titleOnAttack && attacker.hasPermission("damageviewer.onattack.title")) {
                    attacker.sendTitle(makeString(title_normal, event, attacker),makeString(title_normal_sub, event, attacker));
                }
                if (enableMessage && messageOnAttack && attacker.hasPermission("damageviewer.onattack.message")){
                    attacker.sendMessage(makeString(message_normal, event, attacker));
                }
            } else {
                if (enableTitle && titleOnAttack && attacker.hasPermission("damageviewer.onattack.title")){
                    attacker.sendTitle(makeString(title_die, event, attacker),makeString(title_die_sub, event, attacker));
                }
                if (enableMessage && messageOnAttack && attacker.hasPermission("damageviewer.onattack.message")){
                    attacker.sendMessage(makeString(message_die, event, attacker));
                }
            }

        } else if (damager instanceof Projectile) {
            ProjectileSource shooter = ((Projectile) damager).getShooter();
            if (shooter instanceof Player) {
                attacker = (Player) shooter;

                if (Damagee.getHealth() - event.getFinalDamage() > 0) {
                    if (enableTitle && titleOnShot && attacker.hasPermission("damageviewer.onshot.title")){
                        attacker.sendTitle(makeString(title_normal, event, attacker), makeString(title_normal_sub, event, attacker));
                    }
                    if (enableMessage && messageOnShot && attacker.hasPermission("damageviewer.onshot.message")){
                        attacker.sendMessage(makeString(message_normal, event, attacker));
                    }

                } else {
                    if (enableTitle && titleOnShot && attacker.hasPermission("damageviewer.onshot.title")){
                        attacker.sendTitle(makeString(title_die, event, attacker),makeString(title_die_sub, event, attacker));
                    }
                    if (enableMessage && messageOnShot && attacker.hasPermission("damageviewer.onshot.message")){
                        attacker.sendMessage(makeString(message_die, event, attacker));
                    }
                }

            }
        }
    }
    private String makeString(String style,EntityDamageByEntityEvent event,Player attacker){
        LivingEntity Damagee = (LivingEntity) event.getEntity();

        Double Damagee_Max_Health = Damagee.getMaxHealth();
        Double Damage_value = event.getFinalDamage();
        Double Damagee_Health = Damagee.getHealth();

        return style.replace("%Damager%", attacker.getName())
                .replace("%Damagee_Health%",df.format(Damagee_Health - Damage_value))
                .replace("%Damagee%",Damagee.getName())
                .replace("%Damagee_Max_Health%",df.format(Damagee_Max_Health))
                .replace("%Damage_value%",df.format(Damage_value));
    }

}
