import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

    public static int ServerPort = 8100;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ServerPort);
        Socket clientSocket = serverSocket.accept();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connection accept");
        final String name = in.readLine();

        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
    }
}
