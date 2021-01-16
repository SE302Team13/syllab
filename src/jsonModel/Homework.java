package jsonModel;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Homework implements Serializable {

	@SerializedName("no")
	@Expose
	private String no;
	@SerializedName("per")
	@Expose
	private String per;
	private final static long serialVersionUID = 4385238264819380328L;

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
