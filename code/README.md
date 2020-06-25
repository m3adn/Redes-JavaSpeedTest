Aqui vais encontrar o codigo descrito no inicio do projeto.
______________________________________________________________________________________
## O que é um socket?

Hoje em dia o uso de mensageiros (como Skype , Messenger , Whatsapp) é uma questão indinspensável. Existem uma grande variedade de protocolos e clientes , mas não todos sabem a forma como eles funcionam. Imaginemos que você faz login numa destas plataformas e a seguir clica em conectar/entrar. Qual será uma das formas a realizar isso? Utilizando **sockets**.

Socket preve a comunicação entre duas pontas (fonte e destino), entre dois processos que estejam na mesma máquina (Unix Socket) ou na rede (TCP/IP Socket). No geral existem dois tipos de sockets: TCP e UDP. O Socket vai funcionar como uma interface entre a camada de Aplicação e a de Transporte, possibilitando que haja uma abstração dos detalhes da pilha TCP/IP, e consequentemente, dando a sensação que os processos envolvidos na sensação estão a comunicar diretamente entre si, no entanto, ela está passando pela rede. Essa abstração gerada pelos Sockets é o que chamamos de comunicação lógica. Outra forma de entender os Sockets é que eles são a "interface" de comunicação interprocessos.

_________________________________________________________________________________________
## SIMPLE CLIENT 

__________________________________________________________________________________________
## SIMPLE SERVER
```ServerSocket ss = new ServerSocket(port);
```Socket socket = ss.accept();

