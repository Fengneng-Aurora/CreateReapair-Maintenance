package com.aurora.createram.registy;


import com.simibubi.create.AllCreativeModeTabs;
import net.minecraftforge.fml.common.Mod;

import static com.aurora.createram.CreateRAM.REGISTRATE;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CRAMItems {
    static {
        REGISTRATE.setCreativeTab(AllCreativeModeTabs.BASE_CREATIVE_TAB);
    }

    public static void register() {}

}
