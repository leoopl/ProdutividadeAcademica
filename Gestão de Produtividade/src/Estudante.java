
public class Estudante {
	private String nome;
	private String email;
	private int type; //1 - graduação; 2 - mestrado; 3 - doutorado
	
	
	public Estudante(String name, String email, int type) {
		this.setNome(name);
		this.setEmail(email);
		this.setType(type);
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	
	
	
}
