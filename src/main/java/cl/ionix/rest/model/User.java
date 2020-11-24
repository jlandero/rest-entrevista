package cl.ionix.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore //este elemento se puede proteger si es data sensible, para el ejemplo lo deje no visible
	private int id;
	
	@NotEmpty(message = "Nombre no debe ser Nulo")
	private String name;
	@NotEmpty(message = "Usuario no debe ser Nulo")
	private String username;	
	@NotEmpty(message = "Email no debe ser Nulo")
    @Email(message = "Email debe ser valido")
	private String email;
    @NotEmpty(message = "Telefono no debe ser Nulo")
	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User(int id, String name, String username, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", name=").append(name).append(", username=").append(username)
				.append(", email=").append(email).append(", phone=").append(phone).append("]");
		return builder.toString();
	}
	
	
	
	
}
