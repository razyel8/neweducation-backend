package dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseTo {

	private long idKurs;

	private TypStudiow typStudiow;

	private String kurs;

	private String forma;

	private String nrSem;

	private int zapotrzebowanie;

	private int przydzielono;

}
