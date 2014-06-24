package uk.co.edgeorgedev.lumber;

import android.util.Log;
import uk.co.edgeorgedev.lumber.Lumber.LumberedLog;

public class LumberFileOptions extends LumberOptions {

	public enum FileMode {APPEND, OVERWRITE};

	private String logFilename;
	private String logFilePath;
	private FileMode mode;
	private boolean colorised;

	public String getLogFilename() {
		return logFilename;
	}

	public void setLogFilename(String logFilename) {
		this.logFilename = logFilename;
	}

	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}

	public FileMode getFileMode() {
		return mode;
	}

	public void setFileMode(FileMode mode) {
		this.mode = mode;
	}

	public boolean isColorised() {
		return colorised;
	}

	public void setColorised(boolean colorised) {
		this.colorised = colorised;
	}

	@Override
	public void createLog(LumberedLog... logs) {
		super.createLog(logs);
		FileUtils util = new FileUtils(this);
		util.writeFile(logs);
	}

	@Override
	protected String generateLogs(LumberedLog... logs) {

		if(logs.length == 0){
			return null;
		}

		StringBuilder sb = new StringBuilder();

		for(LumberedLog log : logs){
			sb.append(colorised ? colorise(log) : formatLog(log));
		}

		return sb.toString();
	}


	private String colorise(LumberedLog log) {

		String color;
		
		switch(log.getLevel()){
		case Log.DEBUG :
			color = FileUtils.ANSI_BLUE;
			break;

		case Log.ERROR :
			color = FileUtils.ANSI_BLUE;
			break;

		case Log.WARN :
			color = FileUtils.ANSI_YELLOW;
			break;
		
		case Log.INFO :
			color = FileUtils.ANSI_CYAN;
			break;
		
		case Log.VERBOSE :
			color = FileUtils.ANSI_GREEN;
			break;

		default:
			return formatLog(log);

		}
		return color + formatLog(log) + FileUtils.ANSI_RESET;
	}

}
