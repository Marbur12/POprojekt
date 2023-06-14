import java.io.Serializable;
import java.util.ArrayList;

public final class MeczSiatkowki extends Mecz implements Serializable {
    private Sedzia_pomocniczy pom1, pom2;
    MeczSiatkowki(Druzyna d0, Druzyna d1,Sedzia s, Sedzia_pomocniczy sp1, Sedzia_pomocniczy sp2){
        super(d0,d1,s);
        pom1 = sp1;
        pom2 = sp2;
        //jesli jakies problemy z sedziami to moze tu?
    }
    public String rodzajMeczu(){
        return "Mecz siatkowki";
    }

    public void modSedziPomocniczych(Sedzia_pomocniczy s1, Sedzia_pomocniczy s2){
        pom1 = s1;
        pom2 = s2;
    }
    public ArrayList<Sedzia_pomocniczy> getSedzia_pomocniczy(){
        ArrayList<Sedzia_pomocniczy> sedziowie_pomoc =new ArrayList<Sedzia_pomocniczy>();
        sedziowie_pomoc.add(pom1);
        sedziowie_pomoc.add(pom2);
        return sedziowie_pomoc;
        //(zjebane)->chyba fixed
    }
}
