package com.sevatec.tics.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevatec.tics.business.WidgetBusiness;
import com.sevatec.tics.domain.Widget;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin
public class GetWidgetB extends AbstractGetWidget {
	@Autowired
	WidgetBusiness widgetBusiness;
	
	@RequestMapping(value="/microservice/getWidgetB", method = RequestMethod.GET)
	public Widget getWidgetB() {
		return widgetBusiness.getWidgetB();
	}
	
	@RequestMapping(value="/microservice/getWidgetBFindPrimes", method = RequestMethod.GET)
	public void getWidgetAFindPrimes() {
		this.findPrimes(10000);
	}
}
