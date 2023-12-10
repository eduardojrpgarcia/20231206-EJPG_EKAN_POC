package ejpg.ekan.poc.data.domain.util;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Abstract IPersistent implementation for JPA Framework persistence purpose.
 *
 * @author earth
 */
@MappedSuperclass
public abstract class PersistentObject implements IPersistentObject<String> {

    @Id
    @GeneratedValue(generator= "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", columnDefinition = "CHAR(36)")
    private String id;

    /**
     * Getter method
     * @return java.lang.String The identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method
     * @param id The identifier
     */
    public void setId(String id) {
        this.id = id;
    }

}
