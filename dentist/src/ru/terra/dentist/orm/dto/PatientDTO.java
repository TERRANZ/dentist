package ru.terra.dentist.orm.dto;

import ru.terra.dentist.orm.entity.Patient;

/**
 *
 * @author terranz
 */
public class PatientDTO
{
    private Integer id;
    private Integer num;
    private String name, surname, midname;

    public PatientDTO(Patient p)
    {
        this.id = p.getPatId();
        this.midname = p.getPatMidname();
        this.name = p.getPatName();
        this.surname = p.getPatSurname();
        this.num = p.getPatNum();
    }

    public PatientDTO()
    {
        this.id = 0;
        this.name = "";
        this.midname = "";
        this.num = 0;
        this.surname = "";
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getMidname()
    {
        return midname;
    }

    public void setMidname(String midname)
    {
        this.midname = midname;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getNum()
    {
        return num;
    }

    public void setNum(Integer num)
    {
        this.num = num;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }
}
