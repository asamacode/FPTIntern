package com.asama.fptcandidate.utils;

import org.apache.log4j.Logger;

public class LogFactory {

	public static Logger getInfoLogger() {

		Logger logger = Logger.getLogger("info");
		return logger;
	}
	
	public static Logger getErrorLogger() {

		Logger logger = Logger.getLogger("error");
		return logger;
	}

}
