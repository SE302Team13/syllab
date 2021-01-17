package jsonModel;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attendance implements Serializable {

	@SerializedName("no")
	@Expose
	private String no;
	@SerializedName("per")
	@Expose
	private String per;
	private final static long serialVersionUID = -975902995002259887L;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

}
