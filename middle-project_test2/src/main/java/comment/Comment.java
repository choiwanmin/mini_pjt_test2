package comment;

public class Comment {
	private int num;
	private String id;
	private String content;
	private int data_num;
	public Comment() {
		
	}
	public Comment(int num, String id, String content, int data_num) {
		super();
		this.num = num;
		this.id = id;
		this.content = content;
		this.data_num = data_num;
	}
	public Comment(String id, String content, int data_num) {
		super();
		this.id = id;
		this.content = content;
		this.data_num = data_num;
	}
	@Override
	public String toString() {
		return "Comment [num=" + num + ", id=" + id + ", content=" + content + ", data_num=" + data_num + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getData_num() {
		return data_num;
	}
	public void setData_num(int data_num) {
		this.data_num = data_num;
	}
	
}
