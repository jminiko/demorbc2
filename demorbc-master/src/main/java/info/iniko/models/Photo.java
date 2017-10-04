/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jminiko
 */
@Entity(name = "photo")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long photoId;

    @Column(name = "photo_url")
    String photoUrl;
    
    
    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if("".equals(this.photoUrl))
            return 0;
        return this.photoUrl.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.photoId == null && other.photoId != null) || (this.photoId != null && !this.photoId.equals(other.photoId))) {
            return false;
        }
        if(this.photoUrl==null)
            return false;
        if(other.photoUrl==null)
            return false;
        if(this.photoUrl.equals(other.photoUrl))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "info.iniko.models.Photo[ id=" + photoId + " ]";
    }
    
}
