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

/**
 * Servlet implementation class getWidgetsA
 */
@WebServlet("/getWidgetsA")
public class getWidgetsA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getWidgetsA() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Widget> widgets = new ArrayList<Widget>();

		for(int ctr=0; ctr<100; ctr++) {
			widgets.add(this.restCallGetWidgetA());
		}
		
		request.setAttribute("widgets", widgets);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private Widget restCallGetWidgetA() {
		RestTemplate restTemplate = new RestTemplate();
		Widget widgetA = restTemplate.getForObject("http://localhost:8081/demo/microservice/getWidgetA", Widget.class);
		
		return widgetA;
	}

}
