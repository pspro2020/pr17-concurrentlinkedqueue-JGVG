package clasificadora;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tolva implements Runnable {
    List contenido = new ArrayList<Elemento>();
    int n_tolva;
    Cinta cinta;
    boolean estado = true;

    public Tolva(int n_tolva, Cinta cinta){
        this.cinta = cinta;
        for(int i = 1; i < 6; i++){
            contenido.add(new Elemento(i, n_tolva));
        }
    }

    @Override
    public void run() {
        while(!contenido.isEmpty()){
            try {
                TimeUnit.SECONDS.sleep((int)Math.random()*(1-(2+1))+(2));
                Elemento elemento = (Elemento) contenido.remove(0);
                System.out.printf("La tolva número %d ha soltado un elemento %d.\n", elemento.n_tolva, elemento.numero);
                cinta.colocar(elemento);
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.printf("La tolva número %d se ha quedado sin elementos.\n", n_tolva);
    }

}
