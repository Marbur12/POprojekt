import java.io.Serializable;

public class Sedzia_pomocniczy extends Sedzia implements Serializable {
    Sedzia_pomocniczy(String i, String n){
        super(i,n);
    }

    Sedzia_pomocniczy(Sedzia_pomocniczy pom1) {
        super(pom1);
    }
}
