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
public class WorkoutModel {

    @Builder.Default
    String date = GenerateValuesUtils.generateShortDateName();
    @Builder.Default
    String time = GenerateValuesUtils.generateTimeName();
    @Builder.Default
    String name = GenerateValuesUtils.makeTitle("AQA ");
    @Builder.Default
    String description = "AQA TEST";
    @Builder.Default
    int distance = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int duration = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    String pace = GenerateValuesUtils.generateTimeName();
    @Builder.Default
    int overallPlace = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int agePlace = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    String newLibrary = GenerateValuesUtils.makeTitle("NEW LIBRARY ");
    @Builder.Default
    int code = GenerateValuesUtils.generateRandomNumberFrom1To99();

}
