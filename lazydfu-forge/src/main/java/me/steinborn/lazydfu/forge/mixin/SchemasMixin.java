package me.steinborn.lazydfu.forge.mixin;

import com.mojang.datafixers.DataFixerBuilder;
import me.steinborn.lazydfu.forge.LazyDataFixerBuilder;
import net.minecraft.util.datafix.DataFixers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DataFixers.class)
public class SchemasMixin {
    @Redirect(method = "createFixerUpper", at = @At(value = "NEW", target = "com/mojang/datafixers/DataFixerBuilder"))
    private static DataFixerBuilder createFixerUpper$replaceBuilder(int dataVersion) {
        System.out.println("LazyDFU bruhhhh");
        return new LazyDataFixerBuilder(dataVersion);
    }
}
