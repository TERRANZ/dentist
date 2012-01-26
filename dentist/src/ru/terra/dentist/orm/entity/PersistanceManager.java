package ru.terra.dentist.orm.entity;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.terra.dentist.orm.HibernateUtil;

/**
 *
 * @author terranz
 */
public abstract class PersistanceManager
{

    protected Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Object> load(Class entity)
    {
        Criteria c = session.createCriteria(entity);
        return c.list();
    }

    public void delete(Object o)
    {
        try
        {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        }
        catch (HibernateException he)
        {
            he.printStackTrace();
        }
    }

    public void update(Object o)
    {
        try
        {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        }
        catch (HibernateException he)
        {
            he.printStackTrace();
        }
    }

    public void saveNew(Object o)
    {
        try
        {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        }
        catch (HibernateException he)
        {
            he.printStackTrace();
        }
    }

    public abstract Object findById(Integer id);   
}
