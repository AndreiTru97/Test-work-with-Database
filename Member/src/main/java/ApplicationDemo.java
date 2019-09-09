import dao.MembersDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import dao.DAO;
import model.Members;



/**
 * Author : Anrei Trusov.
 * Created : 04/09/2019.
 */


public class ApplicationDemo {

    public static void main(String[] args) {

        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAO<Members, Integer> dao = new MembersDAO(factory);


            /** Раскомментировать функцию, убедиться в правельности данных */
            //create(dao);
            //read(dao);
            //update(dao);
            //delete(dao);


        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

    private static void create(DAO<Members, Integer> membersDAO) {
        Members members = new Members();
        members.setName("Andrey");
        members.setSurname("Trusov");
        members.setSecondName("Vladimirovich");
        members.setBirthDay("1997-12-27");
        members.setAddress("Street1");

        membersDAO.create(members);
        /** membersDAO.read() в скобках указывать будущий id в БД */
        System.out.println("Created: " + membersDAO.read(1));
    }

    private static void read(DAO<Members, Integer> membersDAO) {
        /** membersDAO.read() в скобках указывать существующий id в БД */
        final Members result = membersDAO.read(8);
        System.out.println("Read: " + result);
    }

    private static void update(DAO<Members, Integer> membersDAO) {
        /** membersDAO.read() в скобках указывать id который хотим обновить в БД */
        final Members result = membersDAO.read(8);
        result.setName("Ivan");
        result.setSurname("Ivanov");
        result.setSecondName("Ivanovich");
        result.setBirthDay("1154-11-10");
        result.setAddress("Street2");
        membersDAO.update(result);
        System.out.println("Updated: " + membersDAO.read(8));
    }

    private static void delete(DAO<Members, Integer> membersDAO) {
        /** members.setId() в скобках указывать id который хотим удалить в БД */
        Members members = new Members();
        members.setId(8);
        membersDAO.delete(members);
    }
}