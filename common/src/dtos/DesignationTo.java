package dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesignationTo {

	long id;
	String typStudiow;
	String wydzial;
	String kierunek;
	String kurs;
	long kursId;
	String forma;
	int nrSem;
	int godziny;
	String status;
	int statusEnum;

}
