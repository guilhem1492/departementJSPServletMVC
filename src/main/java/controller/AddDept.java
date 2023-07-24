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

@WebServlet("/AddDept")
public class AddDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeptNumService deptNumMapper = new NumDeptMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("addNum").trim();
		String name = request.getParameter("addName").trim();
		// System.out.println(num + name);

		if (num.isEmpty() || name.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/results/missing-num-and-name.jsp").forward(request, response);
		} else {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em3 = emf.createEntityManager();
			EntityTransaction txn = em3.getTransaction();

			txn.begin();
			DeptPair deptPair = new DeptPair(num, name);
			em3.persist(deptPair);
			txn.commit();

			TypedQuery<DeptPair> tq = (TypedQuery<DeptPair>) em3.createNamedQuery("dept.fetch", DeptPair.class);
			tq.setParameter("num", num);
			DeptPair m = tq.getSingleResult();

			request.setAttribute("key", m);
			request.getRequestDispatcher("/WEB-INF/results/show-added-departement.jsp").forward(request, response);

			em3.close();
			emf.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
