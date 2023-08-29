package com.battleasya;

import com.battleasya.Cmd.Broadcast.*;
import com.battleasya.Cmd.StaffChat.SC;
import com.battleasya.Cmd.StaffChat.SCT;
import com.battleasya.Cmd.Utility.Ping;
import com.battleasya.Cmd.Utility.Remind;
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

    public HashMap<String, Integer> staffList = new HashMap<>();

    public HashMap<String, Integer> chatToggleList = new HashMap<>();

    public HashMap<String, Integer> reconnectCD = new HashMap<>();

    @Override
    public void onEnable() {

        /* staff chat */
        getCommand("sc").setExecutor(new SC(this));
        getCommand("sct").setExecutor(new SCT(this));

        /* staff broadcast */
        getCommand("abc").setExecutor(new ABC());
        getCommand("bbc").setExecutor(new BBC());
        getCommand("nbc").setExecutor(new NBC());
        getCommand("sbc").setExecutor(new SBC());
        getCommand("tbc").setExecutor(new TBC());

        /* utility */
        getCommand("ping").setExecutor(new Ping());
        getCommand("remind").setExecutor(new Remind());

        /* listener */
        getServer().getPluginManager().registerEvents(new PexBlock(), this);
        getServer().getPluginManager().registerEvents(new Reconnect(this), this);
        getServer().getPluginManager().registerEvents(new StaffChat(this), this);

    }

    public void msgStaff(String msg) {
        for (Map.Entry<String, Integer> entry : staffList.entrySet()) {
            Player player = Bukkit.getPlayer(entry.getKey());
            if (player != null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
        }
    }

}
