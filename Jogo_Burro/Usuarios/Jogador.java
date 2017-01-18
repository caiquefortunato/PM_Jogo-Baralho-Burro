package Usuarios;

public class Jogador extends Competidor{
    
    private String nome;
    private int id;

    public Jogador(String nome, int id) {
        this.nome = nome;
        super.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
}
