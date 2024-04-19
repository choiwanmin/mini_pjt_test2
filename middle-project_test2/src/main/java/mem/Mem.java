package mem;

//vo
public class Mem {
	private String id;
	private String pwd;
	private int type;

	public Mem() {
	}

	public Mem(String id, String pwd, int type) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Mem [id=" + id + ", pwd=" + pwd + ", type=" + type + "]";
	}

}
