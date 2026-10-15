package com.synergy.template.init.types;

import static com.synergy.template.Main.MODULE_ID;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zContainers {
        public static void register(IEventBus bus) {
                zMenu.register(bus);
        }

        public static final DeferredRegister<MenuType<?>> zMenu = DeferredRegister.create(Registries.MENU, MODULE_ID);

        // public static final DeferredHolder<MenuType<?>, MenuType<GUI>> SIMPLE_TICKER
        // = zMenu
        // .register("id", () -> IMenuTypeExtension.create(GUI::new));

}