package com.aurora.createram;


import com.aurora.createram.registy.CRAMItems;
import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CreateRAM.MODID)
public class CreateRAM {

    public static final String MODID = "createram";
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateRAM.MODID);
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateRAM() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get()
                .getModEventBus();

        REGISTRATE.registerEventListeners(modEventBus);

        CRAMItems.register();

        MinecraftForge.EVENT_BUS.register(this);

    }
}
