package blog.howardli.java_external_study.pattern.factory;

public class TrainingCampDemo {
    public static void main(String[] args) {
        TrainingCamp camp = new ArcherTrainingCamp();
        Adventurer memberA = camp.trainAdventurer();
        System.out.println(memberA.getType());

        camp = new WarriorTrainingCamp();
        Adventurer memberB = camp.trainAdventurer();
        System.out.println(memberB.getType());
    }
}
