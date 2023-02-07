package Alpha;

import org.apache.logging.log4j.*;

public class DemoLog4j {

	
	private static Logger log=LogManager.getLogger(DemoLog4j.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.debug("i am debuggging");
		
	
			log.info("object is present");
		log.error("object is not present");
		log.fatal("this is fatal");
	}

}
