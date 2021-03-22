package E6.Protocol;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ProtocolRequestExecutor {
    private static final int _PUERTO = 1234;
    private InetAddress serverAddress;
    private ProtocolRequest protocolRequest;

    private Socket socketCliente = null;
    private DataInputStream datosRecepcion = null;
    private DataOutputStream datosEnvio = null;

    private ProtocolResponse response;

    public ProtocolRequestExecutor(InetAddress serverAddress, ProtocolRequest protocolRequest) {
        this.serverAddress = serverAddress;
        this.protocolRequest = protocolRequest;
    }

    private void prepareExecution(){
        try {
            socketCliente = new Socket(serverAddress, _PUERTO);
            // //Extraemos los streams de entrada y salida
            datosRecepcion = new DataInputStream(socketCliente.getInputStream());
            datosEnvio = new DataOutputStream(socketCliente.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequest() throws IOException {
        prepareExecution();
        StringBuilder builder = new StringBuilder();
        builder.append(protocolRequest.getOperationType().toString());

        for(Double d: protocolRequest.getParams()){
            builder.append(",");
            builder.append(d.toString());
        }
        datosEnvio.writeUTF(builder.toString());
        getResponseFromServer();
    }

    private void getResponseFromServer(){
        ProtocolResponseBuilder protocolResponseBuilder = new ProtocolResponseBuilder();
        try {
            response=protocolResponseBuilder.addResponse(datosRecepcion.readUTF()).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProtocolResponse getResponse(){
        return this.response;
    }

    public InetAddress getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(InetAddress serverAddress) {
        this.serverAddress = serverAddress;
    }
}
