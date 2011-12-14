package ru.terra.dentist.dto;

import java.util.Date;
import ru.terraobjects.entity.annotations.PropGetter;
import ru.terraobjects.entity.annotations.PropSetter;
import ru.terraobjects.entity.annotations.TemplateId;

/**
 *
 * @author terranz
 */
@TemplateId(id = Constants.APPOINTMENT_TEMPLATE_ID)
public class Appointment
{

    private Integer id;
    private Date date;
    private Integer patId, diagId, comId;

    @PropGetter(id = Constants.ID_PROP_ID)
    public Integer getId()
    {
	return id;
    }

    @PropSetter(id = Constants.ID_PROP_ID)
    public void setId(Integer id)
    {
	this.id = id;
    }

    @PropGetter(id = Constants.COM_ID_PROP_ID)
    public Integer getComId()
    {
	return comId;
    }

    @PropSetter(id = Constants.COM_ID_PROP_ID)
    public void setComId(Integer comId)
    {
	this.comId = comId;
    }

    @PropGetter(id = Constants.APP_DATE_PROP_ID)
    public Date getDate()
    {
	return date;
    }

    @PropSetter(id = Constants.APP_DATE_PROP_ID)
    public void setDate(Date date)
    {
	this.date = date;
    }

    @PropGetter(id = Constants.DIAG_ID_PROP_ID)
    public Integer getDiagId()
    {
	return diagId;
    }

    @PropSetter(id = Constants.DIAG_ID_PROP_ID)
    public void setDiagId(Integer diagId)
    {
	this.diagId = diagId;
    }

    @PropGetter(id = Constants.PAT_ID_PROP_ID)
    public Integer getPatId()
    {
	return patId;
    }

    @PropSetter(id = Constants.PAT_ID_PROP_ID)
    public void setPatId(Integer patId)
    {
	this.patId = patId;
    }
}
