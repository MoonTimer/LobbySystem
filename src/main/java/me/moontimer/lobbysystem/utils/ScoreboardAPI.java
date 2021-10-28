package me.moontimer.lobbysystem.utils;

import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardScore;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ScoreboardAPI {

    Scoreboard scoreboard;
    ScoreboardObjective obj;
    Player player;

    public ScoreboardAPI(Player player, String name, String display) {
        this.player = player;
        this.scoreboard = new Scoreboard();
        this.obj = this.scoreboard.registerObjective(name, IScoreboardCriteria.b);
        this.obj.setDisplayName(display);
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(this.obj, 0);
        PacketPlayOutScoreboardDisplayObjective displayPacket = new PacketPlayOutScoreboardDisplayObjective(1, this.obj);
        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(this.obj, 1);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(removePacket);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(createPacket);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(displayPacket);
    }

    public void score(int score, String line) {
        ScoreboardScore sbs = new ScoreboardScore(this.scoreboard, this.obj, line);
        sbs.setScore(score);
        ((CraftPlayer)this.player).getHandle().playerConnection.sendPacket(new PacketPlayOutScoreboardScore(sbs));
    }
}
