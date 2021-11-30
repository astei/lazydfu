package me.steinborn.lazydfu.mixin;

import com.mojang.datafixers.DataFixerBuilder;
import me.steinborn.lazydfu.LazyDFU;
import me.steinborn.lazydfu.mod.LazyDataFixerBuilder;
import net.minecraft.util.datafix.DataFixers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DataFixers.class)
public class SchemasMixin {
    @Redirect(method = "createFixerUpper", at = @At(value = "NEW", target = "com/mojang/datafixers/DataFixerBuilder"))
    private static DataFixerBuilder create$replaceBuilder(int dataVersion) {
        LazyDFU.LOGGER.info("Lazy DFU");
        return new LazyDataFixerBuilder(dataVersion);
    }
}
