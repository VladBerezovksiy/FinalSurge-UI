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
public class PreferencesModel {

    @Builder.Default
    String firstName = "Donald";
    @Builder.Default
    String lastName = "Loui";
    @Builder.Default
    String email = "emailaqa" + GenerateValuesUtils.generateShortDateName() + "@domain.com";
    @Builder.Default
    String birthday = "2/14/2000";
    @Builder.Default
    String city = "Kiev";
    @Builder.Default
    int zipCode = GenerateValuesUtils.generateRandomNumber21To50();
    @Builder.Default
    String newPass = "Temp" + GenerateValuesUtils.generateRandomNumberFrom100To150() + "%";
    @Builder.Default
    String question = GenerateValuesUtils.generateDateName();
    @Builder.Default
    int answer = GenerateValuesUtils.generateRandomNumberFrom100To150();

}
