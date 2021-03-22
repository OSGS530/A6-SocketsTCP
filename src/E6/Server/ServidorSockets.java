package E6.Server;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.*;


import static E6.Server.Utils.logFile;


public class ServidorSockets implements Server{

    private static final String _IP = "192.168.1.68";
    private static final int _PUERTO = 1234;
    private static final int _BACKLOG = 50;

    private static final int N_THREADS = 3;

    public static void main(String[] args) throws UnknownHostException {
        try {
            new ServidorSockets().start(_PUERTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(int port) throws IOException {
        InetAddress ip = InetAddress.getByName(_IP);

        try{
            System.out.println("IP del LocalHost = " + InetAddress.getLocalHost().toString());
            System.out.println("\nEscuchando en : \nIP Host = " + ip.getHostAddress());
            System.out.println("Puerto = " + _PUERTO);
            logFile("Servidor iniciado en: "+ip.getHostAddress()+" \n\ten puerto: "+_PUERTO, Level.INFO);
        } catch (UnknownHostException uhe){
            System.err.println("No se puede saber la direccion IP local : " + uhe);
            logFile("No se puede saber la direccion IP local : " + uhe,Level.SEVERE);
            System.exit(-1);
        }
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(_PUERTO,_BACKLOG,ip); //<--- si se usa ip especifica
        } catch(IOException ioe){
            System.err.println("Error al abrir el socket de servidor : " + ioe);
            logFile("Error al abrir el socket de servidor : " + ioe, Level.SEVERE);
            System.exit(-1);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        while(true){
            executorService.submit(new RequestHandler(serverSocket.accept()));
        }
    }

}
