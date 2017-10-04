package info.iniko.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jminiko
 */
@Entity(name = "robot")
public class Robot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long robotId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Column(name = "name")
    @NotEmpty
    String name;

    @OneToOne
    @JoinColumn(name="categoryId")
    Category category;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "robot_tags",  joinColumns = { 
			@JoinColumn(name = "robotId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "tagId", table = "tag",
					nullable = false, updatable = false) })
    private Set<Tag> tags;
        
            
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Photo> photos = new HashSet<Photo>(0);
            
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
            
    public Long getRobotId() {
        return robotId;
    }

    public void setRobotId(Long robotId) {
        this.robotId = robotId;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (robotId != null ? robotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Robot)) {
            return false;
        }
        Robot other = (Robot) object;
        if ((this.robotId == null && other.robotId != null) || (this.robotId != null && !this.robotId.equals(other.robotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.iniko.models.Robots[ id=" + robotId + " ]";
    }
    
}
