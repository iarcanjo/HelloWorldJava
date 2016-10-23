package comunicador;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Comunicador {

	public static void main(String[] args) throws IOException {
		// inicia o menu do comunicador
		start();

		// recebe a opção desejada
		Scanner scan = new Scanner(System.in);
		int opcao;
		do {
			opcao = scan.nextInt();
			if (opcao < 1 || opcao > 2) {
				System.out.println("## Opção errada, tente novamente ###");
			}
		} while (opcao > 2);
		if (opcao == 1) {
			conectar();
		} else {
			aguardar();
		}
		scan.close();
	}

	private static void start() {
		String menu = "####### Comunicador Simples #######\n";
		menu += "##### Digite a opção desejada #####\n";
		menu += "### 1-Conectar ##### 2-Aguardar ###\n";
		System.out.println(menu);
	}

	private static void conectar() throws UnknownHostException, IOException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("## Digite o IP do Host a se conectar ##");
		String ip = teclado.nextLine();
		Socket cliente = new Socket(ip, 12345);
		System.out.println("## Conectando a " + ip + " ##");
		recebeMsg(cliente.getInputStream());
		enviaMsg(cliente.getOutputStream(), teclado);
		cliente.close();
	}

	private static void aguardar() throws IOException {
		Scanner teclado = new Scanner(System.in);
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("## Porta 12345 aberta ##");
		Socket cliente = servidor.accept();
		recebeMsg(cliente.getInputStream());
		enviaMsg(cliente.getOutputStream(), teclado);
		cliente.close();
		servidor.close();
	}

	private static void recebeMsg(InputStream inputStream) {
		// classe anonima e lambda para instanciar thread que receberá as msgs
		new Thread(() -> {
			// recebe msgs do servidor e imprime na tela
			Scanner s = null;
			s = new Scanner(inputStream);
			while (s.hasNextLine()) {
				System.out.println("# " + s.nextLine() + " #");
			}
			s.close();
		}).start();
		// fim da classe anonima
	}

	private static void enviaMsg(OutputStream outputStream, Scanner teclado) {
		// lê msgs do teclado e manda para o host
		PrintStream saida = new PrintStream(outputStream);
		while (teclado.hasNextLine()) {
			saida.println(teclado.nextLine());
		}
		saida.close();
		teclado.close();
	}
}