package blog.howardli.java_external_study.pattern.factory;

public class WarriorTrainingCamp implements TrainingCamp {
    @Override
    public Adventurer trainAdventurer() {
        System.out.println("Train an warrior");
        return new Warrior();
    }
}
