package E6.Client;

import E6.Protocol.*;

import java.net.*;
import java.util.Scanner;



public class ClienteSockets {


    private static final int _PUERTO = 1234;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InetAddress ipServidor = null;

        try {
            ipServidor = InetAddress.getByName(args[0]);
        } catch (UnknownHostException uhe) {
            System.err.println("Host no encontrado : " + uhe);
            System.exit(-1);
        }

        // Para cada uno de los argumentos...

            ProtocolRequest request=null;
            ProtocolRequestBuilder requestBuilder = new ProtocolRequestBuilder();
            ProtocolRequestExecutor executor;

            ProtocolResponse response=null;

            try {
                do{
                    System.out.println("---- Calculo de area y volumen ----");
                    System.out.println("Elija la acción que desea realizar: ");
                    System.out.println("\t1.Calcular área \t2.Calcular volumen \t3.Salir");
                    System.out.print("Ingrese el numero: ");
                    int opcion = scanner.nextInt();

                    if (opcion == 1) {

                        // Mostrar las figuras para el area
                        System.out.println("Calcular Area");
                        System.out.println("\t1.Cilindro \t2.Esfera \t3.Cono \t4.Cubo \t5.Prisma \t6.Piramide");
                        System.out.println("Elija un numero: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                        case 1:
                            request = areaCilindro();
                            executor = new ProtocolRequestExecutor(ipServidor,request);
                            executor.sendRequest();
                            response = executor.getResponse();
                            if(request!=null && response!=null)
                                ImprimirResultado(response.getResultado(), request.getOperationType());
                            break;
                        case 2:
                            request = areaEsfera();
                            executor = new ProtocolRequestExecutor(ipServidor,request);
                            executor.sendRequest();
                            response = executor.getResponse();
                            if(request!=null && response!=null)
                                ImprimirResultado(response.getResultado(), request.getOperationType());
                            break;
                        case 3:
                            request = areaCono();
                            executor = new ProtocolRequestExecutor(ipServidor,request);
                            executor.sendRequest();
                            response = executor.getResponse();
                            if(request!=null && response!=null)
                                ImprimirResultado(response.getResultado(), request.getOperationType());
                            break;
                        case 4:
                            request = areaCubo();
                            executor = new ProtocolRequestExecutor(ipServidor,request);
                            executor.sendRequest();
                            response = executor.getResponse();
                            if(request!=null && response!=null)
                                ImprimirResultado(response.getResultado(), request.getOperationType());

                            break;
                        case 5:
                            request = areaPrisma();
                            executor = new ProtocolRequestExecutor(ipServidor,request);
                            executor.sendRequest();
                            response = executor.getResponse();
                            if(request!=null && response!=null)
                                ImprimirResultado(response.getResultado(), request.getOperationType());

                            break;
                        case 6:
                            request = areaPiramide();
                            executor = new ProtocolRequestExecutor(ipServidor,request);
                            executor.sendRequest();
                            response = executor.getResponse();
                            if(request!=null && response!=null)
                                ImprimirResultado(response.getResultado(), request.getOperationType());
                            break;
                        default:
                            break;
                        }

                    } else if (opcion == 2) {
                        //Mostrar las figuras para el volumen
                        System.out.println("Calcular Volumen");
                        System.out.println("\t1.Cilindro \t2.Esfera \t3.Cono \t4.Cubo \t5.Prisma \t6.Piramide");
                        System.out.println("Elija un numero: ");
                        opcion = scanner.nextInt();
                        switch (opcion) {
                            case 1:
                                 request = volumenCilindro();
                                executor = new ProtocolRequestExecutor(ipServidor,request);
                                executor.sendRequest();
                                response = executor.getResponse();
                                if(request!=null && response!=null)
                                    ImprimirResultado(response.getResultado(), request.getOperationType());
                                break;
                            case 2:
                                request = volumenEsfera();
                                executor = new ProtocolRequestExecutor(ipServidor,request);
                                executor.sendRequest();
                                response = executor.getResponse();
                                if(request!=null && response!=null)
                                    ImprimirResultado(response.getResultado(), request.getOperationType());
                                break;
                            case 3:
                                request = volumenCono();
                                executor = new ProtocolRequestExecutor(ipServidor,request);
                                executor.sendRequest();
                                response = executor.getResponse();
                                if(request!=null && response!=null)
                                    ImprimirResultado(response.getResultado(), request.getOperationType());
                                break;
                            case 4:
                                request = volumenCubo();
                                executor = new ProtocolRequestExecutor(ipServidor,request);
                                executor.sendRequest();
                                response = executor.getResponse();
                                if(request!=null && response!=null)
                                    ImprimirResultado(response.getResultado(), request.getOperationType());
                                break;
                            case 5:
                                request = volumenPrisma();
                                executor = new ProtocolRequestExecutor(ipServidor,request);
                                executor.sendRequest();
                                response = executor.getResponse();
                                if(request!=null && response!=null)
                                    ImprimirResultado(response.getResultado(), request.getOperationType());
                                break;
                            case 6:
                                request = volumenPiramide();
                                executor = new ProtocolRequestExecutor(ipServidor,request);
                                executor.sendRequest();
                                response = executor.getResponse();
                                if(request!=null && response!=null)
                                    ImprimirResultado(response.getResultado(), request.getOperationType());
                                break;
                            default:
                                break;
                        }

                    } else if (opcion == 3) {
                        // Salir
                        System.out.println("Saliendo...");
                    } else {
                        System.err.println("Error. Opción no disponible... \nSaliendo...");
                    }
                }while(true);

            } catch (Exception e) {
                System.err.println("Se ha producido la excepcion : " + e);
                e.printStackTrace();
            }


    }

    /**
     * 
     * Metodos para calcular las áreas de las figuras
     * 
     **/

    //TODO: Cambiar esto a variables locales
    static double r;
    static double h;
    static double g;
    static double b;

    
    public static ProtocolRequest areaCilindro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor del radio: ");
        r = scanner.nextDouble();
        System.out.print("Ingrese el valor de la altura: ");
        h = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();
        return request.setOperation(ProtocolRequestOperation.AREA_CILINDRO).addParam(r).addParam(h).build();
    }

    public static ProtocolRequest areaEsfera() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor del radio: ");
        r = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();
        return request.setOperation(ProtocolRequestOperation.AREA_ESFERA).addParam(r).build();
    }

    public static ProtocolRequest areaCono() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor del radio: ");
        r = scanner.nextDouble();
        System.out.println("Ingrese el valor de g: ");
        g = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();

        return request.setOperation(ProtocolRequestOperation.AREA_CONO).addParam(r).addParam(g).build();
    }

    public static ProtocolRequest areaCubo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de a: ");
        double a = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();

        return request.setOperation(ProtocolRequestOperation.AREA_CUBO).addParam(a).build();
    }

    public static ProtocolRequest areaPrisma() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un lado de la base:");
        b = scanner.nextDouble();
        System.out.println("Ingrese el valor de h:");
        h = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();

        return request.setOperation(ProtocolRequestOperation.AREA_PRISMA).addParam(b).addParam(h).build();
    }

    public static ProtocolRequest areaPiramide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un lado de la base:");
        b = scanner.nextDouble();
        System.out.println("Ingrese el valor de ap.lat:");
        double ap = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();

        return request.setOperation(ProtocolRequestOperation.AREA_PIRAMIDE).addParam(b).addParam(ap).build();
    }

    /**
     * 
     * Metodos para calcular el volumen de las figuras
     * 
     **/
    public static ProtocolRequest volumenCilindro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor del radio: ");
        r = scanner.nextDouble();
        System.out.print("Ingrese el valor de la altura: ");
        h = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();
        return        request.setOperation(ProtocolRequestOperation.VOLUMEN_CILINDRO).addParam(r).addParam(h).build();
    }

    public static ProtocolRequest volumenEsfera() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor del radio: ");
        r = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();
     return   request.setOperation(ProtocolRequestOperation.VOLUMEN_ESFERA).addParam(r).build();
    }

    public static ProtocolRequest volumenCono() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de r: ");
        r = scanner.nextDouble();
        System.out.print("Ingrese el valor de g: ");
        double g = scanner.nextDouble();
        System.out.print("Ingrese el valor de h: ");
        h = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();

     return   request.setOperation(ProtocolRequestOperation.VOLUMEN_CONO).addParam(r).addParam(g).addParam(h).build();
    }

    public static ProtocolRequest volumenCubo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de a: ");
        double a = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();
        return request.setOperation(ProtocolRequestOperation.VOLUMEN_CUBO).addParam(a).build();
    }

    public static ProtocolRequest volumenPrisma() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el area de la base : ");
        b = scanner.nextDouble();
        System.out.print("Ingrese el valor de h");
        h = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();
