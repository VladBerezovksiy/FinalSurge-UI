package logic.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.GenerateValuesUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailyVitalsModal {

    @Builder.Default
    String date = GenerateValuesUtils.generateShortDateName();
    @Builder.Default
    int steps = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int calories = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int weight = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int bodyFat = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int water = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int muscleMass = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int restingHR = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int variabilityHR = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int sleepHours = 5;
    @Builder.Default
    int totalTimeAwake = 6;
    @Builder.Default
    int bloodPressure = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int bloodPressure1 = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    String notes = "AQA TEST";

}
