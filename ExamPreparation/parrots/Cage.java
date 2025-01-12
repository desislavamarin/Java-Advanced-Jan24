package ExamPreparation.parrots;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.capacity > this.data.size()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot1 = this.data.stream()
                .filter(parrot -> parrot.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (null != parrot1) {
            parrot1.setAvailable(false);
        }

        return parrot1;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrotsBySpecies = this.data.stream()
                .filter(p -> p.getSpecies().equals(species))
                .collect(Collectors.toList());

        parrotsBySpecies.forEach(p -> p.setAvailable(false));

        return parrotsBySpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        List<Parrot> unsoldParrots = this.data.stream()
                .filter(Parrot::isAvailable)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:", this.name));
        unsoldParrots.forEach(parrot -> {
            sb.append(System.lineSeparator());
            sb.append(parrot);
        });

        return sb.toString();
    }
}
