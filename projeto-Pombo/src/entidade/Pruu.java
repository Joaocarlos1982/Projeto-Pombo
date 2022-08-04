/* Decompiler 4ms, total 191ms, lines 59 */
package entidade;

import java.util.Date;

public class Pruu {
	private int id;
	boolean bloquear;
	private Usuario usuario;
	private int like;
	private String enviarMensagem;
	private Date data;

	public Pruu() {
	}

	public Pruu(int id, int like, String enviarMensagem) {
		this.id = id;
		this.like = like;
		this.enviarMensagem = enviarMensagem;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLike() {
		return this.like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getEnviarMensagem() {
		return this.enviarMensagem;
	}

	public void setEnviarMensagem(String enviarMensagem) {
		this.enviarMensagem = enviarMensagem;
	}

	public boolean isBloquear() {
		return this.bloquear;
	}

	public void setBloquear(boolean bloquear) {
		this.bloquear = bloquear;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		if (this.bloquear) {
			return "Usuário sem permissão.";
		} else {
			return "Usuario: " + usuario.getNome() + ", Quantidade de like:" + like ;
		}
	}
}
