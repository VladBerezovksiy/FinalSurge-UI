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
public class ShoesModel {

    @Builder.Default
    String name = GenerateValuesUtils.makeTitle("Shoe ");
    @Builder.Default
    String modal = "Zero 112";
    @Builder.Default
    int cost = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int startingDistance = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    int distanceAlert = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    String notes = "AQA TEST";

}
