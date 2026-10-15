package com.synergy.template.init;

import java.util.function.Function;

import com.synergy.template.init.types.*;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

public class Material {
        public static void register(IEventBus bus) {
                zItems.register(bus);
                zBlocks.register(bus);
                zBlockEntities.register(bus);
                zRecipeTypes.register(bus);
        }

        public static DeferredHolder<Block, Block> registerItemBlock(String blockname,
                        Function<BlockBehaviour.Properties, ? extends Block> sup) {
                DeferredHolder<Block, Block> block = zBlocks.zBlockItem.registerBlock(blockname, sup);
                zItems.zBlockItem.registerSimpleBlockItem(block);
                return block;
        }

}
