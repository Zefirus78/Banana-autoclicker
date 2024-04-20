package hw_3.part2;

import hw_3.part2.contracts.Obstacle;
import hw_3.part2.contracts.Participant;
import hw_3.part2.models.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        List<Obstacle> obstacles = new ArrayList<>();

        participants.add(new Cat("Murzik", 4, 500));
        participants.add(new Human("Mark", 1, 2000));
        participants.add(new Robot("R2-D2", 0,200));

        obstacles.add(new Wall("\"Сlimbing wall\"",12));
        obstacles.add(new TreadMill("\"Manual Threadmill\"", 4000));

        for (Participant p : participants) {
            boolean isComplete = true;
            for (Obstacle o : obstacles) {
                if(!o.overcome(p)){
                    isComplete = false;
                    System.out.println("Participant " + p.name
                            + " hasn't overcome obstacle " + o.obstacleType
                            + " on distance "
                            + o.size + "m.\n");
                    break;
                }
                else {
                    System.out.println("Participant " + p.name
                            + " has overcome obstacle " + o.obstacleType
                            + " on distance "
                            + o.size + "m.\n");
                }
            }
            if(isComplete){
                System.out.println("Participant " + p.name
                        + " has overcome all the obstacles \n");
            }
        }
    }
}
