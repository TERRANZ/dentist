package ru.terra.dentist.orm.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import ru.terra.dentist.orm.entity.Patient;

/**
 *
 * @author terranz
 */
@XmlRootElement(name = "Patient")
public class PatientListDTO
{

    public List<Patient> list;

    public PatientListDTO(List<Patient> list)
    {
        this.list = list;
    }

    public PatientListDTO()
    {
        this.list = new ArrayList<Patient>();
    }
}
