package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import es.upm.dit.isst.electolab.dao.PartidoDAOImplementation;
import es.upm.dit.isst.electolab.model.Partido;
import es.upm.dit.isst.electolab.model.Simulacion;

/**
 * Servlet implementation class FormSimulationServlet
 */
@WebServlet("/FormSimulationSimpleServlet")
public class FormSimulationSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormSimulationSimpleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("simulacion");
		request.getSession().setAttribute("verSimulacion", false);
		/*
		 * Parsea el JSON que proviene de la vista.
		 * Crea el objeto simulación y le asigna el tipo simulación.
		 * Crea un ArrayList auxiliar donde irá metiendo los partidos
		 * que luego asignara al atributo votoPartido de simulación.
		 */

    	JSONParser parser = new JSONParser();
    	Object object; Partido partido;
    	Simulacion simulacion = new Simulacion();
		simulacion.setTipoSimulacion("simple");
		ArrayList<Partido> votoPartido = new ArrayList<Partido>();
		String voto = "abstencion";
		
		
		try {
    		object = parser.parse(request.getParameter("partidos"));
    		
    		JSONArray jsonArray = (JSONArray) object;		// convert Object to JSONObject
    		JSONObject partidoJSON;
    		int seats = 0;
    		int ausentes = 0;
    		/* 
    		 * Recorre el array parseado de partidos, asigna los atributos correspondientes 
    		 * a los objetos de partidos, va sumando votos en el objeto simulación
    		 */
    		
    		for (int i = 0; i < (jsonArray).size(); i++) {
    			partidoJSON = (JSONObject) jsonArray.get(i);
    			System.out.println("LOG , FormSimulationSimpleServlet, doGet(), partidoJSON: " + partidoJSON);
    			voto = (String)partidoJSON.get("vote");
    			seats = Integer.parseInt((String)partidoJSON.get("seats")) ;
    			ausentes = Integer.parseInt((String)partidoJSON.get("ausentes")) ;
    			// Añade el partido con el voto asignado al atributo de simulación
				partido = new Partido();
    			partido.setVote( voto );
    			partido.setAusentes(Integer.parseInt((String)partidoJSON.get("ausentes")) ) ;
    			partido.setSeats(Integer.parseInt((String)partidoJSON.get("seats")));
    			partido.setCodeName((String)partidoJSON.get("codeName"));
    			partido.setFullName((String)partidoJSON.get("fullName"));

    			
				votoPartido.add(partido);
    		
				// Acumula los votos en el tipo de voto correspondiente
				if (voto.equals("favor")) {
					simulacion.setVotos_favor((int) (simulacion.getVotos_favor() + seats - ausentes));
				}
				else if (voto.equals("contra")) {
					simulacion.setVotos_contra(simulacion.getVotos_contra() + seats - ausentes);
				}
				else { 
					simulacion.setVotos_abstencion(simulacion.getVotos_abstencion() + seats - ausentes);
				}
				simulacion.setVotos_ausente(simulacion.getVotos_ausente() + ausentes);

				// Reinicia la variable voto 
				voto = "abstencion";
				
				
				
    		}
    	} catch (org.json.simple.parser.ParseException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

		
		simulacion.setVotoPartido(votoPartido);
		
		// Mete en la sesion el objeto simulacion y devuelve la vista a results.jsp
		
		System.out.println("FormSimulationSimpleServlet ,doGet, Simulación: " + simulacion);
		request.getSession().setAttribute("simulacion", simulacion);
		getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);

	}

}


