package com.synergy.template.init.types;

import static com.synergy.template.Main.MODULE_ID;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zCreativeTab {

    public static void register(IEventBus bus) {
        zCreative.register(bus);
    }

    public static final DeferredRegister<CreativeModeTab> zCreative = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, MODULE_ID);

//     public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MACHINES_TAB = RegistryUtils
//             .createCreativeTab(MODULE_ID, MODULE_ID, () -> Items.STONE,
//                     zCreativeTab.zCreative);

}