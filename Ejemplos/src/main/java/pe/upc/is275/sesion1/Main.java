package pe.upc.is275.sesion1;

public class Main {
    public static void main(String[] args) {

        Persona obj = new Persona("Carlos", "ingeniero", 42);
        obj.saludar();

        Animal caballo = new Animal("Caballo", "horse.wav", 4);
        caballo.emitirSonido();
    }
}