package E6;


public class AlgorithmsUtils{

    public static double areaCilindro(double radio, double altura) {

        return 2 *  Math.PI * radio * ( altura + radio );

    }

    public static double areaEsfera(double radio) {
        return 4 * Math.PI * Math.pow(radio, 2);

    }

    public static double areaCono(double radio, double g) {
        return (Math.PI * Math.pow(radio, 2) + (Math.PI * radio * g) );
    }

    public static double areaCubo(double lado) {
        return 6 * Math.pow(lado, 2);

    }

    public static double areaPrisma(double base, double altura) {

        return (((base*4)*altura)+2)*(base*base);

    }

    public static double areaPiramide(double base, double apotema) {

        return (((base*4)*apotema)/2)+(base*base);
    }

    /**
     *
     * Metodos para calcular el volumen de las figuras
     *
     *
     * @return*/
    public static double volumenCilindro(double radio, double altura) {

        return (Math.PI * Math.pow(radio, 2)) * altura;

    }

    public static double volumenEsfera(double radio) {

        return (4 / 3) * Math.PI * Math.pow(radio, 2);

    }

    public static double volumenCono(double radio, double altura) {
        return (Math.PI * Math.pow(radio, 2) * altura) / 3 ;

    }

    public static double volumenCubo(double a) {
        return 6 * Math.pow(a, 3);
    }

    public static double volumenPrisma(double base, double altura) {
        return base * altura;
    }

    public static double volumenPiramide(double base, double altura) {
        return (base*altura)/3;
    }
}
