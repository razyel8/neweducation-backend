package dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Maciej Wolański
 * maciekwski@gmail.com
 * on 08.02.2017.
 */
@Getter@Setter
public class SurveyTo {
    long id;
    String nazwa;
    String dataUtw;
    String dataRozp;
    String dataZak;
    String statusSondazu;
    int statusSondazuEnum;//: number #0- Aktywny, 1-Nieaktywny, 2-Zakonczony, 3-Zagłosowano
    long semestrId;
}
