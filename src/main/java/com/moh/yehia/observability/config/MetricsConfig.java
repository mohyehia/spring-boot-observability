package com.moh.yehia.observability.config;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.util.List;

@Configuration
public class MetricsConfig {
    @Bean
    public MeterFilter meterFilter() {
        return MeterFilter.commonTags(
                List.of(
                        Tag.of("zone.id", ZoneId.systemDefault().toString())
                )
        );
    }
}
