package com.aurora.createram.registy;

import com.aurora.createram.CreateRAM;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreateRAMCreativeModeTab {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateRAM.MODID);

    public static final RegistryObject<CreativeModeTab> CCB_CREATIVE_TAB = REGISTER.register(CreateRAM.MODID,
            () -> CreativeModeTab.builder()
                    .title(Components.translatable("itemGroup.createram.base"))
                    .icon(AllItems.WRENCH::asStack)
                    .build());

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
