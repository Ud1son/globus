package ru.udisondev.globus.producer.config;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import ru.udisondev.globus.common.config.Cache;

@Data
@ConfigurationProperties(prefix = "app.producer")
@RequiredArgsConstructor(onConstructor_ = @ConstructorBinding)
public class ProducerProperties {

    public static final String CACHE_NAME = "producerCache";
    public static final String CACHE_MANAGER_NAME = "producerCacheManager";
    @NotNull
    private final Cache cache;
}
