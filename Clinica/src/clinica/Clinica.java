package clinica;

public class Clinica {
	int price;
	boolean statusPayment;
	String date; 
	String pacient;
	String doctor;
	int office;
	
	public Clinica(int price, boolean statusPayment, String date, String pacient, String doctor, int office) {
		this.price = price;
		this.statusPayment = statusPayment;
		this.date = date;
		this.pacient = pacient;
		this.doctor = doctor;
		this.office = office;
	}
	
	
	void checkAppointment() {
		System.out.println("O dia da consulta é " + date + " no consultorio " + office + ".");
	}
	
	void checkPrice() {
		System.out.println("O preço da consulta é de " + price + "€.");
	}
	
	void checkPayment() {
		if (statusPayment) {
			System.out.println("O preço da consulta é de " + price + "€ prendentes.");
		} else {
			System.out.println("O preço da consulta é de " + price + "€ pagos");
		}
	}
}
