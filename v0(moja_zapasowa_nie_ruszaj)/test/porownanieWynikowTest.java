import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class porownanieWynikowTest {
    @Test
    public void NrJedenPrzypadekTest(){
        porownanieWynikow por = new porownanieWynikow();
        Druzyna d0 = new Druzyna("aa");
        Druzyna d1 = new Druzyna("bb");
        d0.wygrana();
        d0.wygrana();
        d0.wygrana();
        d1.wygrana();
        assertEquals(1,por.compare(d0,d1));
    }
}