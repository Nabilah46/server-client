import java.util.Scanner;

import java.io.*;

import java.net.*;

import java.net.Socket.*;


class TCPClient {

 public static void main(String argv[]) throws IOException {

  String sentence;

  String modifiedSentence;
 
  Scanner n = new Scanner(System.in);

  System.out.print("You want to ping or send message? [1-Message,2-Ping] \n");

    int input = n.nextInt();
 
 if(input == 1)
{
    
    String ipAddress = "169.254.79.26"; 

    InetAddress geek = InetAddress.getByName(ipAddress); 

    System.out.println("Sending Ping Request to " + ipAddress); 

    if (geek.isReachable(5000)) 

      System.out.println("Host is reachable!"); 

    else

      System.out.println("Sorry!!!! Can't reach to host"); 

}



else
{

while(true)
{
BufferedReader inFromUser = new BufferedReader(new 
InputStreamReader(System.in));

  
  Socket clientSocket = new Socket("169.254.60.171", 22000);

DataOutputStream outToServer = new 
DataOutputStream(clientSocket.getOutputStream());

  BufferedReader inFromServer = new BufferedReader(new 
InputStreamReader(clientSocket.getInputStream()));


     sentence = inFromUser.readLine();
   
     outToServer.writeBytes(sentence);


  modifiedSentence = inFromServer.readLine();

  System.out.println("From Server: " + modifiedSentence);


  clientSocket.close();
}
}
}
}
