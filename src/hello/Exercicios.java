package hello;

public class Exercicios {

	public static void main(String[] args) {
		exercicio8();

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
		for(int i = 1;i <= 1000;i++){
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
		for(int i = 0;i < 100;i++){
			if(i % 3 == 0) System.out.println(i);
		}
	}
	
	private static void exercicio4() {
		int fatorial = 10;
		long resultado = 1;
		for(int n = 1;n <= fatorial;n++) {
			resultado *= n;
		}
		System.out.println(resultado);
	}
	
	private static void exercicio6() {
		long fibonacci = 40;
		long nmu = 0;
		long nmd = 1;
		for(long i = 2;i < fibonacci;i++) {
			nmd += nmu;
			nmu = nmd - nmu;
		}
		if(fibonacci == 0 || fibonacci == 1) {
			System.out.println(nmu);
		}else {
			System.out.println(nmd);
		}
	}
	
	private static void exercicio6b() {
		long n = 40;
		long res = fibonacci(n);
		System.out.println(res);
	}
	
	private static long fibonacci(long n) {
		if(n == 0 || n == 1)
			return 0;
		if(n == 2)
			return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	private static void exercicio7() {
		int x = 13;
		while(x > 1) {
			if(x % 2 == 0) {
				x = x / 2;
			} else {
				x = 3 * x + 1;
			}
			System.out.print(x == 1 ? x : x + " > ");
		}
	}
	
	private static void exercicio8() {
		int n = 4;
		for(int i = 1; i <= n;i++) {
			for(int j = 1; j <= i;j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
	}
}
