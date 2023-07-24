package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeptPair;
import service.DeptNumService;
import service.NumDeptMapper;

@WebServlet("/RemoveDept")
public class RemoveDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeptNumService deptNumMapper = new NumDeptMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("removeNum").trim();

		if (num.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/results/missing-num.jsp").forward(request, response);
		} else {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em4 = emf.createEntityManager();
			EntityTransaction txn = em4.getTransaction();

			try {
				txn.begin();

				TypedQuery<DeptPair> tq = (TypedQuery<DeptPair>) em4.createNamedQuery("dept.fetch", DeptPair.class);
				tq.setParameter("num", num);
				DeptPair d = tq.getSingleResult();
				request.setAttribute("key", d);
				request.getRequestDispatcher("/WEB-INF/results/show-removed-departement.jsp").forward(request,
						response);
				em4.remove(d);

				txn.commit();
			} catch (Exception e) {
				if (txn != null) {
					txn.rollback();
				}
				e.printStackTrace();
			} finally {
				if (em4 != null) {
					em4.close();
				}
				if (emf != null) {
					emf.close();
				}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
