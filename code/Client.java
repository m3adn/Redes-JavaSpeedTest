package internetspeed_redes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
        public static void main(String[] args) {
            long total = 0;
            try { 
                Socket socket = new Socket("127.0.0.1", 6666);

                // Fluxo de saida e de entrado do socket. Agora já podemos receber e enviar dados :) ....
                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                //Criam-se novos objetos para que o fluxo de dados seja processado melhor... 
                DataOutputStream out = new DataOutputStream(sout);

                //Criamos um fluxo para que possamos receber dados do teclado
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Introduza o comando. Não se esqueça do ENTER ;)");

                String line = keyboard.readLine();// Ficamos a espera que o cliente introduza uma frase

                if (line.equals("GETSPEED")) {
                    System.out.println("200 OK\n");
                    System.out.println("Enviando para o servidor....");
                    out.writeUTF(line);
                    out.flush(); // Enviamos a frase anterior para o servidor
                    long start = System.currentTimeMillis();

                    byte[] bytes = new byte[10*1024]; //10K
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
                    System.out.println("Teste finalizado!!");
                }else {
                    System.out.println("404 Comando não encontrado");
                    out.writeUTF(line);
                    out.flush();
                }
                socket.close();
            }
            catch (IOException x) {
                x.printStackTrace();
            }
    }
}
