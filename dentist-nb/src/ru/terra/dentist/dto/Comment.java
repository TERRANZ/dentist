package ru.terra.dentist.dto;

import java.util.Date;
import ru.terraobjects.entity.annotations.PropGetter;
import ru.terraobjects.entity.annotations.PropSetter;
import ru.terraobjects.entity.annotations.TemplateId;

/**
 *
 * @author terranz
 */
@TemplateId(id = Constants.COMMENT_TEMPLATE_ID)
public class Comment
{

    private Integer id;
    private Date date;
    private String title;
    private String text;

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

    @PropGetter(id = Constants.COM_DATE_PROP_ID)
    public Date getDate()
    {
	return date;
    }

    @PropSetter(id = Constants.COM_DATE_PROP_ID)
    public void setDate(Date date)
    {
	this.date = date;
    }

    @PropGetter(id = Constants.COM_TEXT_PROP_ID)
    public String getText()
    {
	return text;
    }

    @PropSetter(id = Constants.COM_TEXT_PROP_ID)
    public void setText(String text)
    {
	this.text = text;
    }

    @PropGetter(id = Constants.COM_TITLE_PROP_ID)
    public String getTitle()
    {
	return title;
    }

    @PropSetter(id = Constants.COM_TITLE_PROP_ID)
    public void setTitle(String title)
    {
	this.title = title;
    }
}
