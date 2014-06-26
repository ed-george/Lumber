package uk.co.edgeorgedev.lumber;

import android.util.Log;


/**
 * Because Logging is AWESOME
 * @author edgeorge
 * @version 1.0
 * @since 2014-06-23
 * 
 */
public class Lumber{

	private LumberOptions options;
	private static Lumberjack lj;
	public Lumber(){}

	public static void v(Class<?> clazz, String message) {
		getLumberjackInstance().v(clazz, message);
	}

	public LumberOptions getLumberOptions() {
		return options;
	}

	public void setLumberOptions(LumberOptions options) {
		this.options = options;
	}

	public static class Lumberjack implements Stump{

		@Override
		public void v(Class<?> clazz, String message) {
			// TODO Auto-generated method stub

			Log.v(clazz.getCanonicalName(), message);

		}

		@Override
		public void v(Class<?> clazz, Throwable th) {
			// TODO Auto-generated method stub

		}

	}
	
	private static Lumberjack getLumberjackInstance() {
		if(lj == null){
			lj = new Lumberjack();
		}
		return lj;
	}


	protected class LumberedLog{
		private int level;
		private String message;

		protected LumberedLog(String message, int level){
			this.level = level;
			this.message = message;
		}

		public int getLevel() {
			return level;
		}

		public String getMessage() {
			return message;
		}

	}

}
