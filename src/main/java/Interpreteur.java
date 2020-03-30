import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreteur {
	protected final Map<String, Command> commands;
	protected Stack<Double> stack;
	protected Stack<Double> undoStack;
	
	public Interpreteur() {
		this.commands = new HashMap<>();
		this.stack = new Stack<Double>();
		this.undoStack = new Stack<Double>();
		init(this);
	}
	
	public void addCommand(String name, Command command) {
		this.commands.put(name, command);
	}
	
	public void executeCommand(String name) {
		if (this.commands.containsKey(name)) {
			this.commands.get(name).apply();
		}
	}
	
	public void init(Interpreteur i) {
		i.addCommand("undo", () -> {
			this.stack.clear();
			this.stack.addAll(this.undoStack);
			
			
		});
		i.addCommand("quit", () -> {
			System.out.println("Fin du programme.");
			System.exit(0);
		});
		
	}
	
}
