package clasificadora;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Cinta{
    ConcurrentLinkedQueue cinta = new ConcurrentLinkedQueue<Elemento>();

    public void colocar(Elemento elemento){
        if(elemento != null){
            System.out.printf("La cinta recibe un elemento %d.\n", elemento.numero);
            cinta.add(elemento);
        }else{
            System.out.println("La cinta se ha parado.");
        }

    }

    public Elemento dejarCaer(){
        if(!cinta.isEmpty()){
            return (Elemento) cinta.remove();
        }else{
            return null;
        }
    }
}
