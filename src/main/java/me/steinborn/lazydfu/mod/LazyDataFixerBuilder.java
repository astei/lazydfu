package me.steinborn.lazydfu.mod;

import com.mojang.datafixers.*;

import java.util.Set;
import java.util.concurrent.Executor;

/**
 * This version of {@code DataFixerBuilder} does not immediately initialize rules.
 */
public class LazyDataFixerBuilder extends DataFixerBuilder {

    private static final Executor NO_OP_EXECUTOR = command -> {};

    public LazyDataFixerBuilder(int dataVersion) {
        super(dataVersion);
    }

    @Override
    public DataFixer buildOptimized(final Set<DSL.TypeReference> requiredTypes, final Executor executor) {
        return super.buildOptimized(requiredTypes, NO_OP_EXECUTOR);
    }
}
