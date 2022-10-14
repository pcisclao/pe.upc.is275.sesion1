package pe.upc.is275.sesion1;

import java.util.Objects;

public class Animal {
    private String nombre;
    private String sonido;
    private int patas;

    public Animal(String nombre, String sonido, int patas) {
        this.nombre = nombre;
        this.sonido = sonido;
        this.patas = patas;
    }

    public void emitirSonido() {
        AudioPlayer audioPlayer = new AudioPlayer(sonido);
        System.out.printf("%s emitiendo sonido...\n", nombre);
        audioPlayer.reproducir();
    }
}
