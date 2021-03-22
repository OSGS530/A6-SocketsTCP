package E6.Server;

import E6.AlgorithmsUtils;
import E6.Protocol.ProtocolMethodNotFoundException;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.*;
import static E6.Server.Utils.logFile;

public class RequestHandler implements Runnable {
    private Socket socket;
    private DataOutputStream datosSalida;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            DataInputStream datosEntrada = new DataInputStream(
                    new BufferedInputStream(this.socket.getInputStream()));
            this.datosSalida = new DataOutputStream(this.socket.getOutputStream());

            String message = datosEntrada.readUTF();

            logFile("Datos recibidos de:"+ socket+"\n\tRecibe:"+message, Level.INFO);
            List<String> dataTemp = Arrays.asList(message.split(","));

            ArrayList<String> data = new ArrayList<>(dataTemp);

            Integer op = Integer.parseInt(data.get(0));
            Double result = getResult(op,data);
            String response=op+","+result;
            datosSalida.writeUTF(response);
            datosSalida.flush();
            logFile("Datos enviados a: "+ socket+"\n\tEnvia"+response, Level.INFO);
        }catch (IOException e) {
            e.printStackTrace();
            logFile(e.getMessage(),Level.SEVERE);
        } catch (ProtocolMethodNotFoundException e) {
            e.printStackTrace();
            logFile(e.getMessage(),Level.SEVERE);
        }
        finally {
            try {
                this.datosSalida.close();
                socket.close();
                logFile("Socket closed", Level.INFO);
            } catch (IOException e) {
                e.printStackTrace();
                logFile(e.getMessage(),Level.SEVERE);
            }
        }
    }

    private static double getResult(int op, ArrayList<String> data) throws ProtocolMethodNotFoundException {
        double result;
        switch (op) {
            case 1:
                result = AlgorithmsUtils.areaCilindro(Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)));
                break;
            case 2:
                result = AlgorithmsUtils.areaEsfera(Double.parseDouble(data.get(1)));
                break;
            case 3:
                result = AlgorithmsUtils.areaCono(Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)));
                break;
            case 4:
                result = AlgorithmsUtils.areaCubo(Double.parseDouble(data.get(1)));
                break;
            case 5:
                result = AlgorithmsUtils.areaPrisma(Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)));
                break;
            case 6:
                result = AlgorithmsUtils.areaPiramide(Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)));
                break;
            case 7:
                result = AlgorithmsUtils.volumenCilindro(Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)));
                break;
            case 8:
                result = AlgorithmsUtils.volumenEsfera(Double.parseDouble(data.get(1)));
                break;
            case 9:
                result = AlgorithmsUtils.volumenCono(Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)));
                break;
            case 10:
                result = AlgorithmsUtils.volumenCubo(Double.parseDouble(data.get(1)));
                break;
            case 11:
                result = AlgorithmsUtils.volumenPrisma(Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)));
                break;
            case 12:
                result = AlgorithmsUtils.volumenPiramide(Double.parseDouble(data.get(1)), Double.parseDouble(data.get(2)));
                break;
            default:
                throw new ProtocolMethodNotFoundException();
        }
        return result;

    }
}
