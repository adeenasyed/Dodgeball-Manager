import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class DodgeballManagerTest {

    DodgeballManager dm; // create new DodgeballManager

    // create and pass parameters into constructor of DodgeballManager
    @BeforeEach // runs before every unit test to set up a fresh DodgeballManager
    void setupCase() {
        List<String> throwers = new LinkedList<String>();
        throwers.add("Adeena");
        throwers.add("Kai");
        throwers.add("Camille");
        List<String> dodgers = new LinkedList<String>();
        dodgers.add("Harry");
        dodgers.add("Chris");
        dodgers.add("Michael");
        dm = new DodgeballManager(throwers, dodgers);
    }

    // tests if isThrower method returns true for valid thrower name
    @Test 
	public void testIsThrower() { 
		assertTrue(dm.isThrower("Adeena"));
	}

    // tests if isThrower method returns false for invalid thrower name
	@Test 
	public void testIsThrower2() {
		assertFalse(dm.isThrower("Harry"));
	}

    // tests if isActiverDodger method returns true for valid dodger name
    @Test 
    public void testIsActiveDodger() { 
        assertTrue(dm.isActiveDodger("Harry"));
    }

    // tests if isActiveDodger method returns false for invalid dodger name
    @Test 
    public void testIsActiveDodger2() { 
        assertFalse(dm.isActiveDodger("Adeena"));
    }

    // tests if isBenchedPlayer method returns false for invalid dodger name
    @Test 
    public void testIsBenchedPlayer() { 
        assertFalse(dm.isBenchedPlayer("Harry"));
    }

    // tests if isBenchedPlayer method returns true for valid dodger name
    @Test 
    public void testIsBenchedPlayer2() { 
        dm.hit("Adeena", "Harry");
        assertTrue(dm.isBenchedPlayer("Harry"));
    }

    // tests if nBenchedPlayers method returns 0 for bench with 0 players
    @Test 
    public void testNBenchedPlayers() { 
        assertEquals(0, dm.nBenchedPlayers());
    }

    // tests if nBenchedPlayers method returns correct number of benched players for bench with > 0 players
    @Test 
    public void testNBenchedPlayers2() { 
        dm.hit("Adeena", "Harry");
        dm.hit("Kai", "Chris");
        assertEquals(2, dm.nBenchedPlayers());
    }

    // tests if nActiveDodgers method returns total number of dodgers when no dodgers have been hit
    @Test 
    public void testNActiveDodgers() { 
        assertEquals(3, dm.nActiveDodgers());
    }

    // tests if nActiveDodgers method returns 0 when all dodgers have been hit
    @Test 
    public void testNActiveDodgers2() { 
        dm.hit("Adeena", "Harry");
        dm.hit("Kai", "Chris");
        dm.hit("Camille", "Michael");
        assertEquals(0, dm.nActiveDodgers());
    }

    // tests if dodge method throws IllegalArgumentException for invalid dodgerName
    @Test
    public void testDodge() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.dodge("Adeena", "Alex");
        });
    }

    // tests if dodge method throws IllegalArgumentException for invalid throwerName
    @Test
    public void testDodge2() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.dodge("Alex", "Harry");
        });
    }

    // tests if dodge method throws IllegalArgumentException for empty dodgerName
    @Test 
    public void testDodge3() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.dodge("Adeena", "");
        }); 
    }

    // tests if dodge method throws IllegalArgumentException for empty throwerName
    @Test 
    public void testDodge4() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.dodge("", "Harry");
        }); 
    }

    // tests if dodge method throws IllegalArgumentException for null dodgerName
    @Test 
    public void testDodge5() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.dodge("Adeena", null);
        }); 
    }

    // tests if dodge method throws IllegalArgumentException for null throwerName
    @Test 
    public void testDodge6() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.dodge(null, "Harry");
        }); 
    }

    // tests if hit method throws IllegalArgumentException for invalid dodgerName
    @Test
    public void testHit() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.hit("Adeena", "Alex");
        });
    }

    // tests if hit method throws IllegalArgumentException for invalid throwerName
    @Test 
    public void testHit2() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.hit("Alex", "Harry");
        }); 
    }

    // tests if hit method throws IllegalArgumentException for empty dodgerName
    @Test 
    public void testHit3() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.hit("Adeena", "");
        }); 
    }

    // tests if hit method throws IllegalArgumentException for empty throwerName
    @Test 
    public void testHit4() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.hit("", "Harry");
        }); 
    }

    // tests if hit method throws IllegalArgumentException for null dodgerName
    @Test 
    public void testHit5() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.hit("Adeena", null);
        }); 
    }

    // tests if hit method throws IllegalArgumentException for null throwerName
    @Test 
    public void testHit6() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.hit(null, "Harry");
        }); 
    }

    // tests if catchBall method throws IllegalArgumentException for invalid dodgerName
    @Test 
    public void testCatchBall() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall("Adeena", "Alex");
        }); 
    }

    // tests if catchBall method throws IllegalArgumentException for invalid throwerName
    @Test 
    public void testCatchBall2() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall("Alex", "Harry");
        }); 
    }

    // tests if catchBall method throws IllegalArgumentException for empty dodgerName
    @Test 
    public void testCatchBall3() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall("Adeena", "");
        }); 
    }

    // tests if catchBall method throws IllegalArgumentException for empty throwerName
    @Test 
    public void testCatchBall4() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall("", "Harry");
        }); 
    }

    // tests if catchBall method throws IllegalArgumentException for null dodgerName
    @Test 
    public void testCatchBall5() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall("Adeena", null);
        }); 
    }

    // tests if catchBall method throws IllegalArgumentException for null throwerName
    @Test 
    public void testCatchBall6() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall(null, "Harry");
        }); 
    }

    // tests if catchBall method throws IllegalArgumentException for invalid benchBackName
    @Test 
    public void testCatchBall7() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall("Adeena", "Harry", "Alex");
        }); 
    } 

    // tests if catchBall method throws IllegalArgumentException for empty benchBackName
    @Test 
    public void testCatchBall8() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall("Adeena", "Harry", "");
        }); 
    } 

    // tests if catchBall method throws IllegalArgumentException for null benchBackName
    @Test 
    public void testCatchBall9() { 
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dm.catchBall("Adeena", "Harry", null);
        }); 
    } 

    // tests if printThrowers method prints correct string when throwers have no points
    @Test 
    public void testPrintThrowers() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printThrowers(ps);
        assertEquals("Adeena 0, Kai 0, Camille 0", stream.toString());
    }

    // tests if printThrowers method prints correct string when throwers have points
    @Test 
    public void testPrintThrowers2() {
        dm.hit("Adeena", "Harry"); 
        dm.hit("Kai", "Chris");
        dm.hit("Kai", "Michael");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printThrowers(ps);
        assertEquals("Adeena 1, Kai 2, Camille 0", stream.toString());
    }

    // tests if printDodgers method prints correct string when dodgers have no points
    @Test 
    public void testPrintDodgers() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printDodgers(ps);
        assertEquals("Harry 0, Chris 0, Michael 0", stream.toString());
    }

    // tests if printDodgers method prints empty when no dodgers remain
    @Test 
    public void testPrintDodgers2() {
        dm.hit("Adeena", "Harry");
        dm.hit("Kai", "Chris");
        dm.hit("Kai", "Michael");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printDodgers(ps);
        assertEquals("empty", stream.toString());
    }

    // tests if printDodgers method prints correct string when dodgers have points and have been brought back from bench
    @Test 
    public void testPrintDodgers3() {
        dm.hit("Camille", "Harry");
        dm.catchBall("Kai", "Chris", "Harry");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printDodgers(ps);
        assertEquals("Chris 1, Harry 0, Michael 0", stream.toString());
    }

    // tests if printBench method prints empty when all dodgers remain
    @Test 
    public void testPrintBench() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printBench(ps);
        assertEquals("empty", stream.toString());
    }

    // tests if printBench method prints correct string when dodgers have been benched
    @Test 
    public void testPrintBench2() {
        dm.hit("Camille", "Harry");
        dm.hit("Kai", "Chris");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printBench(ps);
        assertEquals("Harry 0, Chris 0", stream.toString());
    }

    // tests if printBench method prints correct string when dodgers have been brought back from bench
    @Test 
    public void testPrintBench3() {
        dm.hit("Camille", "Harry");
        dm.hit("Kai", "Chris");
        dm.catchBall("Kai", "Michael", "Harry");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printBench(ps);
        assertEquals("Chris 0", stream.toString());
    }
    
    // tests if printMVP prints correct MVP and score
    @Test 
    public void testPrintMVP() { 
        dm.dodge("Adeena", "Harry");
        dm.catchBall("Kai", "Harry");
        dm.hit("Adeena", "Harry"); 
        dm.hit("Kai", "Chris");
        dm.hit("Camille", "Michael"); 
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printMVP(ps);
        assertEquals("Harry 2", stream.toString());
    }

    // tests if printMVP prints correct MVP and score for multiple MVPs
    @Test 
    public void testPrintMVP_Multiple_MVP() { 
        dm.dodge("Adeena", "Harry");
        dm.catchBall("Kai", "Harry");
        dm.hit("Adeena", "Harry"); 
        dm.hit("Kai", "Chris");
        dm.hit("Adeena", "Michael"); 
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        dm.printMVP(ps);
        assertEquals("Adeena 2, Harry 2", stream.toString());
    }
}