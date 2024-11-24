package nov10classes;

//Classe que representa um utilizador no sistema
public class Utilizador {
    //Atributos privados para garantir o encapsulamento
    private String nome;
    private int pontos;
    private boolean vip;
    
    //Método para adicionar pontos ao utilizador, garantindo que a lógica de pontos esteja encapsulada
    public void adicionarPontos(int pontos) {
            this.pontos += pontos;
    }
    
    //Métodos Getter e Setters para aceder e modificar os atributos de forma segura
    public String getNome() {
            return nome;
    }
    
    public void setNome(String nome) {
            this.nome = nome;
    }
    
    public int getPontos() {
            return pontos;
    }
    
    public void setPontos(int pontos) {
            this.pontos = pontos;
    }
    
    public boolean isVip() {
            return vip;
    }
    
    public void setVip(boolean vip) {
            this.vip = vip;
    }
}
