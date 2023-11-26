package service;

import db.JDBIConnector;
import model.Log;

public class LogService {
	private static LogService instance;

	private LogService() {
	}

	public static LogService getInstance() {
		if (instance == null) {
			instance = new LogService();
		}
		return instance;
	}

	public static boolean insertLog(Log input) {
	
			// query > insert
			String query = "INSERT INTO log(`iduser`,`username`,`ip`,`createAt`)VALUES(?,?,?,?)";
			
			
			 int result = JDBIConnector.get().withHandle(handle -> {
		            int count = handle.createUpdate(query)
		                    .bind(0, input.getIduser())
						.bind(1, input.getUsername())
						.bind(2, input.getIp())
						.bind(3, input.getCreateAt())
					
						 .execute();
	            return count;
	        });
	        if (result == 1) {
	            return true;
	        }
	        return false;
	    }
	
   


}

