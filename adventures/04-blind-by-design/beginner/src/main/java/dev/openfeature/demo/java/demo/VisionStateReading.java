package dev.openfeature.demo.java.demo;

public record VisionStateReading(
        String flagKey,
        String variant,
        String value,
        String reason
) {}