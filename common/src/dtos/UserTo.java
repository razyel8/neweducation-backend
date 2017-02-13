package dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTo {
	long id;
	String authToken;
	int role;
	String imie;
	String nazwisko;
}
