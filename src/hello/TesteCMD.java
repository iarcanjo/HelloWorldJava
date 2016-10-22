package hello;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TesteCMD {

	public static void main(String[] args) throws IOException {

		String rl, tc;
		boolean aux;
		BufferedReader br;
		BufferedWriter bw;
		StringBuffer sb;

		Runtime run = Runtime.getRuntime();
		Process p = run.exec("cmd");

		bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		br = new BufferedReader(new InputStreamReader(p.getInputStream(), "CP850"));
		Scanner scan = new Scanner(System.in);
		sb = new StringBuffer("");

		do {
			tc = scan.nextLine();
			bw.write(tc);
			bw.newLine();
			do {
				rl = br.readLine();
				aux = rl != null;
				if (aux) {
					sb.append(rl).append("\n");
				}
			} while (aux);
			System.out.println(sb + tc);
		} while (tc.equalsIgnoreCase("exit"));
		scan.close();
	}

	public static void teste1() throws IOException {
		Runtime run = Runtime.getRuntime();
		Process p = run.exec("cmd");

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "CP850"));

		// writeConsole(readCMD(br));

		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			writeCMD(p, scan.nextLine());
			writeConsole(readCMD(br));
		}
		scan.close();
	}

	private static void writeCMD(Process p, String command) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		bw.write(command);
		bw.newLine();
		bw.close();
		;
	}

	private static String readCMD(BufferedReader br) throws IOException {
		StringBuffer sb = new StringBuffer("");
		String rl;
		boolean aux;
		do {
			rl = br.readLine();
			aux = rl != null;
			if (aux) {
				sb.append(rl).append("\n");
			}
		} while (aux);

		return sb.toString();
	}

	private static void writeConsole(String string) {
		System.out.println(string);
	}

	public static void teste2() throws IOException {
		String rl;
		boolean aux;
		BufferedReader br;
		BufferedWriter bw;
		StringBuffer sb;

		Runtime run = Runtime.getRuntime();
		Process p = run.exec("cmd");

		bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		bw.write("cd c:\\");
		bw.newLine();
		bw.write("dir");
		bw.newLine();
		bw.close();

		br = new BufferedReader(new InputStreamReader(p.getInputStream(), "CP850"));
		sb = new StringBuffer("");
		do {
			rl = br.readLine();
			aux = rl != null;
			if (aux) {
				sb.append(rl).append("\n");
			}
		} while (aux);
		System.out.println(sb);

		run = Runtime.getRuntime();
		p = run.exec("cmd");

		bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		bw.write("java -version");
		bw.newLine();
		bw.write("control userpasswords2");
		bw.newLine();
		bw.close();

		br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		sb = new StringBuffer("");
		do {
			rl = br.readLine();
			aux = rl != null;
			if (aux) {
				sb.append(rl).append("\n");
			}
		} while (aux);
		System.out.println(sb.toString());
	}

	public static void readKeyboard() {
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer("");
		while (scan.hasNext()) {
			sb.append(scan.nextLine());
			System.out.println(sb);
			if (sb.toString().equalsIgnoreCase("exit")) {
				break;
			} else {
				sb.delete(0, sb.length());
			}
		}
		scan.close();
	}
}
