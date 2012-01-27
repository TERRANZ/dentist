package ru.terra.dentist.orm.dto;

import java.util.HashSet;
import ru.terra.dentist.orm.entity.Appointment;
import ru.terra.dentist.orm.entity.Diagnosis;

/**
 *
 * @author terranz
 */
public class DiagnosisDTO
{
    private Integer id;
    private String code;
    private String name;
    private Integer price;
    private HashSet<Appointment> appointments;

    public DiagnosisDTO(Diagnosis d)
    {
        this.id = d.getDiagId();
        this.code = d.getDiagCode();
        this.name = d.getDiagName();
        this.price = d.getDiagPrice();
        this.appointments = (HashSet<Appointment>) (d.getAppointments() != null ? d.getAppointments() : new HashSet<Appointment>());
    }

    public HashSet<Appointment> getAppointments()
    {
        return appointments;
    }

    public void setAppointments(HashSet<Appointment> appointments)
    {
        this.appointments = appointments;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }
}
