package ru.terra.dentist.orm.entity;
// Generated 26.01.2012 19:42:07 by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AppointmentId generated by hbm2java
 */
@Embeddable
public class AppointmentId implements java.io.Serializable
{
    private Integer appId;
    private Integer patId;
    private Integer diagId;
    private Integer commentId;

    public AppointmentId()
    {
    }

    public AppointmentId(Integer appId, Integer patId, Integer diagId, Integer commentId)
    {
        this.appId = appId;
        this.patId = patId;
        this.diagId = diagId;
        this.commentId = commentId;
    }

    @Column(name = "app_id", nullable = false)
    public Integer getAppId()
    {
        return this.appId;
    }

    public void setAppId(Integer appId)
    {
        this.appId = appId;
    }

    @Column(name = "pat_id", nullable = false)
    public Integer getPatId()
    {
        return this.patId;
    }

    public void setPatId(Integer patId)
    {
        this.patId = patId;
    }

    @Column(name = "diag_id", nullable = false)
    public Integer getDiagId()
    {
        return this.diagId;
    }

    public void setDiagId(Integer diagId)
    {
        this.diagId = diagId;
    }

    @Column(name = "comment_id", nullable = false)
    public Integer getCommentId()
    {
        return this.commentId;
    }

    public void setCommentId(Integer commentId)
    {
        this.commentId = commentId;
    }

    public boolean equals(Object other)
    {
        if ((this == other))
        {
            return true;
        }
        if ((other == null))
        {
            return false;
        }
        if (!(other instanceof AppointmentId))
        {
            return false;
        }
        AppointmentId castOther = (AppointmentId) other;

        return (this.getAppId() == castOther.getAppId())
                && (this.getPatId() == castOther.getPatId())
                && (this.getDiagId() == castOther.getDiagId())
                && (this.getCommentId() == castOther.getCommentId());
    }

    public int hashCode()
    {
        int result = 17;

        result = 37 * result + this.getAppId();
        result = 37 * result + this.getPatId();
        result = 37 * result + this.getDiagId();
        result = 37 * result + this.getCommentId();
        return result;
    }
}
