package clinica;

public class main {
	public static void main(String[] args) {
		Clinica cliente1 = new Clinica(50, true, "19/12/2024", "Gonçalo Sousa", "João Delgado", 1);
		Clinica cliente2 = new Clinica(2000, false, "20/12/2024", "Afonso Marques", "Paulo Neto", 2);
		Clinica cliente3 = new Clinica(175, true, "27/12/2024", "Arthur Manes", "João Delgado", 5);
		
		
		cliente1.checkAppointment();
		cliente2.checkAppointment();
		cliente3.checkAppointment();
		
		cliente1.checkPrice();
		cliente2.checkPrice();
		cliente3.checkPrice();
		
		cliente1.checkPayment();
		cliente2.checkPayment();
		cliente3.checkPayment();
	}
}
