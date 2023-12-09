package blog.howardli.java_external_study.pattern.factory;

public class ArcherTrainingCamp implements TrainingCamp {
    @Override
    public Adventurer trainAdventurer() {
        System.out.println("Train an archer");
        return new Archer();
    }
}
