package ru.terra.dentist.dto;

import ru.terraobjects.entity.annotations.PropGetter;
import ru.terraobjects.entity.annotations.PropSetter;
import ru.terraobjects.entity.annotations.TemplateId;

/**
 *
 * @author terranz
 */
@TemplateId(id = Constants.PATIENT_TEMPLATE_ID)
public class Patient
{

    private Integer patId;
    private Integer patNum;
    private String patSName;
    private String patName;
    private String patMName;

    @PropGetter(id = Constants.ID_PROP_ID, autoincrement = "true")
    public Integer getPatId()
    {
        return patId;
    }

    @PropSetter(id = Constants.ID_PROP_ID)
    public void setPatId(Integer patId)
    {
        this.patId = patId;
    }

    @PropGetter(id = Constants.PAT_MIDNAME_PROP_ID)
    public String getPatMName()
    {
        return patMName;
    }

    @PropSetter(id = Constants.PAT_MIDNAME_PROP_ID)
    public void setPatMName(String patMName)
    {
        this.patMName = patMName;
    }

    @PropGetter(id = Constants.PAT_NAME_PROP_ID)
    public String getPatName()
    {
        return patName;
    }

    @PropSetter(id = Constants.PAT_NAME_PROP_ID)
    public void setPatName(String patName)
    {
        this.patName = patName;
    }

    @PropGetter(id = Constants.PAT_NUM_PROP_ID)
    public Integer getPatNum()
    {
        return patNum;
    }

    @PropSetter(id = Constants.PAT_NUM_PROP_ID)
    public void setPatNum(Integer patNum)
    {
        this.patNum = patNum;
    }

    @PropGetter(id = Constants.PAT_SURNAME_PROP_ID)
    public String getPatSName()
    {
        return patSName;
    }

    @PropSetter(id = Constants.PAT_SURNAME_PROP_ID)
    public void setPatSName(String patSName)
    {
        this.patSName = patSName;
    }
}
