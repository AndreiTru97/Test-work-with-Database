package dao;

import com.sun.istack.NotNull;
import model.Members;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MembersDAO implements DAO<Members, Integer> {

    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    public MembersDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Create new member in member table.
     *
     * @param members for add.
     */
    @Override
    public void create(@NotNull final Members members) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(members);

            session.getTransaction().commit();
        }
    }

    /**
     * Get member by member.
     *
     * @param id for select.
     * @return id with param model.
     */
    @Override
    public  Members read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {

            final Members result = session.get(Members.class, id);

            return result != null ? result : new Members();
        }
    }


    /**
     * Update member state.
     *
     * @param members new state.
     */
    @Override
    public void update(@NotNull final Members members) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(members);

            session.getTransaction().commit();
        }
    }

    /**
     * Delete member.
     *
     * @param members for delete.
     */
    @Override
    public void delete(@NotNull final Members members) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(members);

            session.getTransaction().commit();
        }
    }
}

