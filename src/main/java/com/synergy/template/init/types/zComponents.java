package com.synergy.template.init.types;

import static com.synergy.template.Main.MODULE_ID;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zComponents {
        public static void register(IEventBus bus) {
                zComponents.register(bus);

        }

        public static final DeferredRegister<DataComponentType<?>> zComponents = DeferredRegister
                        .createDataComponents(Registries.DATA_COMPONENT_TYPE, MODULE_ID);

        // public static final DeferredHolder<DataComponentType<?>,
        // DataComponentType<BlockState>> ID = zComponents
        // .register("id",
        // () -> DataComponentType.<BlockState>builder()
        // .persistent(BlockState.CODEC)
        // .networkSynchronized(ByteBufCodecs.fromCodec(BlockState.CODEC))
        // .build());

}