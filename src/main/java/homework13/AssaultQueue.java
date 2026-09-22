package homework13;

import java.util.LinkedList;
import java.util.List;

public class AssaultQueue {
    LinkedList<String> queue = new LinkedList<>();

    @Override
    public String toString() {
        return "AssaultQueue{" +
                "queue=" + queue +
                '}';
    }

    public void addRecruit(String name){
        queue.addLast(name);
    }

    public void retreatCoward(){
        System.out.println(queue.getFirst());
        queue.removeFirst();
    }
    public void printQueue(){
        System.out.println(queue);
    }
}
