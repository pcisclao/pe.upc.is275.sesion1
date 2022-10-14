package pe.upc.is275.sesion1;

public class Persona {
    private String nombre;
    private String profesion;
    private int edad;

    public Persona(String nombre, String profesion, int edad) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.edad = edad;
    }

    public void saludar(){
        System.out.printf("Hola, mi nombre es %s, soy %s y tengo %d años.\n", nombre, profesion, edad);
    }
}
