package sk.stuba.fei.uim.VSAcvicenie1;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Mena implements Serializable {
    @Id
    private Integer id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mena{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
