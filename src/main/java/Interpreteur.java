import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Interpreteur {
	private final Map<String, Command> commands;
	private Stack<Double> stack;
	private Stack<Double> undoStack;
	
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
			this.stack = undoStack;
			
		});
		i.addCommand("qui", () -> {
			System.out.println("Fin du programme.");
			System.exit(0);
		});
		
	}
	
}
