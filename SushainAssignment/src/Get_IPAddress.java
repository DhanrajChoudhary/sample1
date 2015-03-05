import java.io.*;
import java.net.*;

public class Get_IPAddress
{ 
    public static void main(String[] args) throws IOException
    { 
        String website_name="www.india.gov.in";
        Socket test = new Socket();
        PrintWriter client_sock ;
        BufferedReader server_resp ;
        test.connect(new InetSocketAddress(website_name , 80));
        System.out.println("Connected");
        OutputStream output=test.getOutputStream();
        client_sock = new PrintWriter(output, true);
        InputStream inputStream=test.getInputStream();
        server_resp = new BufferedReader(new InputStreamReader(inputStream));
        InetAddress Ip_Add= InetAddress.getByName(website_name);
        
        System.out.println("The IP Address of the Indian Govt. Portal is:" + Ip_Add.getHostAddress());
        
        String message = "GET / HTTP/1.1\r\n";
        
        client_sock.println( message );
        
        System.out.println("Message send");
        
        while ((server_resp.readLine()) != null)
        { 
            System.out.println(server_resp.readLine()); 
        }
    } 
 }