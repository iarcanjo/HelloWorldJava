package hello;

public class Exercicios {

	public static void main(String[] args) {
		exercicio5();

	}

	private static void exercicio1(){
		int x = 0;
		for(int i = 150; i <= 300;i++){
			if(x < 9){
				System.out.print(i + " ");
				x++;
			} else {
				System.out.println(i + " ");
				x = 0;
			}
		}
	}
	
	private static void exercicio2a(){
		long x = 0;
		for(int i = 1;i<=1000;i++){
			x += i;
		}
		System.out.println(x);
	}
	
	private static void exercicio2b(){
		// Soma-se o primeiro com o útimo 
		// e multiplica-se por metade dos números a somar
		int min = 1, max = 1000;
		int soma = (min + max) * ((max - min + 1) / 2);
		System.out.println(soma);
	}
	
	private static void exercicio3(){
		for(int i=0;i<100;i++){
			if(i%3==0) System.out.println(i);
		}
	}
	
	private static void exercicio4() {
		int fatorial = 10;
		long resultado = 1;
		for(int n=1;n<=fatorial;n++){
			resultado *= n;
		}
		System.out.println(resultado);
	}
	
	private static void exercicio5() {
		
	}

}
