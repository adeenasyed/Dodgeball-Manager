// Instructor-provided support class.
// You should not modify this code!

/**
 * Each DodgeballNode object represents a single node in a linked
 * list for dodgeball.
 */
public class DodgeballNode {
    public String name;   // this person's name
    public int score;   // the number of hits and dodges the person has
    public DodgeballNode next; // next node in list (null if none)

    /**
     * Constructs a new node to store the given name and no
     * next node.
     */
    public DodgeballNode(String name) {
        this(name, null);
    }

    /**
     * Constructs a new node to store the given name and a
     * reference to the given next node.
     */
    public DodgeballNode(String name, DodgeballNode next) {
        this.name = name;
        this.score = 0;
        this.next = next;
        constructorCount++;
    }

    // code below this point is for MSCI 240 grading only
    private static int constructorCount = 0;

    public static void resetCount() {
        constructorCount = 0;
    }

    public static int getCount() {
        return constructorCount;
    }
}
