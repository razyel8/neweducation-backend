import com.neweducation.data.config.PersistenceConfig;
import com.neweducation.data.persistence.entities.general.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.neweducation.data.persistence.entities.general.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)

public class CreateUsers {

    @Test
    public void createUsers(){
        Student student = new Student();
        ProwadzacyZajecia prowadzacy = new ProwadzacyZajecia();
        PelnomocnikDziekanaDsKierunku pelnomocnikDziekanaDsKierunku = new PelnomocnikDziekanaDsKierunku();


        student.setId(1);
        student.setImie("Adam");
        student.setNazwisko("Malysz");
        student.setUprawnienie(Uprawnienie.STUDENT);

        DaneLogowania daneStud = new DaneLogowania();


    }

}
