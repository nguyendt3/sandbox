package com.sevatec.tics.business;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sevatec.tics.domain.Widget;
import com.sevatec.tics.repo.WidgetRepo;

@Component
public class WidgetBusinessImpl implements WidgetBusiness {
	@Autowired
	WidgetRepo widgetRepo;
	
	public Widget getWidgetA() {
		UUID uuid = UUID.randomUUID();
		
		Widget widgetA = new Widget("A", uuid.toString());
		Widget savedWidgetA = widgetRepo.save(widgetA);
		
		return savedWidgetA;
	}
	
	public Widget getWidgetB() {
		UUID uuid = UUID.randomUUID();
		
		Widget widgetA = new Widget("B", uuid.toString());
		Widget savedWidgetA = widgetRepo.save(widgetA);
		
		return savedWidgetA;
	}
}
