package sk.stuba.fei.uim.VSAcvicenie1;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VSAcvicenie1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VSA_CV1", "vsa", "vsa");

        Statement statement = con.createStatement();

        Osoba p=new Osoba();
        p.setName("Mario");
        p.setSalary(1000.0);
        persist(p);
        System.out.println(" " +p);

//
//        /**       VYTVORENIE DATABAZY          */
//        /*statement.executeUpdate("CREATE TABLE Kniha" +       //vytvorenie databazy
//                "(Id INTEGER not NULL," +
//                "Nazov VARCHAR(255)," +
//                "Autor VARCHAR(255)," +
//                "ISBN INTEGER," +
//                "Cena INTEGER," +
//                "PRIMARY KEY (Id))");
//        statement.close();
//
//        statement= con.createStatement();                       //pridanie id,mena do databazy
//        statement.executeUpdate("INSERT INTO Kniha " +
//                "VALUES (100, 'MARIO')" );
//        statement.close(); */
//
//
//        ResultSet result = statement.executeQuery("SELECT * FROM Kniha");
//
//        List<Mena> list = new ArrayList<>();                    //vytvorenie listu<Mena>
//        while (result.next()) {
//            Mena m = new Mena();                                //vytvorenie objektu a vlozenie dat z databazy do objektu
//            m.setId(result.getInt(1));
//            m.setName(result.getString(2));
//            list.add(m);
//            //System.out.println(result.getString("name"));
//        }
//
////        for (Mena i : list) {                                       //vypisanie
////            System.out.println(i.id + " " + i.name);
////
////        }
//
//        EntityManagerFactory emf= Persistence.createEntityManagerFactory("vsaPU");
//        EntityManager em= emf.createEntityManager();
//
//        //vytvorenieNovehoZaznamuMeno(em, "Silvester");
//        vytvorenieNovehoZaznamuKniha(em,"Harry Potter 3", "JK Rowling", 12, 87653621);
//        citanieUdajov(em);
//
//        con.close();
    }

    /**    CITANIE UDAJOV      **/

    static void citanieUdajov(EntityManager em){
        Query q=em.createNativeQuery("select * from mena", Mena.class);
        List<Mena> menas=q.getResultList();

        for (Mena m: menas)
            System.out.println("" + m);
    }

    /**    MODIFIKACIA DAT      **/
    static void modifikaciaDat(EntityManager em){
        Query q = em.createNativeQuery("select * from mena", Mena.class);
        List<Mena> menas= q.getResultList();
        em.getTransaction().begin();
        for( Mena m: menas){
            m.setName("Cyril");
        }
        em.getTransaction().commit();
    }

    /**     VYHLADANIE PODLA KLUCA */
    static void vyhladaniePodlaKluca(EntityManager em){
        Kniha k= em.find(Kniha.class, "103");
        System.out.println(" " + k);
    }

    /**    VYTVORENIE NOVEHO ZAZNAMU */
    static void vytvorenieNovehoZaznamuMeno(EntityManager em, String meno){
        Mena m= new Mena();
        m.setName(meno);
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();

    }

    static void vytvorenieNovehoZaznamuKniha(EntityManager em, String nazov,String autor,int cena,int isbn){
        Kniha k= new Kniha();
        k.setNazov(nazov);
        k.setAutor(autor);
        k.setCena(cena);
        k.setISBN(isbn);
        em.getTransaction().begin();
        em.persist(k);
        em.getTransaction().commit();

    }

    public static void persist(Object object){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("vsaPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }




}
