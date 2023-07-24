package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

@WebServlet("/ShowDept")
public class ShowDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeptNumService deptNumMapper = new NumDeptMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num").trim();
		// System.out.println(num);

		if (num.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/results/missing-num.jsp").forward(request, response);
		} else if (deptNumMapper.findDept(num) == null) {
			DeptPair deptPair = new DeptPair(num, deptNumMapper.findDept(num));
			request.setAttribute("key", deptPair);
			request.getRequestDispatcher("/WEB-INF/results/unknown-num.jsp").forward(request, response);
		}

		else {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em2 = emf.createEntityManager();

			TypedQuery<DeptPair> tq = (TypedQuery<DeptPair>) em2.createNamedQuery("dept.fetch", DeptPair.class);
			tq.setParameter("num", num);
			DeptPair m = tq.getSingleResult();

			// DeptPair deptPair = new DeptPair(num, deptNumMapper.findDept(num));
			request.setAttribute("key", m);
			request.getRequestDispatcher("/WEB-INF/results/show-departement.jsp").forward(request, response);

			em2.close();
			emf.close();
		}
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}

}
