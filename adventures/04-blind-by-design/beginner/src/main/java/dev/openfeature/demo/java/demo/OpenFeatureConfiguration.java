package dev.openfeature.demo.java.demo;

import dev.openfeature.contrib.providers.flagd.FlagdProvider;
import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.OpenFeatureAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeatureConfiguration {

    @Bean
    public FlagdProvider flagdProvider() {
        FlagdProvider provider = new FlagdProvider();
        OpenFeatureAPI.getInstance().setProvider(provider);
        return provider;
    }

    @Bean
    public Client openFeatureClient(FlagdProvider flagdProvider) {
        return OpenFeatureAPI.getInstance().getClient();
    }
}