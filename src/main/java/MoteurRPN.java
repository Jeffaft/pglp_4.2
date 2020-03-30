
public class MoteurRPN extends Interpreteur {
	public MoteurRPN() {
		super();
	}
	public static MoteurRPN init() {
		MoteurRPN m = new MoteurRPN();
		addCommands(m);
		return m;
	}
	
	public static void addCommands(MoteurRPN m) {
		m.addCommand("+", () -> {
			m.undoStack = m.stack;
			Double op1 = m.stack.pop();
			Double op2 = m.stack.pop();
			m.stack.push(op1 + op2);
		});
		m.addCommand("-", () -> {
			m.undoStack = m.stack;
			Double op1 = m.stack.pop();
			Double op2 = m.stack.pop();
			m.stack.push(op1 - op2);
		});
		m.addCommand("/", () -> {
			m.undoStack = m.stack;
			Double op1 = m.stack.pop();
			Double op2 = m.stack.pop();
			m.stack.push(op1 / op2);
		});
		m.addCommand("*", () -> {
			m.undoStack = m.stack;
			Double op1 = m.stack.pop();
			Double op2 = m.stack.pop();
			m.stack.push(op1 * op2);
		});
	}
	
	public void addOperande(Double op) {
		this.stack.push(op);
		this.undoStack.push(op);
		}
	
	public String toString() {
		return this.stack.toString();
	}
}
