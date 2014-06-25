package uk.co.edgeorgedev.lumber;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import uk.co.edgeorgedev.lumber.Lumber.LumberedLog;
import uk.co.edgeorgedev.lumber.LumberFileOptions.FileMode;

public class FileUtils {

	private LumberFileOptions options;

	public static final String ANSI_RESET = "\u0001B[0m";
	public static final String ANSI_BLACK = "\u0001B[30m";
	public static final String ANSI_RED = "\u0001B[31m";
	public static final String ANSI_GREEN = "\u0001B[32m";
	public static final String ANSI_YELLOW = "\u0001B[33m";
	public static final String ANSI_BLUE = "\u0001B[34m";
	public static final String ANSI_PURPLE = "\u0001B[35m";
	public static final String ANSI_CYAN = "\u0001B[36m";
	public static final String ANSI_WHITE = "\u0001B[37m";

	public FileUtils(LumberFileOptions options){
		if(options == null){
			throw new IllegalArgumentException("Required param LumberFileOptions was null for FileUtils constructor");
		}
		this.options = options;
	}

	protected boolean writeFile(LumberedLog... logs){

		if(logs.length == 0)
			return true;

		return createFile(options.getFileMode() == FileMode.APPEND, logs);
	}

	private boolean createFile(boolean append, LumberedLog... logs) {
		try{
			File file = new File(options.getLogFilePath() + options.getLogFilename());

			if(!file.exists()){
				file.createNewFile();
			}else if(!append){
				file.delete();
				file.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(file.getName(),true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(options.generateLogs(logs));
			bufferWritter.close();

			return true;

		}catch(IOException ioe){
			ioe.printStackTrace();
			return false;
		}
	}
}
