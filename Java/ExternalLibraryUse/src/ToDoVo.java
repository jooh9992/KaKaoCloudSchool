import java.util.Objects;

public class ToDoVo {
	private Integer userid;
	private Integer id;
	private String title;
	private Boolean completed;
	public ToDoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	@Override
	public int hashCode() {
		return Objects.hash(completed, id, title, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoVo other = (ToDoVo) obj;
		return Objects.equals(completed, other.completed) && Objects.equals(id, other.id)
				&& Objects.equals(title, other.title) && Objects.equals(userid, other.userid);
	}
	public ToDoVo(Integer userid, Integer id, String title, Boolean completed) {
		super();
		this.userid = userid;
		this.id = id;
		this.title = title;
		this.completed = completed;
	}
}
