package com.synergy.template.init.types;

import static com.synergy.template.Main.MODULE_ID;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;

public class zHandlers {
        public static void register(IEventBus bus) {
                zHandler.register(bus);
        }

        public static final DeferredRegister<AttachmentType<?>> zHandler = DeferredRegister
                        .create(Keys.ATTACHMENT_TYPES, MODULE_ID);

        // public static final Supplier<AttachmentType<ItemStacksResourceHandler>> ID =
        // zHandler
        // .register(
        // "id", () -> AttachmentType.serializable(h -> {
        // if (h instanceof ItemStorageBlock be)
        // return new ItemStacksResourceHandler(be.getSlots());

        // return null;
        // }).build());

}