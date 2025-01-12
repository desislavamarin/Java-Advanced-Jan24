package spaceCrafts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.capacity > this.spacecrafts.size()) {
            this.spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    public boolean removeSpacecraft(String name) {
        return this.spacecrafts.removeIf(spacecraft ->
                spacecraft.getName().equals(name));
    }

    public String getHeaviestSpacecraft() {
        Spacecraft spacecraft = this.spacecrafts.stream()
                .max(Comparator.comparing(Spacecraft::getWeight))
                .orElse(null);
        return String.format("%s - %dkg.", spacecraft.getName(), spacecraft.getWeight());
    }

    public Spacecraft getSpacecraft(String name) {
       return this.spacecrafts.stream()
                .filter(craft -> craft.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> spacecraftList = new ArrayList<>();
        for (Spacecraft spaceCraft : this.spacecrafts) {
            if (spaceCraft.getMissionType().equals(missionType)) {
                spacecraftList.add(spaceCraft);
            }
        }
        if (spacecraftList.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return spacecraftList;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Spacecrafts launched from " + this.name + ":").append(System.lineSeparator());
        this.spacecrafts.forEach(s -> sb.append(s.toString()).append(System.lineSeparator()));

        return sb.toString();
    }
}
