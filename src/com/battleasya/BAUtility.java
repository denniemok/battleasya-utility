package com.battleasya;

import com.battleasya.command.broadcast.*;
import com.battleasya.command.staffchat.SC;
import com.battleasya.command.staffchat.SCT;
import com.battleasya.command.utility.Ping;
import com.battleasya.command.utility.Remind;
import com.battleasya.handler.PexBlock;
import com.battleasya.handler.StaffChat;
import com.battleasya.handler.Reconnect;
import org.bukkit.plugin.java.JavaPlugin;

public class BAUtility extends JavaPlugin {

    @Override
    public void onEnable() {

        /* staff chat */
        getCommand("sc").setExecutor(new SC());
        getCommand("sct").setExecutor(new SCT());

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
        getServer().getPluginManager().registerEvents(new StaffChat(), this);

    }

}
