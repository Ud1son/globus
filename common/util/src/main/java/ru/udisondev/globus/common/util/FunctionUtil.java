package ru.udisondev.globus.common.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

public class FunctionUtil {

    @SafeVarargs
    public static <T> Consumer<T> combine(Consumer<T> first, Consumer<T>... others) {
        return Arrays.stream(others)
                .filter(Objects::nonNull)
                .reduce(first, Consumer::andThen);
    }
}
