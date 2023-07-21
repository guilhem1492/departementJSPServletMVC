package persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.DeptPair;

public class TestAddressPersist {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();

			DeptPair d = new DeptPair();
			d.setDeptNum("75");
			d.setDeptName("Paris");
			// Person p = new Person();
//			p.setName("Jessica");
//			p.setAddress(new Address("6 rue des paquerettes", "Paris", 75014));
			em.persist(d);
//			System.out.println(p.toString());

			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}
