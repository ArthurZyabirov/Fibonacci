import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(9999);
        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                ;
                String s;
                while ((s = in.readLine()) != null) {

                    if ("end".equals(s)) break;
                    int x = Integer.parseInt(s);


                    out.println("Число фибоначчи: " + fibonacci(x));

                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }

        }
    }

    private static int fibonacci(int x) {
        int fib;
        int num = 0;
        int num2 = 1;
        for (int loop = 1; loop < x; loop++) {
            fib = num + num2;
            num = num2;
            num2 = fib;
        }
        return num;
    }
}

