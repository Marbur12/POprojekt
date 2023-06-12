import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


import static org.junit.jupiter.api.Assertions.*;

public  class MeczTest {

    @Test
    public void Wygrana1druzynyTest() {
        Druzyna d1 = new Druzyna("koty");
        Druzyna d2 = new Druzyna("tygrysy");
        Sedzia s = new Sedzia("Jan","kowalski");
        String dane = "3\n1\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(dane.getBytes());
        System.setIn(in);


        Mecz2ogni mecz = new Mecz2ogni(d1,d2,s); // Replace with the actual class name
        mecz.wynik();


        System.setIn(sysInBackup);


        assertEquals(0, mecz.zwyciezca);

    }
    @Test
    public void Wygrana2druzynyTest() {
        Druzyna d1 = new Druzyna("koty");
        Druzyna d2 = new Druzyna("tygrysy");
        Sedzia s = new Sedzia("Jan","kowalski");
        String dane = "1\n3\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(dane.getBytes());
        System.setIn(in);


        Mecz2ogni mecz = new Mecz2ogni(d1,d2,s); // Replace with the actual class name
        mecz.wynik();


        System.setIn(sysInBackup);


        assertEquals(1, mecz.zwyciezca);

    }
    @Test
    public void PierwszyBladTest() {
        Druzyna d1 = new Druzyna("koty");
        Druzyna d2 = new Druzyna("tygrysy");
        Sedzia s = new Sedzia("Jan","kowalski");
        String dane = "-1\n3\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(dane.getBytes());
        System.setIn(in);


        Mecz2ogni mecz = new Mecz2ogni(d1,d2,s); // Replace with the actual class name


        assertThrows(wynikException.class,
                ()->{
                    mecz.wynik();
                });
        System.setIn(sysInBackup);
    }
    @Test
    public void DrugiBladTest() {
        Druzyna d1 = new Druzyna("koty");
        Druzyna d2 = new Druzyna("tygrysy");
        Sedzia s = new Sedzia("Jan","kowalski");
        String dane = "1\n-3\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(dane.getBytes());
        System.setIn(in);


        Mecz2ogni mecz = new Mecz2ogni(d1,d2,s); // Replace with the actual class name


        assertThrows(wynikException.class,
                ()->{
                    mecz.wynik();
                });
        System.setIn(sysInBackup);
    }
    @Test
    public void TrzeciBladTest() {
        Druzyna d1 = new Druzyna("koty");
        Druzyna d2 = new Druzyna("tygrysy");
        Sedzia s = new Sedzia("Jan","kowalski");
        String dane = "1\n1\n";
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(dane.getBytes());
        System.setIn(in);


        Mecz2ogni mecz = new Mecz2ogni(d1,d2,s); // Replace with the actual class name


        assertThrows(wynikException.class,
                ()->{
                    mecz.wynik();
                });
        System.setIn(sysInBackup);
    }
}
