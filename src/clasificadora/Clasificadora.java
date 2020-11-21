package clasificadora;

import java.util.ArrayList;
import java.util.List;

public class Clasificadora implements Runnable{
    Cinta cinta;
    boolean estado = true;
    List contenedor_01 = new ArrayList<Elemento>();
    List contenedor_02 = new ArrayList<Elemento>();
    List contenedor_03 = new ArrayList<Elemento>();
    List contenedor_04 = new ArrayList<Elemento>();
    List contenedor_05 = new ArrayList<Elemento>();

    public Clasificadora(Cinta cinta){
        this.cinta = cinta;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){

            Elemento elemento = cinta.dejarCaer();

            if(elemento != null){
                switch(elemento.numero){
                    case 1:
                        contenedor_01.add(elemento);
                        System.out.printf("Elemento número %d añadido al contenedor 1.\n", elemento.numero);
                        break;
                    case 2:
                        contenedor_02.add(elemento);
                        System.out.printf("Elemento número %d añadido al contenedor 2.\n", elemento.numero);
                        break;
                    case 3:
                        contenedor_03.add(elemento);
                        System.out.printf("Elemento número %d añadido al contenedor 3.\n", elemento.numero);
                        break;
                    case 4:
                        contenedor_04.add(elemento);
                        System.out.printf("Elemento número %d añadido al contenedor 4.\n", elemento.numero);
                        break;
                    case 5:
                        contenedor_05.add(elemento);
                        System.out.printf("Elemento número %d añadido al contenedor 5.\n", elemento.numero);
                        break;
                }
            }
        }
    }

    public ArrayList<Elemento> getContenedor(int num){
        switch (num){
            case 1:
                return (ArrayList<Elemento>) contenedor_01;
            case 2:
                return (ArrayList<Elemento>) contenedor_02;
            case 3:
                return (ArrayList<Elemento>) contenedor_03;
            case 4:
                return (ArrayList<Elemento>) contenedor_04;
            case 5:
                return (ArrayList<Elemento>) contenedor_05;
            default:
                return null;
        }
    }
}
