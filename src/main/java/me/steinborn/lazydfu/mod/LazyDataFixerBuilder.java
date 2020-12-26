package me.steinborn.lazydfu.mod;

import com.mojang.datafixers.*;

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
    public DataFixer build(Executor executor) {
        return super.build(NO_OP_EXECUTOR);
    }
}
