package pe.upc.is275.sesion1;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer implements LineListener {

    private boolean playCompleted;
    private String archivo;

    public AudioPlayer(String archivo) {
        this.archivo = archivo;
    }
    public void reproducir () {

        playCompleted = false;
        File audioFile = new File(archivo);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.addLineListener(this);

            audioClip.open(audioStream);

            audioClip.start();

            while (!playCompleted) {
                // wait for the playback completes
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            audioClip.close();
        } catch (UnsupportedAudioFileException ex) {
            System.out.printf("El formato de audio no es soportado: %s\n", ex.getMessage());
        } catch (LineUnavailableException ex) {
            System.out.printf("Hardware de audio no  disponible: %s\n", ex.getMessage());
        } catch (IOException ex) {
            System.out.printf("Error reproduciendo el archivo: %s\n", ex.getMessage());
        }
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();

        if (type == LineEvent.Type.START) {

        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
        }
    }
}
