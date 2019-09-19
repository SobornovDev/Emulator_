package holders;

public class LogFileHolder {
	//(<datetime>, <filename>, "in"(константа))
	public String datetime;
	public String filename;
	public String inout;
	
	public LogFileHolder(String datetime, String filename, String inout) {
		this.datetime = datetime;
		this.filename = filename;
		this.inout = inout;
	}
	
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public String getDatetime() {
		return datetime;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setInout(String inout) {
		this.inout = inout;
	}
	
	public String getInout() {
		return inout;
	}
		
}
