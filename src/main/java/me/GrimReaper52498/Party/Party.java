package me.GrimReaper52498.Party;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.bukkit.FireworkEffect.Type;

/**
 * Created by Tyler on 11/22/2014.
 */
public class Party extends JavaPlugin {

    private Random random = new Random();

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("Party")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.hasPermission("party.use")) {
                    for (int i = 0; i < 4; i++) {

                        giveMeARocketToAutoLaunch(player);

                    }
                }else{
                    player.sendMessage(String.format("%s%sYou are not allowed to do that!", ChatColor.RED, ChatColor.BOLD));
                }


            }
        }
        return false;
    }

    private void giveMeARocketToAutoLaunch(Player player) {
        int power = (int) (Math.random() * 3) + 1;
        int type = (int) (Math.random() * 5) + 1;

        Type typen = Type.BALL;
        if (type == 1) typen = Type.BALL;
        if (type == 2) typen = Type.BALL_LARGE;
        if (type == 3) typen = Type.BURST;
        if (type == 4) typen = Type.CREEPER;
        if (type == 5) typen = Type.STAR;

        Firework fireworks = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        Firework fireworks2 = (Firework) player.getWorld().spawnEntity(player.getLocation().add(1, 0, 0), EntityType.FIREWORK);
        Firework fireworks3 = (Firework) player.getWorld().spawnEntity(player.getLocation().add(0, 0, 1), EntityType.FIREWORK);
        Firework fireworks4 = (Firework) player.getWorld().spawnEntity(player.getLocation().add(-1, 0, 0), EntityType.FIREWORK);
        Firework fireworks5 = (Firework) player.getWorld().spawnEntity(player.getLocation().add(0, 0, -1), EntityType.FIREWORK);

        FireworkMeta fireworkmeta = fireworks.getFireworkMeta();
        FireworkEffect effect = FireworkEffect.builder().flicker(random.nextBoolean()).withColor(colorchoose()).withFade(colorchoose()).with(typen).trail(random.nextBoolean()).build();
        fireworkmeta.addEffect(effect);
        fireworkmeta.setPower(power);
        fireworks.setFireworkMeta(fireworkmeta);
    }

    private List<Color> colorchoose() {
        // Thanks Zomis and Tejpbit for the help with this function!

        int numberofcolors = random.nextInt(17) + 1;

        List<Color> allcolors = new ArrayList<Color>();
        allcolors.add(Color.AQUA);
        allcolors.add(Color.BLACK);
        allcolors.add(Color.BLUE);
        allcolors.add(Color.FUCHSIA);
        allcolors.add(Color.GRAY);
        allcolors.add(Color.GREEN);
        allcolors.add(Color.LIME);
        allcolors.add(Color.MAROON);
        allcolors.add(Color.NAVY);
        allcolors.add(Color.OLIVE);
        allcolors.add(Color.ORANGE);
        allcolors.add(Color.PURPLE);
        allcolors.add(Color.RED);
        allcolors.add(Color.SILVER);
        allcolors.add(Color.TEAL);
        allcolors.add(Color.WHITE);
        allcolors.add(Color.YELLOW);

        List<Color> choosencolors = new ArrayList<Color>();

        for (int i = 0; i < numberofcolors; i++) {
            choosencolors.add(allcolors.remove(random.nextInt(allcolors.size())));
        }
        return choosencolors;
    }
}