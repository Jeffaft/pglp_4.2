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
	

}
