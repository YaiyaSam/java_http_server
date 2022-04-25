import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class httpServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("bleh");
        while(true){
            try(Socket clientSocket = serverSocket.accept()){

                InputStreamReader input = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader((input));
                String line = reader.readLine();
                while(line!=null && !line.isEmpty()){
                    System.out.println(line);
                    line = reader.readLine();
                }

//  ---------------------------method #1 to send the http response------------------------------
                String message = "Success!";
                String httpResponse = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\nConnection: close\r\n\r\n" + message;
                clientSocket.getOutputStream() .write(httpResponse.getBytes("UTF-8"));


//  ---------------------------method #2 to send the http response-------------------------------

//                String response = "Success!!" ;
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
//                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                out.print("HTTP/1.1 200 \r\n");
//                out.print("Content-Type: text/plain\r\n");
//                out.print("Connection: close\r\n");
//                out.print("\r\n");
//                out.print(response);
//                out.close();
//                in.close();

            }
        }
    }
}