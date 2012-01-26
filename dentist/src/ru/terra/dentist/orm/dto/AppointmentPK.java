package ru.terra.dentist.orm.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author terranz
 */
@Embeddable
public class AppointmentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "app_id", nullable = false)
    private int appId;
    @Basic(optional = false)
    @Column(name = "pat_id", nullable = false)
    private int patId;
    @Basic(optional = false)
    @Column(name = "diag_id", nullable = false)
    private int diagId;
    @Basic(optional = false)
    @Column(name = "comment_id", nullable = false)
    private int commentId;

    public AppointmentPK()
    {
    }

    public AppointmentPK(int appId, int patId, int diagId, int commentId)
    {
        this.appId = appId;
        this.patId = patId;
        this.diagId = diagId;
        this.commentId = commentId;
    }

    public int getAppId()
    {
        return appId;
    }

    public void setAppId(int appId)
    {
        this.appId = appId;
    }

    public int getPatId()
    {
        return patId;
    }

    public void setPatId(int patId)
    {
        this.patId = patId;
    }

    public int getDiagId()
    {
        return diagId;
    }

    public void setDiagId(int diagId)
    {
        this.diagId = diagId;
    }

    public int getCommentId()
    {
        return commentId;
    }

    public void setCommentId(int commentId)
    {
        this.commentId = commentId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) appId;
        hash += (int) patId;
        hash += (int) diagId;
        hash += (int) commentId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppointmentPK))
        {
            return false;
        }
        AppointmentPK other = (AppointmentPK) object;
        if (this.appId != other.appId)
        {
            return false;
        }
        if (this.patId != other.patId)
        {
            return false;
        }
        if (this.diagId != other.diagId)
        {
            return false;
        }
        if (this.commentId != other.commentId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "ru.terra.dentist.orm.dto.AppointmentPK[appId=" + appId + ", patId=" + patId + ", diagId=" + diagId + ", commentId=" + commentId + "]";
    }

}
