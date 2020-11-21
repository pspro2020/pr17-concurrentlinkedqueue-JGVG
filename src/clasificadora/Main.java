package clasificadora;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Cinta cinta_transportadora = new Cinta();
        Clasificadora separadora = new Clasificadora(cinta_transportadora);

        Thread tolva_01 = new Thread(new Tolva(1,cinta_transportadora));
        Thread tolva_02 = new Thread(new Tolva(2,cinta_transportadora));
        Thread tolva_03 = new Thread(new Tolva(3,cinta_transportadora));
        Thread tolva_04 = new Thread(new Tolva(4,cinta_transportadora));
        Thread tolva_05 = new Thread(new Tolva(5,cinta_transportadora));
        Thread clasificadora = new Thread(separadora);

        try {
            tolva_01.start();
            tolva_02.start();
            tolva_03.start();
            tolva_04.start();
            tolva_05.start();

            TimeUnit.SECONDS.sleep(3);
            clasificadora.start();
            System.out.println("La clasificadora se ha puesto en marcha.");

            tolva_01.join();
            tolva_02.join();
            tolva_03.join();
            tolva_04.join();
            tolva_05.join();

            TimeUnit.SECONDS.sleep(20);
            clasificadora.interrupt();
        } catch (InterruptedException e) {
            return;
        }

        System.out.println("La clasificadora ha terminado de clasificar elementos.");

        System.out.println("Contenedor de elementos 1:");
        for (Elemento elemento : separadora.getContenedor(1)) {
            System.out.printf(" - Elemento %d de la tolva %d\n",elemento.numero, elemento.n_tolva);
        }

        System.out.println("Contenedor de elementos 2:");
        for (Elemento elemento : separadora.getContenedor(2)) {
            System.out.printf(" - Elemento %d de la tolva %d\n",elemento.numero, elemento.n_tolva);
        }

        System.out.println("Contenedor de elementos 3:");
        for (Elemento elemento : separadora.getContenedor(3)) {
            System.out.printf(" - Elemento %d de la tolva %d\n",elemento.numero, elemento.n_tolva);
        }

        System.out.println("Contenedor de elementos 4:");
        for (Elemento elemento : separadora.getContenedor(4)) {
            System.out.printf(" - Elemento %d de la tolva %d\n",elemento.numero, elemento.n_tolva);
        }

        System.out.println("Contenedor de elementos 5:");
        for (Elemento elemento : separadora.getContenedor(5)) {
            System.out.printf(" - Elemento %d de la tolva %d\n",elemento.numero, elemento.n_tolva);
        }

    }
}
