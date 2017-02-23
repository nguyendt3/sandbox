package com.sevatec.tics.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties("microservice")
public class MicroserviceProperties {
	private static String getWidgetAURL;
	private static String getWidgetBURL;
	
	private static String getWidgetAFindPrimesURL;
	private static String getWidgetBFindPrimesURL;
	
	public static String getGetWidgetAURL() {
		return getWidgetAURL;
	}
	public static void setGetWidgetAURL(String getWidgetAURL) {
		MicroserviceProperties.getWidgetAURL = getWidgetAURL;
	}
	public static String getGetWidgetBURL() {
		return getWidgetBURL;
	}
	public static void setGetWidgetBURL(String getWidgetBURL) {
		MicroserviceProperties.getWidgetBURL = getWidgetBURL;
	}

	public static String getGetWidgetAFindPrimesURL() {
		return getWidgetAFindPrimesURL;
	}
	public static void setGetWidgetAFindPrimesURL(String getWidgetAFindPrimesURL) {
		MicroserviceProperties.getWidgetAFindPrimesURL = getWidgetAFindPrimesURL;
	}
	public static String getGetWidgetBFindPrimesURL() {
		return getWidgetBFindPrimesURL;
	}
	public static void setGetWidgetBFindPrimesURL(String getWidgetBFindPrimesURL) {
		MicroserviceProperties.getWidgetBFindPrimesURL = getWidgetBFindPrimesURL;
	}
}
