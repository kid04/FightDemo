import java.util.HashMap;
import java.util.Map;

public class Team {
    private final String teamName;
    private Map<Integer, Fighter> pers = new HashMap<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public Fighter addFighter(Fighter fighter) {
        return (pers.isEmpty()) ? pers.put(1, fighter) : pers.put(pers.size() + 1, fighter);
    }

    public Fighter checkLastFighter() {
        int i = 0;
        Fighter lastAliveFighter = null;
        for (Fighter f : pers.values())
            if (f.isAlive()) {
                lastAliveFighter = f;
                i++;
            }
        if (i == 1)
            return lastAliveFighter;
        return null;
    }

    public boolean allDead() {
        for (Fighter f : pers.values())
            if (f.isAlive())
                return false;
        return true;
    }

    public Fighter chooseFighter(int choice) {
        return pers.get(choice);
    }

    @Override
    public String toString() {
        StringBuilder all = new StringBuilder();
        for (Map.Entry<Integer, Fighter> kv : pers.entrySet())
            if (kv.getValue().isAlive())
                all.append(kv.getKey()).append(". ").append(kv.getValue()).append("\n");
        return all.toString();
    }
}
