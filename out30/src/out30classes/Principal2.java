package out30classes;

public class Principal2 {
  int x = 10;
  final double PI = 3.14;
  
  public static void main(String[] args) {
	  Principal2 meuObj = new Principal2();
	  meuObj.x = 50;
	  //meuObj.PT = 25; // Vai dar erro, e final
	  System.out.println(meuObj.x);
	  System.out.println(meuObj.PI);
  }
}
// exprimente remover final