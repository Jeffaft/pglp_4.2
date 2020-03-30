import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class MoteurRPNTest {
	MoteurRPN m;
	@Before
	public void init() {
		m = new MoteurRPN();
	}
	@Test
	public void testAddOperande() {
		m.addOperande(56.0);
		assertTrue(56.0 == m.stack.pop());
		m.addOperande(-2.0);
		assertTrue(-2.0 == m.stack.pop());
		m.addOperande(+5.0);
		assertTrue(5.0 == m.stack.pop());
	}
	
	@Test
	public void readyOpTest() {
		assertTrue(false == m.readyOp());
		m.addOperande(56.0);
		assertTrue(false == m.readyOp());
		m.addOperande(56.0);
		assertTrue(true == m.readyOp());
	}
	
	@Test
	public void clearSaveTest() {
		m.addOperande(8.0);
		assertEquals(true, m.undoStack.isEmpty());
		m.addOperande(10.0);
		assertTrue(8.0 == m.undoStack.pop());
	}
	
	@Test
	public void plusOpTest() {
		m.addOperande(8.0);
		m.addOperande(2.0);
		m.executeCommand("+");
		assertTrue(10.0 == m.stack.pop());
	}
	
	@Test
	public void moinsOpTest() {
		m.addOperande(8.0);
		m.addOperande(2.0);
		m.executeCommand("-");
		assertTrue(-6.0 == m.stack.pop());
	}
	
	@Test
	public void multOpTest() {
		m.addOperande(8.0);
		m.addOperande(2.0);
		m.executeCommand("*");
		assertTrue(16.0 == m.stack.pop());
	}
	
	@Test
	public void divOpTest() {
		m.addOperande(2.0);
		m.addOperande(16.0);
		m.executeCommand("/");
		assertTrue(8.0 == m.stack.pop());
	}
	
	@Test
	public void undoTest() {
		m.addOperande(2.0);
		m.addOperande(16.0);
		m.executeCommand("/");
		m.executeCommand("undo");
		assertTrue(16.0 == m.stack.pop());
		assertTrue(2.0 == m.stack.pop());
		assertEquals(true, m.stack.isEmpty());
	}
	
	@Test
	public void genTest() {
		m.addOperande(2.0);
		m.addOperande(16.0);
		m.executeCommand("/");
		m.addOperande(2.0);
		m.executeCommand("+");
		m.addOperande(5.0);
		m.executeCommand("*");
		m.addOperande(60.0);
		m.executeCommand("-");
		assertTrue(10.0 == m.stack.pop());
	}
}
