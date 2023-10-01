package classes;

import java.util.Scanner;

public class Uteis {
	private static Scanner t = new Scanner(System.in);
	
	public static void mostrarLinha() {
		System.out.println("----------------------------------------------------");
	}
	public static int leInt(String msg) {
		int num = 0;
		while(true){
			System.out.print(msg);
			try{
				num = Integer.parseInt(t.nextLine());
				if(num>=0)
					break;
				else
					System.out.println("Não existem códigos negativos");
			}catch(NumberFormatException e){
				System.out.println("Erro, digite um número inteiro válido: ");
			}
	}
	return num;
	}
	
	public static String leString(String msg) {
		System.out.print(msg);
		String info = t.nextLine();
		return info;
	}
	
	public static Double leDouble(String msg) {
		double num = 0;
		while(true){
			System.out.print(msg);
			try{
				num = Double.parseDouble(t.nextLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("Erro, Digite um numero: ");
			}
	}
		return num;
}
}