package ru.terra.dentist.orm;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import ru.terra.dentist.orm.entity.Patient;
import ru.terra.dentist.orm.entity.PersistanceManager;

/**
 *
 * @author terranz
 */
public class PatientManager extends PersistanceManager
{

    public PatientManager()
    {
    }

    @Override
    public Object findById(Integer id)
    {
        Criteria c = session.createCriteria(Patient.class);
        c.add(Restrictions.eq("patId", id));
        return c.uniqueResult();
    }

    public List<Patient> findAllPatients()
    {
        Criteria c = session.createCriteria(Patient.class);
        return c.list();
    }
}
