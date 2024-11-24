package nov10classes;

//Classe responsável por calcular os bônus atribuídos a um utilizador
public class CalculadoraBonus {
	
    //Atributo que define o bônus diário padrão
    public int bonusDia = 1;
	
    //Método que calcula o multiplicador de bônus com base no estado VIP do utilizador
    public int bonus(Utilizador u) {
    	int multiplicador = bonusDia; //Inicializa o multiplicador com o bônus do dia
    	
    	if (u.isVip()) { //Se o utilizador for VIP, multiplica o bônus por 5
    		multiplicador *= 5;
        }
    	
        return multiplicador; //Retorna o multiplicador final
    }
}