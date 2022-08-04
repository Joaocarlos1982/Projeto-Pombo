/* Decompiler 11ms, total 187ms, lines 141 */
package entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pombo {
	static List<Usuario> usuarios = new ArrayList();
	static List<Pruu> listaPruu = new ArrayList();

	public static void main(String[] args) {
		menuDeentrada();
	}

	public static void menuDeentrada() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("                        menu principal                            ");
		System.out.println("------------------------------------------------------------------");
		System.out.println("1- Cadastrar novo usuario ");
		System.out.println("2- Listar todos os usuarios ");
		System.out.println("3- listar usuario por id");
		System.out.println("4- enviar mensagem ");
		System.out.println("5- listar mensagem ");
		System.out.println("6- listar mensagem por id / ADD like");
		System.out.println("7- listar mensagem por cpf");
		System.out.println("8- Bloquear mensagem");
		System.out.println("0- Sair");
		System.out.println("digite a opcao desejada:");
		Scanner ler = new Scanner(System.in);
		int menu = ler.nextInt();
		switch (menu) {
		
		case 1:
			cadastrarUsuario();
			break;
		case 2:
			listarTodosUsuarios();
			break;
		case 3:
			listarUsuarioPorcpf();
			break;
		case 4:
			enviarMensagens();
			break;
		case 5:
			ListarMensagem();
			break;
		case 6:
			listarMensagemPorId();
			break;
		case 7:
			listarMensagemPorCpf();
			break;

		case 8:
			bloquearMensagem();
			break;
		case 0:
			System.out.println("fim do programa");
			break;

		}
	}

	public static void cadastrarUsuario() {
		Scanner scan = new Scanner(System.in);
		System.out.println("*******************************************");
		System.out.println("Cadastro de usuario.");
		System.out.println("*******************************************");
		System.out.println("Usuario e administrador? Sim digite 1 / nao digite 0");
		int adm = scan.nextInt();
		System.out.println("entre com o nome de usuario:");
		String nome = scan.next();
		System.out.println("entre com o cpf:");
		String cpf = scan.next();
		System.out.println("entre com o email:");
		String email = scan.next();
		Usuario usuario = null;
		if (adm == 1) {
			usuario = new Administrador(adm, nome, cpf, email);
		} else {
			usuario = new Usuario(gerarId(), nome, cpf, email);
		}
		usuarios.add(usuario);

		System.out.println("Cadastro realizado com sucesso.");
		System.out.println("*******************************************");

		menuDeentrada();
	}

	public static void listarTodosUsuarios() {
		for (Usuario usuario : usuarios) {
			System.out.println("nome: " + usuario.getNome());
			System.out.println("cpf: " + usuario.getCpf());
			System.out.println("email: " + usuario.getEmail());
		}
		menuDeentrada();

	}

	public static void listarUsuarioPorcpf() {
		Scanner scan = new Scanner(System.in);

		System.out.println("entre com cpf do usuario ");
		String cpf = scan.next();
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf().equalsIgnoreCase(cpf)) {
				System.out.println("nome: " + usuario.getNome());
				System.out.println("email: " + usuario.getEmail());
			}
		}
		menuDeentrada();

	}

	public static int gerarId() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}

	public static void enviarMensagens() {
		Scanner scan = new Scanner(System.in);
		System.out.println("*******************************************");
		System.out.println("Enviar mensagem.");
		System.out.println("*******************************************");
		System.out.println("Entre com cpf usuario remetente: ");
		Usuario usuario = getUsuarioLista(scan.nextLine());
		System.out.println("Digite uma mensagem ");
		Pruu pruu = new Pruu();
		String msg = scan.nextLine();

		while (msg != null && msg.trim().length() < 1 && msg.trim().length() > 300) {

			System.out.println("Valor minimo da mensagem 1 caracter e maximo 300 caracteres.");
			msg = scan.nextLine();

		}
		pruu.setId(gerarId());
		pruu.setEnviarMensagem(msg);
		pruu.setUsuario(usuario);
		pruu.setData(new Date());
		listaPruu.add(pruu);
		System.out.println("Enviar enviada com sucesso.");
		System.out.println("*******************************************");

		menuDeentrada();
	}

	public static void listarMensagemPorId() {
		Scanner scan = new Scanner(System.in);
		System.out.println("entre com id da mensagem ");
		int idMensagem = scan.nextInt();
		for (Pruu pruu : listaPruu) {
			if (pruu.getId() == idMensagem) {
				System.out.println("Id: " + pruu.getId());
				System.out.println("Mensagem: " + pruu.getEnviarMensagem());
				System.out.println("Nome Usuario: " + pruu.getUsuario().getNome());
				System.out.println("Bloqueado: " + pruu.isBloquear());
				System.out.println("Adicione like, Sim digite 1 / Nao digite 0");
				int resultado = scan.nextInt();
				if (resultado == 1) {
					setLike(pruu);
				}
			}
			
		}
		menuDeentrada();
	}
	
	public static void setLike(Pruu pruu) {
		int like = pruu.getLike();
		pruu.setLike(++like);
	}

	public static Pruu getMensagemPorId(int idMensagem) {
		for (Pruu pruu : listaPruu) {
			if (pruu.getId() == idMensagem) {
				return pruu;
			}
		}
		return null;
	}

	public static void bloquearMensagem() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Entre com cpf do administrador");
		String cpf = scan.next();
		Usuario adm = getUsuarioLista(cpf);

		if (adm instanceof Administrador) {
			ListarMensagem();
			System.out.println("Entre com identificador da mensagem.");
			int idMensagem = scan.nextInt();
			Pruu pruu = getMensagemPorId(idMensagem);

			
			while (pruu == null) {
				System.out.println("Mensagem n�o localizada.");
				System.out.println("Entre com identificador da mensagem.");
				idMensagem = scan.nextInt();
				pruu = getMensagemPorId(idMensagem);
			}
			
			pruu.setBloquear(true);
			System.out.println("Mensagem com id " + pruu .getId() + " bloqueada com sucesso.");
		} else {
			System.out.println("Usuario administrador nao localizado.");
			bloquearMensagem();
		}
		
		menuDeentrada();
	}
	public static void listarMensagemPorCpf() {
		Scanner scan = new Scanner(System.in);
		System.out.println("entre com CPF do usuário.");
		String cpf = scan.next();
		for (Pruu pruu : listaPruu) {
			if (pruu.getUsuario().getCpf().equals(cpf)) {
				System.out.println("Id: " + pruu.getId());
				System.out.println("Mensagem: " + pruu.getEnviarMensagem());
				System.out.println("Nome Usuário: " + pruu.getUsuario().getNome());
				System.out.println("Bloqueado: " + pruu.isBloquear());
			}
		}
		menuDeentrada();
	}

	public static void ListarMensagem() {
		for (Pruu pruu : listaPruu) {
			System.out.println("Id: " + pruu.getId());
			System.out.println("mensagem: " + pruu.getEnviarMensagem());
			System.out.println("Qtde Like : " + pruu.getLike());
			System.out.println("usuario da mensagem : " + pruu.getUsuario().getNome());
			System.out.println("Bloqueado: " + pruu.isBloquear());
		}
		menuDeentrada();
	}

	public static Usuario getUsuarioLista(String cpf) {
		Usuario usuario1 = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf().equalsIgnoreCase(cpf)) {
				usuario1 = usuario;
			}
		}
		return usuario1;
	}

}
