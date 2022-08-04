/* Decompiler 3ms, total 173ms, lines 40 */
package entidade;

public class Usuario {
   private int id;
   private String nome;
   private String cpf;
   private String email;

   public Usuario(int id, String nome, String cpf, String email) {
      this.id = id;
      this.nome = nome;
      this.cpf = cpf;
      this.email = email;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCpf() {
      return this.cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
