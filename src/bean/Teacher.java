package bean;

import java.io.Serializable;

public class Teacher implements Serializable {

    private String id; // 教員ID
    private String password; // パスワード
    private String name; // 氏名
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}