package com.neweducation.data.persistence.entities.survey;

import javax.persistence.*;

import com.neweducation.data.persistence.entities.general.Sondaz;
import com.neweducation.data.persistence.entities.general.Student;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GlosStudentaWSondazu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = true)
	private String wybor;

	@ManyToOne
	private Sondaz sondaz;

	@ManyToOne
	private Student student;
}
