package com.synergy.template.init.types;

import static com.synergy.template.Main.MODULE_ID;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zBlocks {

    public static void register(IEventBus bus) {
        zBlock.register(bus);
        zBlockItem.register(bus);
    }

    public static final DeferredRegister.Blocks zBlock = DeferredRegister.createBlocks(MODULE_ID);
    public static final DeferredRegister.Blocks zBlockItem = DeferredRegister.createBlocks(MODULE_ID);

}
