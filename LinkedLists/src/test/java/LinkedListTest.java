import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListTest {
    @Test
	void PushBackTest() {
		LinkedList<String> list = new LinkedList<String>("Doggo <3");
        list.push_back("uwu");
        assertEquals(list.toString(), "[Doggo <3, uwu]", "push should add uwu to the list"); 
    }
    
    @Test
    void PopBackTest() {
        LinkedList<String> list = new LinkedList<String>("Doggo <3");
        assertEquals(list.pop_back(), "Doggo <3", "Pop should return Doggo <3");
        assertEquals(list.toString(), "[Doggo <3]", "List should be [Doggo <3]");
    }

    @Test
    void EmptyListTest() {
        LinkedList<String> list = new LinkedList<String>();
        assertEquals(list.toString(), "[ ]", "Empty list should be [ ]");
        assertTrue(list.isEmpty(), "isEmpty() should return True for an empty list");
    }

    @Test
    void ReverseTest() {
        LinkedList<String> list = new LinkedList<String>("Doggo <3");
        list.push_back("uwu");
        list.reverse(); 
        assertEquals(list.toString(), "[uwu, Doggo <3]", "reverse should output [uwu, Doggo <3]"); 
    }

}