package com.synergy.template;

import com.devdyna.cakesticklib.api.FluidRenderUtils;
import com.devdyna.cakesticklib.api.utils.ClazzUtil;
import com.devdyna.cakesticklib.api.utils.x;
import com.synergy.template.api.FluidRegister;
import com.synergy.template.init.types.zFluids;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.fluid.FluidTintSource;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

@Mod(value = Main.MODULE_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Main.MODULE_ID, value = Dist.CLIENT)
public class Client {

    public Client(ModContainer ctx) {
        ctx.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        // if (ModAddonUtil.checkMod("guideme"))
        // Guide.builder(x.rl(Main.MODULE_ID, "guide")).build();
    }

    @SubscribeEvent
    public static void render(EntityRenderersEvent.RegisterRenderers event) {

        // event.registerBlockEntityRenderer( B, R::new);

    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        // event.register(GUI, SC::new);

    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        // event.registerSpriteSet( I, PR::new);

    }

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public Identifier getRenderOverlayTexture(Minecraft mc) {
                return x.parse("textures/misc/underwater.png");
            }
        }, ClazzUtil.getAll(zFluids.class, FluidRegister.class)
                .stream()
                .map(FluidRegister::getType)
                .map(DeferredHolder::get)
                .toArray(FluidType[]::new));

    }

    @SubscribeEvent
    public static void onRegisterFluidModels(RegisterFluidModelsEvent event) {

        ClazzUtil.getAll(zFluids.class, FluidRegister.class).forEach(
                f -> event.register(
                        FluidRenderUtils.createWaterModel(new FluidTintSource() {

                            @Override
                            public int color(FluidState state) {
                                return f.getColor();
                            }

                        }),
                        f.getSource(),
                        f.getFlowing()));

    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.BlockTintSources event) {
        // event.register(List.of(BlockTintSources.foliage()), T );
    }

    // Recipe collector client-side

    private static RecipeMap recipeCollector = RecipeMap.EMPTY;

    @SubscribeEvent
    public static void onRecipesSynced(RecipesReceivedEvent event) {
        if (ModList.get().isLoaded("jei"))
            recipeCollector = event.getRecipeMap();
    }

    @SubscribeEvent
    public static void onClientLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        recipeCollector = RecipeMap.EMPTY;
    }

    public static RecipeMap getRecipeCollector() {
        return recipeCollector;
    }

}
