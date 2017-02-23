package com.sevatec.tics.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.client.RestTemplate;

import com.sevatec.tics.domain.Widget;
import com.sevatec.tics.properties.MicroserviceProperties;

/**
 * Servlet implementation class getWidgetsA
 */
@WebServlet("/getWidgetsBFindPrimes")
public class getWidgetsBFindPrimes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getWidgetsBFindPrimes() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		restCallGetWidgetBFindPrimes();
		
		request.setAttribute("findPrimesB", true);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void restCallGetWidgetBFindPrimes() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(MicroserviceProperties.getGetWidgetBFindPrimesURL(), Object.class);
	}

}
