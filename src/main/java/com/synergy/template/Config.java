package com.synergy.template;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

public class Config {

        private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

        public static void register(ModContainer c) {
                // misc();
                c.registerConfig(ModConfig.Type.SERVER, BUILDER.build());
        }

        // public static BooleanValue BOOL;
        // public static IntValue INT;

        // private static void misc() {
        //         BUILDER.comment("section");

        //         BOOL = bool("c", "k");
        //         INT = number("c", "k", 0);

        //         BUILDER.pop();
        // }

        private static BooleanValue bool(String c, String k, boolean b) {
                return BUILDER
                                .comment(c)
                                .define(k, b);
        }

        /**
         * default = false
         */
        @SuppressWarnings("unused")
        private static BooleanValue bool(String c, String k) {
                return bool(c, k, false);
        }

        private static IntValue number(String c, String k, int d, int mn, int mx) {
                return BUILDER
                                .comment(c)
                                .defineInRange(k, d, mn, mx);
        }

        private static DoubleValue numberFloat(String c, String k, double d, double min, double max) {
                return BUILDER
                                .comment(c)
                                .defineInRange(k, d, min, max);
        }

        /**
         * min = 0<br/>
         * <br/>
         * max = Double.MAX_VALUE
         */
        @SuppressWarnings("unused")
        private static DoubleValue numberFloat(String c, String k, double d) {
                return numberFloat(c, k, d, 0, Integer.MAX_VALUE);
        }

        /**
         * max = Double.MAX_VALUE
         */
        @SuppressWarnings("unused")
        private static DoubleValue numberFloat(String c, String k, double d, double min) {
                return numberFloat(c, k, d, min, Integer.MAX_VALUE);
        }

        /**
         * min = 1<br/>
         * <br/>
         * max = Integer.MAX_VALUE
         */
        @SuppressWarnings("unused")
        private static IntValue number(String c, String k, int d) {
                return number(c, k, d, 1, Integer.MAX_VALUE);
        }

        /**
         * max = Integer.MAX_VALUE
         */
        @SuppressWarnings("unused")
        private static IntValue number(String c, String k, int d, int min) {
                return number(c, k, d, min, Integer.MAX_VALUE);
        }

}