package persistance;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.DeptPair;
import service.NumDeptMapper;

public class TestClientPersist {
	public static void main(String[] args) {

		// String[][] deptNumList = new NumDeptMapper().getDeptArray();
		Map<String, String> deptMap = new NumDeptMapper().getDeptMap();

		// System.out.println(deptMap);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();

//			for (String[] s :deptNumList ) {
//				d.setDeptNum(s[0]);
//				d.setDeptName(s[1]);
//				em.persist(d);
//			}

			for (Map.Entry e : deptMap.entrySet()) {
				DeptPair d = new DeptPair();
				d.setDeptNum((String) e.getKey());
				d.setDeptName((String) e.getValue());
				em.persist(d);
			}

//			DeptPair d = new DeptPair();
//			d.setDeptNum("999");
//			d.setDeptName("Néant");
//			em.persist(d);

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
