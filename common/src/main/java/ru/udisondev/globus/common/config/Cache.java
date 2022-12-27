package ru.udisondev.globus.common.config;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Data
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
public class Cache {

    @NotNull
    @Positive
    private final Integer expireAfterAccessSec;

    @NotNull
    @Positive
    private final Integer expireAfterWriteSec;

    @NotNull
    @Positive
    private final Integer initCapacity;

    @NotNull
    @Positive
    private final Integer maxSize;
}
