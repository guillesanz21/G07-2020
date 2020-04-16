package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import es.upm.dit.isst.electolab.dao.SimulacionDAOImplementation;
import es.upm.dit.isst.electolab.dao.UsuarioRegistradoDAOImplementation;
import es.upm.dit.isst.electolab.model.Diputado;
import es.upm.dit.isst.electolab.model.Simulacion;
import es.upm.dit.isst.electolab.model.UsuarioRegistrado;

/**
 * Servlet implementation class FormGuardaSimulacionServlet
 */
@WebServlet("/FormGuardaSimulacionServlet")
public class FormGuardaSimulacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormGuardaSimulacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Diputado diputado = null;
		
		String name = request.getParameter("simName");
		
		UsuarioRegistrado autor = UsuarioRegistradoDAOImplementation.getInstancia().login(email,password); 		
		
		boolean ley_aprobada = true;
		int id = SimulacionDAOImplementation.getInstancia().readAll().size() ;
		
		Simulacion simulacion = (Simulacion) request.getSession().getAttribute("simulacion");		

		
		
		if (simulacion.getVotos_favor() > (simulacion.getVotos_contra()+ simulacion.getVotos_abstencion())) {
			ley_aprobada = true;
		}
		else {
			ley_aprobada = false;
		}

		
		simulacion.setTituloLey(name);
		simulacion.setAutor(autor);
		simulacion.setLey_aprobada(ley_aprobada);
		simulacion.setIdSimulacion(id);
		
		SimulacionDAOImplementation.getInstancia().create(simulacion);
		
		List<Simulacion> sim = new ArrayList<Simulacion>();
		
		sim.addAll((List<Simulacion>) request.getSession().getAttribute("simulaciones"));
		sim.add(simulacion);
		request.getSession().setAttribute("simulaciones", sim);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
