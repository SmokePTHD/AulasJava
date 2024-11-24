package nov10classes;
  
//Classe responsável por registrar ações que resultam na atribuição de pontos a um utlizador
public class RegistoPontos {
	
    //Instância de CalculadoraBonus para calcular os bônus associados às ações
    private CalculadoraBonus bonus;
    //Construtor que recebe uma instância de CalculadoraBonus para inicializar o objeto
    public RegistoPontos(CalculadoraBonus cb) {
    	this.bonus = cb;
    }
    //Método para registrar a ação de fazer um comentário
    //Adiciona pontos ao utilizador com base num multiplicador de bônus
    public void fazerComentario(Utilizador u) {
    int multiplicador = bonus.bonus(u); //Calcula o multiplicador de bônus
        u.adicionarPontos(3 * multiplicador); //Adiciona pontos multiplicados ao utilizador
    }
    //Método para registrar a ação de criar um tópico
    //Adiciona mais pontos devido à importância de criar novos tópicos
    public void criarTopico(Utilizador u) {
    int multiplicador = bonus.bonus(u); //Calcula o multiplicador de bônus
    	u.adicionarPontos(5 * multiplicador); //Adiciona pontos multiplicados ao utilizador
    }
    //Método para registrar ação dar um "like"
    //Adiciona uma pequena quantidade de pontos ao utilizador
    public void darLike(Utilizador u) {
    int multiplicador = bonus.bonus(u); //Calcula o multiplicador de bônus
        u.adicionarPontos(1 * multiplicador); //Adiciona pontos multiplicados ao utilizador
    }
}