package com.battleasya.bautility;

import com.battleasya.bautility.command.broadcast.*;
import com.battleasya.bautility.handler.PexBlock;
import org.bukkit.plugin.java.JavaPlugin;

public class BAUtility extends JavaPlugin {

    @Override
    public void onEnable() {

        /* staff broadcast */
        getCommand("abc").setExecutor(new ABC());
        getCommand("bbc").setExecutor(new BBC());
        getCommand("nbc").setExecutor(new NBC());
        getCommand("sbc").setExecutor(new SBC());
        getCommand("tbc").setExecutor(new TBC());

        /* listener */
        getServer().getPluginManager().registerEvents(new PexBlock(), this);

    }

}
