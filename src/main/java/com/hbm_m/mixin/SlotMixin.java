package com.hbm_m.mixin;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import com.hbm_m.util.IMixinSlot;

import net.minecraft.world.inventory.Slot;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

/**
 * Repositions armor slots in the armor table GUI. Uses reflection instead of @Shadow on x/y so
 * the mixin works in production without relying on a field refmap entry (which Mixin AP often
 * omits for {@link Slot}).
 */
@Mixin(Slot.class)
public class SlotMixin implements IMixinSlot {

    @Unique
    private static Field hbm_m$slotX;
    @Unique
    private static Field hbm_m$slotY;
    @Unique
    private static boolean hbm_m$warned;

    @Unique
    private static Field hbm_m$resolveX() {
        if (hbm_m$slotX == null) {
            hbm_m$slotX = hbm_m$resolveSlotField("x", "f_40220_");
        }
        return hbm_m$slotX;
    }

    @Unique
    private static Field hbm_m$resolveY() {
        if (hbm_m$slotY == null) {
            hbm_m$slotY = hbm_m$resolveSlotField("y", "f_40221_");
        }
        return hbm_m$slotY;
    }

    /** Dev: mapped names; production Forge client: SRG names. */
    @Unique
    private static Field hbm_m$resolveSlotField(String mappedName, String srgName) {
        try {
            Field f = Slot.class.getDeclaredField(mappedName);
            hbm_m$makeWritable(f);
            return f;
        } catch (NoSuchFieldException ignored) {
            Field f = ObfuscationReflectionHelper.findField(Slot.class, srgName);
            hbm_m$makeWritable(f);
            return f;
        }
    }

    @Unique
    private static void hbm_m$makeWritable(Field f) {
        f.setAccessible(true);
        try {
            Field mod = Field.class.getDeclaredField("modifiers");
            mod.setAccessible(true);
            mod.setInt(f, f.getModifiers() & ~Modifier.FINAL);
        } catch (ReflectiveOperationException ignored) {
            // Java 12+ may block Field.modifiers; try without stripping FINAL (may still work for some JDKs)
        }
    }

    @Override
    public void setPos(int newX, int newY) {
        Slot self = (Slot) (Object) this;
        try {
            hbm_m$resolveX().setInt(self, newX);
            hbm_m$resolveY().setInt(self, newY);
        } catch (IllegalAccessException e) {
            if (!hbm_m$warned) {
                hbm_m$warned = true;
                com.hbm_m.main.MainRegistry.LOGGER.error("Could not reposition armor table slots (Slot x/y); GUI layout may be wrong.", e);
            }
        }
    }
}
