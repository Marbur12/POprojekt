import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OsobaTest {
    @Test
    public void testowanieModyfikacji(){
        Sedzia sedzia = new Sedzia("mariusz","kowalski");
        sedzia.modyfikuj("daniel","kowalski");
        assertEquals("daniel kowalski",sedzia.getDane());
    }
    @Test
    public void testowanieGetDane(){
        Sedzia sedzia = new Sedzia("mariusz","kowalski");
        assertEquals("mariusz kowalski",sedzia.getDane());
    }
}