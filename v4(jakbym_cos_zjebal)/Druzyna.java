import java.io.Serializable;
import java.util.ArrayList;

public class Druzyna implements Serializable{
    private String nazwa;
    private int zwyciestwa = 0;
    Druzyna(String n){
        nazwa = n;
    }
    Druzyna(Druzyna d){
        nazwa=d.nazwa;
        zwyciestwa= d.zwyciestwa;
    }

    public void wygrana(){
        zwyciestwa=zwyciestwa+1;
    }
    public int getZwyciestwa(){return zwyciestwa;}
    public void setZwyciestwa(int i){zwyciestwa=i;}

    @Override
    public String toString() {
        return nazwa;
    }
}
