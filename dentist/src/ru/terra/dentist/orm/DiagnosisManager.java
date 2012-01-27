package ru.terra.dentist.orm;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import ru.terra.dentist.orm.entity.Diagnosis;
import ru.terra.dentist.orm.entity.PersistanceManager;

/**
 *
 * @author terranz
 */
public class DiagnosisManager extends PersistanceManager
{
    @Override
    public Object findById(Integer id)
    {
	Criteria c = session.createCriteria(Diagnosis.class);
	c.add(Restrictions.eq("diagId", id));
	return c.uniqueResult();
    }

    public Diagnosis findByCode(String code)
    {
	Criteria c = session.createCriteria(Diagnosis.class);
	c.add(Restrictions.eq("diagCode", code));
	return (Diagnosis) c.uniqueResult();
    }
}
