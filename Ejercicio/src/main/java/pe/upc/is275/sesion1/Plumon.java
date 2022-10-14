package pe.upc.is275.sesion1;

public class Plumon {

    public static enum TipoPunta { Fina, Gruesa }
    public static enum Color { Rojo, Verde, Azul }

    private TipoPunta tipoPunta;
    private Color color;

    public Plumon(TipoPunta tipoPunta, Color color) {
        this.tipoPunta = tipoPunta;
        this.color = color;
    }
    
    public void pintar(String texto)
    {
        String puntaCodigoANSI = (tipoPunta == TipoPunta.Gruesa) ? "\033[1m" : "";

        String colorCodigoANSI;
        switch (color)
        {
            case Rojo:
                colorCodigoANSI = "\u001B[31m";
                break;
            case Verde:
                colorCodigoANSI = "\u001B[32m";
                break;
            case Azul:
                colorCodigoANSI = "\u001B[34m";
                break;
            default:
                colorCodigoANSI = "";
        }

        System.out.printf("%s%s%s\n", puntaCodigoANSI, colorCodigoANSI, texto);
    }

}
