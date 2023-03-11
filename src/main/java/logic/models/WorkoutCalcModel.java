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
public class WorkoutCalcModel {

    @Builder.Default
    int recentHh = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int recentMm = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int recentSs = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int shortTest = GenerateValuesUtils.generateRandomNumber21To50();
    @Builder.Default
    int goalHh = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int goalMm = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int goalSs = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int longTest = GenerateValuesUtils.generateRandomNumber21To50();
    @Builder.Default
    int temperature = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int humidity = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int windSpeed = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int criticalPower = GenerateValuesUtils.generateRandomNumberFrom100To150();
    @Builder.Default
    int reserveWorkCapacity = GenerateValuesUtils.generateRandomNumberFrom1To20();
    @Builder.Default
    int raceAvgPowerW = GenerateValuesUtils.generateRandomNumber21To50();

}
