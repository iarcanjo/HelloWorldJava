package sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket cliente = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente se conectou ao servidor!");

		Scanner scan = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());

		while (scan.hasNextLine()) {
			saida.println(scan.nextLine());
		}
		saida.close();
		scan.close();
		cliente.close();
	}
}
