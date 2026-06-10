package dev.openfeature.demo.java.demo;

import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.FlagEvaluationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trial {

    private static final String VISION_STATE_FLAG = "vision_state";
    private static final String FALLBACK_VISION_STATE = "untreated";

    private final Client openFeatureClient;

    public Trial(Client openFeatureClient) {
        this.openFeatureClient = openFeatureClient;
    }

    @GetMapping("/")
    public VisionStateReading observeSubject() {
        FlagEvaluationDetails<String> details =
                openFeatureClient.getStringDetails(VISION_STATE_FLAG, FALLBACK_VISION_STATE);

        return new VisionStateReading(
                details.getFlagKey(),
                details.getVariant(),
                details.getValue(),
                details.getReason().toString()
        );
    }
}