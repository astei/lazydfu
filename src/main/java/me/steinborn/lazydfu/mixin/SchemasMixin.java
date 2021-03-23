package me.steinborn.lazydfu.mixin;

import com.mojang.datafixers.DataFixerBuilder;
import me.steinborn.lazydfu.mod.LazyDataFixerBuilder;
import net.minecraft.util.datafix.DataFixesManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DataFixesManager.class)
public class SchemasMixin {
//    private static long startTime;
//
//    @Inject(method = "create", at = @At("HEAD"))
//    private static void create$recordStart(CallbackInfoReturnable<DataFixer> ci) {
//        startTime = System.nanoTime();
//    }

    @Redirect(method = "createFixerUpper", at = @At(value = "NEW", target = "com/mojang/datafixers/DataFixerBuilder"))
    private static DataFixerBuilder create$replaceBuilder(int dataVersion) {
        return new LazyDataFixerBuilder(dataVersion);
    }

//    @Inject(method = "create", at = @At("RETURN"))
//    private static void create$doEnd(CallbackInfoReturnable<DataFixer> ci) {
//        new Thread(() -> {
//            if (((ForkJoinPool)Util.getBootstrapExecutor()).awaitQuiescence(Integer.MAX_VALUE, TimeUnit.MILLISECONDS)) {
//                System.out.println("Initialization complete in " + ((System.nanoTime() - startTime) / 1_000_000) + "ms");
//            } else {
//                System.out.println("Initialization still didn't complete in " + ((System.nanoTime() - startTime) / 1_000_000) + "ms");
//            }
//        }).start();
//    }
}
