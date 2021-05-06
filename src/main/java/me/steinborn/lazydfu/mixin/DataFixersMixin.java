package me.steinborn.lazydfu.mixin;

import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.DataFixerBuilder;
import me.steinborn.lazydfu.mod.LazyDataFixerBuilder;
import net.minecraft.util.datafix.DataFixers;
import net.minecraft.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@Mixin(DataFixers.class)
public class DataFixersMixin {
//    private static long startTime;
//
//    @Inject(method = "createFixerUpper", at = @At("HEAD"))
//    private static void createFixerUpper$recordStart(CallbackInfoReturnable<DataFixer> ci) {
//        startTime = System.nanoTime();
//    }

    @Redirect(method = "createFixerUpper", at = @At(value = "NEW", target = "com/mojang/datafixers/DataFixerBuilder"))
    private static DataFixerBuilder createFixerUpper$replaceBuilder(int dataVersion) {
        return new LazyDataFixerBuilder(dataVersion);
    }

//    @Inject(method = "createFixerUpper", at = @At("RETURN"))
//    private static void createFixerUpper$doEnd(CallbackInfoReturnable<DataFixer> ci) {
//        new Thread(() -> {
//            if (((ForkJoinPool)Util.getBootstrapExecutor()).awaitQuiescence(Integer.MAX_VALUE, TimeUnit.MILLISECONDS)) {
//                System.out.println("Initialization complete in " + ((System.nanoTime() - startTime) / 1_000_000) + "ms");
//            } else {
//                System.out.println("Initialization still didn't complete in " + ((System.nanoTime() - startTime) / 1_000_000) + "ms");
//            }
//        }).start();
//    }
}
