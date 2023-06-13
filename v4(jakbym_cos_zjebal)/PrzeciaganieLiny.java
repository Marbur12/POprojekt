import java.io.Serializable;

public final class PrzeciaganieLiny extends Mecz implements Serializable {
        PrzeciaganieLiny(Druzyna d0, Druzyna d1, Sedzia s){
        super(d0,d1,s);
    }
        public String rodzajMeczu(){
            return "Mecz przeciągania liny";
    }
}
