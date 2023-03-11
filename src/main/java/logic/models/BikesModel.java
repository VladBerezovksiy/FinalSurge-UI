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
public class BikesModel {

    @Builder.Default
    String name = GenerateValuesUtils.makeTitle("Bike ");
    @Builder.Default
    String modal = "Zero 121";
    @Builder.Default
    int cost = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int startingDistance = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    int distanceAlert = GenerateValuesUtils.generateRandomNumberFrom1To9();
    @Builder.Default
    String notes = "AQA TEST";

}
