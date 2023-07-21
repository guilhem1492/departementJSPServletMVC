
package persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.DeptPair;

public class TestClientQuery {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em2 = emf.createEntityManager();

		TypedQuery<DeptPair> tq = (TypedQuery<DeptPair>) em2.createNamedQuery("dept.fetch", DeptPair.class);
		tq.setParameter("num", "01");
		DeptPair m = tq.getSingleResult();

//		TypedQuery<Person> tq = em2.createQuery("from Person", Person.class);
//		List<Person> l = tq.getResultList();
//
//		TypedQuery<Cashier> tq2 = em2.createQuery("from Cashier", Cashier.class);
//		List<Cashier> l2 = tq2.getResultList();

//		TypedQuery<Cashier> tq3 = em2.createQuery("SELECT c FROM Person where type(c) = Cashier", Cashier.class);
//		List<Cashier> l3 = tq3.getResultList();

		em2.close();
		emf.close();

	}
}
