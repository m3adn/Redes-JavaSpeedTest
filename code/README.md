Aqui vais encontrar o codigo descrito no inicio do projeto.
______________________________________________________________________________________
## O que é um socket?

Hoje em dia o uso de mensageiros (como Skype , Messenger , Whatsapp) é uma questão indinspensável. Existem uma grande variedade de protocolos e clientes , mas não todos sabem a forma como eles funcionam. Imaginemos que você faz login numa destas plataformas e a seguir clica em conectar/entrar. Qual será uma das formas a realizar isso? Utilizando **sockets**.

Socket preve a comunicação entre duas pontas (fonte e destino), entre dois processos que estejam na mesma máquina (Unix Socket) ou na rede (TCP/IP Socket). No geral existem dois tipos de sockets: TCP e UDP. O Socket vai funcionar como uma interface entre a camada de Aplicação e a de Transporte, possibilitando que haja uma abstração dos detalhes da pilha TCP/IP, e consequentemente, dando a sensação que os processos envolvidos na sensação estão a comunicar diretamente entre si, no entanto, ela está passando pela rede. Essa abstração gerada pelos Sockets é o que chamamos de comunicação lógica. Outra forma de entender os Sockets é que eles são a "interface" de comunicação interprocessos.

_________________________________________________________________________________________
## SIMPLE CLIENT 
Isto é o objeto socket criado do lado do cliente. Aqui especifica-se o endereço IP a ligar juntamente com a porta associada:
```
Socket socket = new Socket(ipAddress, serverPort);
```
Aqui vamos conter o fluxo de entrada e saide de dados. O fluxo de entrada vai nos permitir ler o socket , e o de saída escrever no mesmo:
```
InputStream sin = socket.getInputStream();
OutputStream sout = socket.getOutputStream();
```
O codigo a seguir convertem estes dois de fluxos noutro tipo para que possamos usar os objetos String com mais facilidade: 
```
DataInputStream in = new DataInputStream(sin);
DataOutputStream out = new DataOutputStream(sout);
 ```
 
__________________________________________________________________________________________
## SIMPLE SERVER
Comecemos com:
```
ServerSocket ss = new ServerSocket(port);
Socket socket = ss.accept();
```
A classe ServerSocket difere um pouco do Socket. A classe o Socket , representa em si o socket. A grande diferença entre as duas é que o "Server Socket" é obrigado a aguardar a conexão dos clientes. Quando é criada é preciso indicar uma porta de ligação através da qual será realizada a transferencia de dados, e também é necessário invocar o método accept(). Este método obriga o servidor a aguardar a ligação através da porta indicada anteriormente. O programa fica a espera até que o cliente realize a ligação. Após ligação ser efetuada com successo é criado um objeto Socket habitual que é usado de seguida em todas as operações que necessitam de sockets. De remarcar que este Socket representa o outro lado da ligação. 

