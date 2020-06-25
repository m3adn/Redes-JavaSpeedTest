![Sockets](https://github.com/m3adn/Projeto-Redes-JAVA/blob/master/code/img/socket-transport-application.png)
______________________________________________________________________________________
## O que é um socket?

Hoje em dia o uso de mensageiros (como Skype , Messenger , Whatsapp) é uma questão indinspensável. Existe uma grande variedade de protocolos e clientes que comunicam entre si, mas nós vamos parar nos que se usam em JAVA. Imaginemos que você faz login numa das plataformas mencionadas anteriormente e a seguir clica em conectar/entrar. Qual será uma das formas a realizar isso? Utilizando **sockets**.

O Socket preve a comunicação entre duas pontas (fonte e destino), entre dois processos que estejam na mesma máquina (Unix Socket) ou na rede (TCP/IP Socket). No geral existem dois tipos de sockets: TCP e UDP. O Socket vai funcionar como uma interface entre a camada de Aplicação e a de Transporte, possibilitando que haja uma abstração dos detalhes da pilha TCP/IP, e consequentemente, dando a sensação que os processos envolvidos na sensação estão a comunicar diretamente entre si, no entanto, ela está passando pela rede. Essa abstração gerada pelos Sockets é o que chamamos de comunicação lógica. Outra forma de entender os Sockets é que eles são a "interface" de comunicação interprocessos.

_________________________________________________________________________________________
## SIMPLE CLIENT 
É o objeto ***socket*** criado do lado do cliente. Aqui especifica-se o endereço IP e a porta na qual pretendemos ligar:
```
Socket socket = new Socket(ipAddress, serverPort);
```
Controlamos o fluxo de entrada e saida de dados através de vários métodos. O fluxo de entrada vai nos permitir ler o socket , e o de saída escrever no mesmo:
```
InputStream sin = socket.getInputStream();
OutputStream sout = socket.getOutputStream();
```
Os 2 tipos de fluxos criados anteriormente são convertidos noutro tipo para que se possa usar objetos em String com mais facilidade:
```
DataInputStream in = new DataInputStream(sin);
DataOutputStream out = new DataOutputStream(sout);
 ```
 
__________________________________________________________________________________________
## SIMPLE SERVER

```
ServerSocket ss = new ServerSocket(port);
Socket socket = ss.accept();
```
A classe ServerSocket difere um pouco da classe Socket. A classe  Socket , por mais simples que se possa entender ,representa em si o socket. A grande diferença entre o ServerSocket e o Socket, é que o "Server Socket" é obrigado a aguardar para que algum cliente se ligue ao mesmo. Quando é criada a classe ServerSocket é preciso indicar uma porta de ligação através da qual será realizada a tal negociação de dados. Após isso é necessário invocar o método accept(). Este método obriga o servidor a aguardar a ligação através da porta indicada anteriormente ou seja o servidor tem conhecimento que alguém há de fazer o pedido de ligação através dessa porta e o algoritmo fica a aguardar qualquer pedido de ligação para o seu endereço. Caso a ligação seja efetuada com successo é criado o tal objeto Socket habitual ,que é usado de seguida em todas as operações em que são envolvidos os sockets. De remarcar que este Socket representa o outro lado da ligação e não o lado do Servidor sendo necessário na classe ServerSocket para receber os dados do lado do cliente.

_______________________________________________________________________________________
## FUNCIONAMENTOs
[![Watch the video](https://github.com/m3adn/Redes-JavaSpeedTest/blob/master/code/img/redes-empresariales.png)](https://www.youtube.com/watch?v=rYiX_2ziDJ0&feature=youtu.be)
