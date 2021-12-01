import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String message;
            while (true) {
                System.out.println("Введите n-число для расчета Фибоначчи или end");
                message = scanner.nextLine();

                System.out.println(message);
                out.println(message);
                if ("end".equals(message)) break;

                System.out.println("Server: " + in.readLine());
            }


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
