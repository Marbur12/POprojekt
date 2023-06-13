import java.io.Serializable;

public final class Mecz2ogni extends Mecz implements Serializable {
        Mecz2ogni(Druzyna d0, Druzyna d1, Sedzia s){
        super(d0,d1, s);
    }

        public String rodzajMeczu(){
            return "Mecz 2 ogni";
        }
}
