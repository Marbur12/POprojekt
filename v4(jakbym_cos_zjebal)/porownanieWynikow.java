import java.util.Comparator;

class porownanieWynikow implements Comparator<Druzyna> {
    @Override
    public int compare(Druzyna d1, Druzyna d2){
        int d1wynik = d1.getZwyciestwa();
        int d2wynik = d1.getZwyciestwa();

        if(d1wynik>d2wynik){
            return 1;
        }else if (d1wynik<d2wynik){
            return -1;
        }else{
            return 0;
        }
    }
}