package ec.edu.ups.controller.billhead;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.BillHeadDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.model.BillHead;
import ec.edu.ups.resources.MathFunction;

/**
 * Servlet implementation class UpdateBillHead
 */
@WebServlet("/UpdateBillHead")
public class UpdateBillHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillHeadDAO billHeadDAO;
	private BillHead billHead;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBillHead() {
        super();
        billHeadDAO = DAOFactory.getFactory().getBillHeadDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			billHead = billHeadDAO.read(Integer.parseInt(request.getParameter("hea_id")));
			MathFunction.setBillHeadTotal(billHead);
			billHeadDAO.update(billHead);
		}catch (Exception e) {
			System.out.println("ERROR:UpdateBillHead");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
