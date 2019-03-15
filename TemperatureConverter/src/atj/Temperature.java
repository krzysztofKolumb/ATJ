package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Temperature
 */
@WebServlet(description = "Przelicznik temperatury", urlPatterns = { "/Temperature" })
public class Temperature extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double value = Double.parseDouble(request.getParameter("value"));
		String scale = request.getParameter("scale");
		double result = format(calculate(value,scale));
		String resultScale;
		if(scale.equals("F")) {
			resultScale="C";
		}else {
			resultScale="F";
		}
		request.setAttribute("value", value);
		request.setAttribute("scale", scale);
		request.setAttribute("result", result);
		request.setAttribute("resultScale", resultScale);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
	}
	
	private double calculate(double value, String scale) {
		if(scale.equals("F")) {
			return (double)5/9*(value-32);

		}else if(scale.equals("C")) {
			return 32+(double)9/5*value;
		}else {
			return 404;
		}
	}
	
	public double format(double d) {
		d*=100;
		d = Math.round(d);
		d/=100;
		return d;
	}

}
