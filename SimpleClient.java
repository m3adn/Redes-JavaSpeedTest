/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testenet;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
/**
 *
 * @author danny
 */
public class SimpleClient {
    public static void main(String[] args) {
        try { 
        long total = 0;
        long start = System.currentTimeMillis();

        Socket socket = new Socket("127.0.0.1", 6666);
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            //Criam-se novos objetos para que o fluxo de dados seja processado melhor... 
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            
            System.out.println("Introduza algo para que o teste possa começar. Não se esqueça do ENTER ;) ");
            System.out.println();
            
            if (true) {
                line = keyboard.readLine(); // Ficamos a espera para que o cliente introduza uma frase
                System.out.println("Enviando para o servidor ----------------->");
                out.writeUTF(line); // Enviamos a frase anterior para o servidor
                out.flush(); // Acabamos com o fluxo de dados.
                line = in.readUTF(); }
       
        byte[] bytes = new byte[6*1024]; // 32K
        for(int i=1;;i++) {
            int read = sin.read(bytes);
            if (read < 0) break;
            total += read;
            if (i % 500000 == 0) {
                long cost = System.currentTimeMillis() - start;
                System.out.printf("Lido %,d bytes, velocidade: %,d MB/s%n", total, total/cost/1000);
            }
        }
        }
        catch (Exception x) {
            x.printStackTrace();
        }
    }

    SimpleClient(String one) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    SimpleClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}