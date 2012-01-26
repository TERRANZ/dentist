package ru.terra.dentist.orm;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import ru.terra.dentist.orm.entity.Patient;
import ru.terra.dentist.orm.entity.PersistanceManager;

/**
 *
 * @author terranz
 */
public class PatientEntity extends PersistanceManager
{

    public PatientEntity()
    {
    }

    @Override
    public Object findById(Integer id)
    {
        Criteria c = session.createCriteria(Patient.class);
        c.add(Restrictions.eq("patId", id));
        return c.uniqueResult();
    }
}
