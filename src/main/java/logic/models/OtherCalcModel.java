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
public class OtherCalcModel {

    @Builder.Default
    int distance = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int hh = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int mm = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int ss = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int weight = GenerateValuesUtils.generateRandomNumber21To50();
    @Builder.Default
    int height = GenerateValuesUtils.generateRandomNumber21To50();
    @Builder.Default
    int age = GenerateValuesUtils.generateRandomNumberFrom1To99();

}
