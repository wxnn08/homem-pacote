package jogo;
import java.util.concurrent.TimeUnit;

public class ThreadMov extends Thread{
    public void run(){
        try{
            Controle c = new Controle();
            while(true){
                c.mover();
                c.gm.clear();
                c.gm.tela();
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (Exception e){}
    }
}

