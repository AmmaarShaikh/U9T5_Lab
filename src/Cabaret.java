import java.util.ArrayList;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name){
        this.name = name;
        performers = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public ArrayList getPerformers(){
        return performers;
    }

    public boolean addPerformer(Performer performer){
        boolean isPresent = false;
        for (int i = 0; i < performers.size(); i++){
            if (performers.get(i).getName().equals(performer.getName())){
                isPresent = true;
            }
        }
        if (!isPresent){
            performers.add(performer);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removePerformer(Performer performer){
        for (int i = 0; i < performers.size(); i++){
            if (performers.get(i).getName().equals(performer.getName())){
                performers.remove(i);
                return true;
            }
        }
        return false;
    }

    public double averagePerformerAge(){
        double total = 0;
        for (Performer performer : performers){
            total += performer.getAge();
        }
        return (total / performers.size());
    }

    public ArrayList performersOverAge(int age){
        ArrayList<Performer> overAge = new ArrayList<>();
        for (Performer performer : performers){
            if (performer.getAge() >= age){
                overAge.add(performer);
            }
        }
        return overAge;
    }

    public void groupRehearsal(){
        for (Performer performer : performers){
            System.out.println("REHEARSAL CALL! " + performer.getName());
            performer.rehearse();
        }
    }

    public void cabaretShow(){
        for (Performer performer : performers){
            System.out.println("Welcome to the cabaret! Next act up... " + performer.getName());
            if (performer instanceof Dancer){
                Dancer temp = (Dancer)performer;
                temp.pirouette(2);
            }
            performer.perform();
        }
    }
}
