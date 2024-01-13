package me.steinborn.lazydfu.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SharedConstants.class, priority = Integer.MAX_VALUE)
public class SharedConstantsMixin {
    /**
     * @author Andrew Steinborn
     * @reason Disables any possibility of enabling DFU "optimizations"
     */
    @Inject(method = "enableDataFixerOptimizations", at = @At("HEAD"), cancellable = true)
    private static void disableDataFixerOptimizations(CallbackInfo ci) {
        ci.cancel();
    }
}
