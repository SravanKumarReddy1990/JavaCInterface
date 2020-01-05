package contacts;
import java.io.Serializable;
import java.io.InputStream;
import java.io.ObjectInputStream;
public class Contact implements Serializable {

    private String name, mobile, email;
	private ObjectInputStream is;
    public Contact(String name, String mobile, String email,ObjectInputStream is) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.is=is;
    }
    public Contact() {
    }

    public ObjectInputStream getInputStream() {
        return is;
    }
    public void setInputStream(ObjectInputStream is) {
        this.is = is;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}     
