package entidade;

public class Administrador extends Usuario {
	
	public Administrador(int id, String nome, String cpf, String email) {
		super(id, nome, cpf, email);
	}
			
	public void bloquearMensagem (Pruu pruu) {
		pruu.setBloquear(true);
	}
			
}
