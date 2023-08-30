package com.battleasya.bautility;

import com.battleasya.bautility.command.broadcast.*;
import com.battleasya.bautility.command.staffchat.SC;
import com.battleasya.bautility.command.staffchat.SCT;
import com.battleasya.bautility.command.utility.Ping;
import com.battleasya.bautility.command.utility.Remind;
import com.battleasya.bautility.handler.PexBlock;
import com.battleasya.bautility.handler.Reconnect;
import com.battleasya.bautility.handler.StaffChat;
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
