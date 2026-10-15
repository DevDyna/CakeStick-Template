package com.synergy.template.init.types;

import net.neoforged.bus.api.IEventBus;

public class zTags {

        public static void register(IEventBus bus) {
                zTags.Blocks.register(bus);
                zTags.Items.register(bus);
                zTags.Entities.register(bus);
                zTags.Biomes.register(bus);
                zTags.Fluids.register(bus);
        }

        public class Blocks {

                public static void register(IEventBus bus) {
                }

                // public static final TagKey<Block> BLOCK_TAG = RegistryUtils
                // .tagBlock(MODULE_ID, "id");

        }

        public class Items {

                public static void register(IEventBus bus) {
                }

                // public static final TagKey<Item> ITEM_TAG = RegistryUtils
                // .tagItem(MODULE_ID, "id");

        }

        public class Biomes {

                public static void register(IEventBus bus) {
                }

                // public static final TagKey<Biome> BIOME_TAG = RegistryUtils
                // .tagBiome(MODULE_ID, "id");

        }

        public class Entities {

                public static void register(IEventBus bus) {

                }

                // public static final TagKey<EntityType<?>> ENTITY_TAG = RegistryUtils
                // .tagEntity(MODULE_ID, "id");

        }

        public class Fluids {

                public static void register(IEventBus bus) {

                }

                // public static final TagKey<Fluid> FLUID_TAG = RegistryUtils
                // .tagFluid(MODULE_ID, "id");

        }
}