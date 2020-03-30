
public class MoteurRPN extends Interpreteur {
	public MoteurRPN() {
		super();
		addCommands(this);
	}
	
	public void addCommands(MoteurRPN m) {
		m.addCommand("+", () -> {
			clearSave();
			Double op1 = m.stack.pop();
			Double op2 = m.stack.pop();
			m.stack.push(op1 + op2);
		});
		m.addCommand("-", () -> {
			clearSave();
			Double op1 = m.stack.pop();
			Double op2 = m.stack.pop();				
			m.stack.push(op1 - op2);	
			
			
		});
		m.addCommand("/", () -> {
			try {		
				clearSave();
				Double op1 = m.stack.pop();
				Double op2 = m.stack.pop();
				if(op2 == 0) {
					m.stack.push(op2);
					m.stack.push(op1);
					throw new DivisionZeroException();
				}				
				else {
					m.stack.push(op1 / op2);
				}		
			} catch (DivisionZeroException d) {}
		});
		m.addCommand("*", () -> {
			clearSave();
			Double op1 = m.stack.pop();
			Double op2 = m.stack.pop();
			m.stack.push(op1 * op2);
		});
	}
	
	public void addOperande(Double op) {
		clearSave();
		this.stack.push(op);
	}
	public void clearSave() {
		this.undoStack.clear();
		this.undoStack.addAll(this.stack);
	}
	public String toString() {
		return this.stack.toString();
	}
	
	public String toStringUndo() {
		return this.undoStack.toString();
	}
}
