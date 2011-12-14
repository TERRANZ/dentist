package ru.terra.dentist.dto;

import ru.terraobjects.entity.annotations.PropGetter;
import ru.terraobjects.entity.annotations.PropSetter;
import ru.terraobjects.entity.annotations.TemplateId;

/**
 *
 * @author terranz
 */
@TemplateId(id = Constants.DIAGNOSIS_TEMPLATE_ID)
public class Diagnosis
{

    private Integer patId;
    private String name;
    private Integer price;
    private String code;

    @PropGetter(id = Constants.ID_PROP_ID)
    public Integer getPatId()
    {
	return patId;
    }

    @PropSetter(id = Constants.ID_PROP_ID)
    public void setPatId(Integer patId)
    {
	this.patId = patId;
    }

    @PropGetter(id = Constants.DIAG_CODE_PROP_ID)
    public String getCode()
    {
	return code;
    }

    @PropSetter(id = Constants.DIAG_CODE_PROP_ID)
    public void setCode(String code)
    {
	this.code = code;
    }

    @PropGetter(id = Constants.DIAG_NAME_PROP_ID)
    public String getName()
    {
	return name;
    }

    @PropSetter(id = Constants.DIAG_NAME_PROP_ID)
    public void setName(String name)
    {
	this.name = name;
    }

    @PropGetter(id = Constants.DIAG_PRICE_PROP_ID)
    public Integer getPrice()
    {
	return price;
    }

    @PropSetter(id = Constants.DIAG_PRICE_PROP_ID)
    public void setPrice(Integer price)
    {
	this.price = price;
    }
}
