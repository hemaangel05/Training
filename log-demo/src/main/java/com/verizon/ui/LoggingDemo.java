package com.verizon.ui;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PropertyConfigurator.configure("src/main/resources/log4j.properties");

		Logger rootLog = Logger.getRootLogger();
		rootLog.info("Preparing For a Date");
		rootLog.debug("Carrying Credit Cards: YES");
		rootLog.warn("Are You Forgetting Something? DAO");
		rootLog.error("Not Dressed Impressively");
		rootLog.fatal("Lost his/her number");

		Logger drivingLog = Logger.getLogger("Driving");
		drivingLog.info("Preparing For a ride");
		drivingLog.debug("Got The Keys? YES");
		drivingLog.warn("Are You Forgetting Soemthing? Helmat");
		drivingLog.error("Head Light Functioning Failed");
		drivingLog.fatal("Tank Empty");

		System.out.println("Demo Complete");

	}

}
