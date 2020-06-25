package internetspeed_redes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        int port = 6666;
        try { ServerSocket server = new ServerSocket(port);// criamos o socket do servidor e associamos-no com a porta especificada
               System.out.println("Esperemos pelo cliente....");
               Socket socket = server.accept();
               System.out.println("Encontramos um :) ... Finalmente!\n");
               
         // Pegamos no fluxo de saida e de entrado do socket. Agora jÃ¡ podemos receber e enviar dados :) ....
         InputStream sin = socket.getInputStream();
         OutputStream sout = socket.getOutputStream();

         ///Criam-se novos objetos para que o fluxo de dados seja processado melhor... 
         DataInputStream in = new DataInputStream(sin);
         DataOutputStream out = new DataOutputStream(sout);
         
         String line = in.readUTF(); // aguardamos para que o cliente nos envie algo
         System.out.println("Comando: " + line);
            
         if (line.equals("GETSPEED")){
            System.out.println("Vamos proceder ao teste...");
            out.flush(); // interrompemos o fluxo de dados
            byte[] bytes = new byte[6*1024]; // 6K
            int i = 0;
            while (i < 5000000) {
                sout.write(bytes);
                i++;
                if(i == 5000000){
                    socket.close();
                }
            }
         }else{
             System.out.println("Comando não dispoível!!\n");
         }
        } catch(IOException x) { 
            x.printStackTrace(); 
        }
    }
}
