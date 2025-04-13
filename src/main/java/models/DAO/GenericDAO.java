package models.DAO;

import models.utils.Connexion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.List;

public class GenericDAO<T> {
    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

   public void save(T entity) {
       try (Session session = Connexion.getSession()) {
           session.beginTransaction();
           session.save(entity);
           session.getTransaction().commit();
       } catch (Exception e) {
           e.printStackTrace();
           throw new RuntimeException("Failed to save entity", e);
       }
   }

    public void update(T entity) {
        try (Session session = Connexion.getSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update entity", e);
        }
    }

    public void delete(T entity) {
        try (Session session = Connexion.getSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to delete entity", e);
        }
    }

    public T findById(int id) {
        try (Session session = Connexion.getSession()) {
            return session.get(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to find entity by ID", e);
        }
    }

    public List<T> findAll() {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            query.select(root);
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to find all entities", e);
        }
    }

    public T findByObject(T obj) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entityClass);
            Root<T> root = cq.from(entityClass);
            Predicate predicate = cb.equal(root, obj);
            cq.select(root).where(predicate);
            return session.createQuery(cq).uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors du findByObject : " + e.getMessage(), e);
        }
    }

  public List<T> findByCriteria(String fieldName, Object criteria) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            query.select(root).where(builder.equal(root.get(fieldName), criteria));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to find entities by criteria", e);
        }
  }


    public List<T> findByReferenceEntity(T referencedEntity) {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);

            // Trouver la propriété ManyToOne qui correspond à l'entité référencée
            String matchingField = null;
            for (Field field : entityClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(javax.persistence.ManyToOne.class)
                        && field.getType().isAssignableFrom(referencedEntity.getClass())) {
                    matchingField = field.getName();
                    break;
                }
            }

            if (matchingField == null) {
                throw new IllegalArgumentException("No @ManyToOne field matching the referenced entity type found in " + entityClass.getSimpleName());
            }

            query.select(root).where(builder.equal(root.get(matchingField), referencedEntity));
            return session.createQuery(query).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to find entities by reference entity", e);
        }
    }

    public long count() {
        try (Session session = Connexion.getSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<T> root = cq.from(entityClass);
            cq.select(cb.count(root));
            return session.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Erreur dans count() : " + e.getMessage(), e);
        }
    }


    public void saveOrUpdate(T obj) {
        try (Session session = Connexion.getSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (Exception e) {
            throw new RuntimeException("Erreur dans saveOrUpdate : " + e.getMessage(), e);
        }
    }

}
