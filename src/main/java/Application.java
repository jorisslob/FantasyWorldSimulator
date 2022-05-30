import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Application {
    private final Set<Agent> agentSet = new HashSet<>();

    public static void main(String[] args) {
        Application app = new Application();
        app.setup();
        app.run();
    }

    private void setup() {
        // Read initial state from configuration file
        InputStream inputStream = getClass().getResourceAsStream("/config.txt");
        assert inputStream != null;
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        for(String line: br.lines().toArray(String[]::new)) {
            System.out.println(line);
            if(line.equals("hunter")) {
                System.out.println();
                agentSet.add(new Hunter());
            }
        }
    }

    private void run() {
        while (!agentSet.isEmpty()) {
            for (Agent agent : agentSet) {
                agent.act();
            }
            agentSet.removeIf(Agent::isDead);
        }
    }
}
