public class DataManage {
    private int num;
    private String name;
    private String regiDate;
    private String part;
    private int numOfSets;
    private int reps;
    private int weight;
    private String exercise;


    public DataManage( int num, String regiDate, String name, String part,String exercise, int numOfSets, int reps,
                       int weight){
        this.num = num;
        this.name = name;
        this. regiDate = regiDate;
        this.part = part;
        this.numOfSets = numOfSets;
        this.reps = reps;
        this.weight = weight;
        this.exercise = exercise;
    }


    @Override
    public String toString() {
        return "Schedule [ID="+((this.num+10)%10+1)+", Date="+this.regiDate +", Name="+this.name+", Part="+this.part
                +", exercise="+this.exercise +", Sets="+this.numOfSets+", reps="+this.reps+", Weight="+this.weight+"kg]";
    }

    public long getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(String regiDate) {
        this.regiDate = regiDate;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public int getNumOfSets() {
        return numOfSets;
    }

    public void setNumOfSets(int numOfSets) {
        this.numOfSets = numOfSets;
    }

    public long getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public DataManage() {

    }
}