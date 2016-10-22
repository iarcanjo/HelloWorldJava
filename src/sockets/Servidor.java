package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		Socket cliente = server.accept();
		System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

		Scanner scan = new Scanner(cliente.getInputStream());
		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}

		scan.close();
		cliente.close();
		server.close();
	}
}
