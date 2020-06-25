package internetspeed_redes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
        public static void main(String[] args) {
            String ipadd = "127.0.0.1";
            int port = 6666;
            long total = 0;
            try { 
                Socket socket = new Socket(ipadd, port);

                // Fluxo de saida e de entrado do socket. Agora jÃ¡ podemos receber e enviar dados :) ....
                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                //Criam-se novos objetos para que o fluxo de dados seja processado melhor... 
                DataInputStream in = new DataInputStream(sin);
                DataOutputStream out = new DataOutputStream(sout);

                //Criamos um fluxo para que possamos receber dados do teclado
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));


                System.out.println("Introduza algo para que o teste possa comeÃ§ar. NÃ£o se esqueÃ§a do ENTER ;)\n");

                String line = keyboard.readLine();// Ficamos a espera para que o cliente introduza uma frase

                if (line.equals("GETSPEED")) {
                    System.out.println("Enviando para o servidor....");
                    out.writeUTF(line);
                    out.flush(); // Enviamos a frase anterior para o servidor
                    line = in.readUTF();
                    long start = System.currentTimeMillis();

                    byte[] bytes = new byte[6*1024]; // 6K
                    for(int i=1;true ;i++) {
                        if(socket.isConnected()){
                            int read = sin.read(bytes);
                            if (read < 0) break;
                            total += read;
                            if (i % 250000 == 0) {
                                long cost = System.currentTimeMillis() - start;
                                System.out.printf("velocidade: %,d B/s%n", total/cost);
                            }
                        }
                    }
                }else {
                    System.out.println("400 Comando não encontrado");
                    out.writeUTF(line);
                    out.flush();
                }
                socket.close();
                System.out.println("Teste finalizado!!");
            }
            catch (IOException x) {
                x.printStackTrace();
            }
    }
}
