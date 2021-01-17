package jsonModel;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeeklySubject implements Serializable {

	@SerializedName("subject")
	@Expose
	private String subject;
	@SerializedName("reading")
	@Expose
	private String reading;
	private final static long serialVersionUID = -4845986115177181128L;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

}
