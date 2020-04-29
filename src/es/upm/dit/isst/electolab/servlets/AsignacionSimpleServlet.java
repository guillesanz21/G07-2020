package es.upm.dit.isst.electolab.servlets;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.json.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.datatype.DatatypeDocumentFactory;

import es.upm.dit.isst.electolab.dao.PartidoDAOImplementation;
import es.upm.dit.isst.electolab.model.Diputado;
import es.upm.dit.isst.electolab.model.Partido;
import es.upm.dit.isst.electolab.model.Simulacion;

/**
 * Servlet implementation class FormAsignaVotoSimpleServlet
 */
@WebServlet("/AsignacionSimpleServlet")
public class AsignacionSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignacionSimpleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//System.out.println(request.getParameter("partidos"));

    	JSONParser parser = new JSONParser();
    	Object object;
    	Partido partido;
    	// Coge el parametro partidos de simulacion.js y va contando los votos
    	try {
    		object = parser.parse(request.getParameter("partidos"));
    		JSONArray jsonArray = (JSONArray) object;		// convert Object to JSONObject
    		JSONObject partidoJSON;
    		for (int i = 0; i < (jsonArray).size(); i++) {
    			partidoJSON = (JSONObject) jsonArray.get(i);
    			//System.out.println("FormSimulationServlet, log, partidoJSON: " + partidoJSON);
    			//System.out.println();
    			partido = PartidoDAOImplementation.getInstancia().read((String)partidoJSON.get("nameCode"));
    			partido.setVote((int)(long)partidoJSON.get("vote"));
    			PartidoDAOImplementation.getInstancia().update(partido);
    			/*
								System.out.println("FormSimulationServlet, log, partido: " + partido);
								System.out.println("--------------------------------------------------");
								System.out.println("FormSimulationServlet, log, ArrayJSON: " + jsonArray);
								System.out.println("FormSimulationServlet, log, readAll: " + PartidoDAOImplementation.getInstancia().readAll());
								System.out.println("--------------------------------------------------");
    			 */
    		}
    	} catch (org.json.simple.parser.ParseException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	request.getRequestDispatcher("FormSimulationSimpleServlet").forward(request, response);		

    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Llamo de la base de datos a la lista de partidos
    	Collection<Partido> partidos = new ArrayList<Partido>();
    	partidos = PartidoDAOImplementation.getInstancia().readAll();

    	request.getSession().setAttribute("partidos", partidos);

    	getServletContext().getRequestDispatcher("/AsignacionSimple.jsp").forward(request, response);
    }

}