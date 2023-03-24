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
public class RoutesModel {

    @Builder.Default
    String name = GenerateValuesUtils.makeTitle("Route ");
    @Builder.Default
    int distance = GenerateValuesUtils.generateRandomNumberFrom1To99();
    @Builder.Default
    String routeRecord = GenerateValuesUtils.generateTimeName();
    @Builder.Default
    String dateRecord = GenerateValuesUtils.generateShortDateName();
    @Builder.Default
    String notes = "AQA TEST";

}
