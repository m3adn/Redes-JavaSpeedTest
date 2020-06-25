/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testenet;
import java.io.*;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author danny
 */
public class SimpleServer {
    public static void main(String[] args) {
        int port = 6666;
        try { ServerSocket server = new ServerSocket(port);// criamos o socket do servidor e associamos-no com a porta especificada
               System.out.println("Esperemos pelo cliente....");
               Socket socket = server.accept();  
               System.out.println("Encontramos um :) ... Finalmente!");
               System.out.println();
         // Pegamos no fluxo de saida e de entrado do socket. Agora já podemos receber e enviar dados :) ....
         InputStream sin = socket.getInputStream();
         OutputStream sout = socket.getOutputStream();

         ///Criam-se novos objetos para que o fluxo de dados seja processado melhor... 
         DataInputStream in = new DataInputStream(sin);
         DataOutputStream out = new DataOutputStream(sout);
          
         String line = null;
         if (true){
           line = in.readUTF(); // aguardamos uma linha de texto
           System.out.println("O cliente enviou-me isso : " + line);
           System.out.println("Vamos proceder ao teste...");
           out.flush(); // interrompemos o fluxo de dados
         }

        byte[] bytes = new byte[6*1024]; // 6K
        while (true) {
            sout.write(bytes);
        }
    } catch(Exception x) { x.printStackTrace(); }
}
}
