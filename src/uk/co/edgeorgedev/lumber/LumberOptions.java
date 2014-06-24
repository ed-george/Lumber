package uk.co.edgeorgedev.lumber;

import uk.co.edgeorgedev.lumber.Lumber.LumberedLog;

public class LumberOptions {

	private String dateFormat;

	
	public LumberOptions(){}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	
	public void createLog(LumberedLog... logs){
		
	}
	
	protected String generateLogs(LumberedLog... logs) {
		return null;
	}
	
	protected String formatLog(LumberedLog log) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
