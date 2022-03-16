package sk.stuba.fei.uim.VSAcvicenie1;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kniha {
    @Id
    @GeneratedValue
    private Integer id;
    private String nazov;
    private String autor;
    private int ISBN;
    private int cena;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Kniha{" +
                "id=" + id +
                ", nazov='" + nazov + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN=" + ISBN +
                ", cena=" + cena +
                '}';
    }
}
