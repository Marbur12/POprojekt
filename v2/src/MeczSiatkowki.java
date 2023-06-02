public final class MeczSiatkowki extends Mecz{
    private Sedzia_pomocniczy pom1, pom2;
    MeczSiatkowki(Druzyna d0, Druzyna d1, Sedzia s, int z){
        super(d0,d1,s,z);
    }
    public void modSedziPomocniczych(Sedzia_pomocniczy s1, Sedzia_pomocniczy s2){
        pom1 = s1;
        pom2 = s2;
    }
    public Sedzia_pomocniczy getSedzia_pomocniczy(){
        return pom1; //zjebane
    }
}
