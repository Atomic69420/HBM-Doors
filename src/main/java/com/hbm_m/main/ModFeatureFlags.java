package com.hbm_m.main;

/**
 * HBM-Modern-Doors build: disable radiation spread, player rad accumulation, hazard rules,
 * energy network ticking, and related event hooks while keeping the same registrations so
 * the project still compiles and door code paths match full HBM-Modernized.
 * <p>
 * Door blockstates and item models are produced by {@code ./gradlew runData} into
 * {@code src/generated/resources} (included on the classpath via {@code build.gradle}).
 * When {@code true}, datagen does not emit crafting recipes; the datapack ships without
 * HBM ore placement (biome modifiers) and without structure sets.
 * <p>
 * Set to {@code false} to behave like the full mod again.
 */
public final class ModFeatureFlags {

    private ModFeatureFlags() {}

    public static final boolean DOORS_ONLY = true;
}