return        request.setOperation(ProtocolRequestOperation.VOLUMEN_PRISMA).addParam(b).addParam(h).build();
    }

    public static ProtocolRequest volumenPiramide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el area de la base: ");
        b = scanner.nextDouble();
        System.out.println("Ingrese el valor de h:");
        h = scanner.nextDouble();
        ProtocolRequestBuilder request = new ProtocolRequestBuilder();
        return request.setOperation(ProtocolRequestOperation.VOLUMEN_PIRAMIDE).addParam(b).addParam(h).build();

    }

    public static void ImprimirResultado(Double resultado, int op) {
        String texto;
        switch (op) {
            case 1:
                texto = "El Area del Cilindo es: " + resultado;
                break;
            case 2:
                texto = "El Area de la Esfera es: " + resultado;
                break;
            case 3:
                texto = "El Area del Cono es: " + resultado;
                break;
            case 4:
                texto = "El Area del Prisma es: " + resultado;
                break;
            case 5:
                texto = "El Area de la piramide es: " + resultado;
                break;
            case 6:
                texto = "El Volumen del Cilindo es: " + resultado;
                break;
            case 7:
                texto = "El Volumen de la Esfera es: " + resultado;
                break;        
            case 8:
                texto = "El Volumen del Cilindo es: " + resultado;
                break;
            case 9:
                texto = "El Volumen del Cilindo es: " + resultado;
                break;
            case 10:
                texto = "El Volumen del Cilindo es: " + resultado;
                break;
            case 11:
                texto = "El Volumen del Cilindo es: " + resultado;
                break;
            case 12:
                texto = "El Volumen del Cilindo es: " + resultado;
                break;
        
            default:
                texto = "Error 504"; 
                break;
        }
        System.out.println(texto);
    }

}