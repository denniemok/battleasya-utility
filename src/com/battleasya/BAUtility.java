package com.battleasya;

import com.battleasya.Cmd.Broadcast.*;
import com.battleasya.Cmd.StaffChat.sc;
import com.battleasya.Cmd.StaffChat.sct;
import com.battleasya.Cmd.Utility.ping;
import com.battleasya.Cmd.Utility.remind;
import com.battleasya.Handler.Lobby;
import com.battleasya.Handler.PexBlock;
import com.battleasya.Handler.StaffChat;
import com.battleasya.Handler.Reconnect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class BAUtility extends JavaPlugin {

    public HashMap<String, Integer> staff = new HashMap<>();

    public HashMap<String, Integer> chatToggle = new HashMap<>();

    public HashMap<String, Integer> reconnectCD = new HashMap<>();

    @Override
    public void onEnable() {

        /* staff chat */
        getCommand("sc").setExecutor(new sc(this));
        getCommand("sct").setExecutor(new sct(this));

        /* staff broadcast */
        getCommand("abc").setExecutor(new abc());
        getCommand("bbc").setExecutor(new bbc());
        getCommand("nbc").setExecutor(new nbc());
        getCommand("sbc").setExecutor(new sbc());
        getCommand("tbc").setExecutor(new tbc());

        /* utility */
        getCommand("ping").setExecutor(new ping());
        getCommand("remind").setExecutor(new remind());

        /* listener */
        getServer().getPluginManager().registerEvents(new Lobby(this), this);
        getServer().getPluginManager().registerEvents(new PexBlock(), this);
        getServer().getPluginManager().registerEvents(new Reconnect(this), this);
        getServer().getPluginManager().registerEvents(new StaffChat(this), this);

    }

    public void msgStaff(String msg) {
        for (Map.Entry<String, Integer> entry : staff.entrySet()) {
            Player player = Bukkit.getPlayer(entry.getKey());
            if (player != null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
        }
    }

}
