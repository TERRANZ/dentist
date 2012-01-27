package ru.terra.dentist.orm;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import ru.terra.dentist.orm.entity.Appointment;
import ru.terra.dentist.orm.entity.PersistanceManager;

/**
 *
 * @author terranz
 */
public class AppointmentsManager extends PersistanceManager
{
    @Override
    public Object findById(Integer id)
    {
        Criteria c = session.createCriteria(Appointment.class);
        c.add(Restrictions.eq("id", id));
        return c.uniqueResult();
    }
}
