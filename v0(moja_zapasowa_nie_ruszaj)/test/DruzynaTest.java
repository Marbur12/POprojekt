import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DruzynaTest {
    @Test
    public void testowanieWygranych(){
        Druzyna druzyna = new Druzyna("costam");
        druzyna.wygrana();
        druzyna.wygrana();
        assertEquals(2, druzyna.getZwyciestwa());
    }
    @Test
    public void testowanieSetZwyciestwa(){
        Druzyna druzyna = new Druzyna("costam");
        druzyna.setZwyciestwa(5);
        assertEquals(5,druzyna.getZwyciestwa());
    }
    @Test
    public void testowanieToString(){
        Druzyna druzyna = new Druzyna("costam");
        assertEquals("costam",druzyna.toString());
    }
}