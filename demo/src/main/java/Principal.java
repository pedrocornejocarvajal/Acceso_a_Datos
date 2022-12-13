import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Principal {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            setUp();
            guardar("Nabil Fekir", 32.21);
            eliminar(25);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    private static void guardar(String nombre, double tipo) {
        PersonasEntity persona = new PersonasEntity(nombre, tipo);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(persona);
        transaction.commit();
        System.out.println(id);
        sessionFactory.close();
    }


    private static void eliminar(int idPersona) {
        PersonasEntity persona = new PersonasEntity(idPersona);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(persona);
        transaction.commit();
        sessionFactory.close();
    }



}
