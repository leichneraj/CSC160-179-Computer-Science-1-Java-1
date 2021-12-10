public class Player {

    private int score = 0;
    private String name = null;
    
    public Player(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public String getName() { return this.name; }
    public int getScore() { return this.score; }

    public void addRoll(int roll) { this.score += roll; }
    public void setScore(int newScore) { this.score = newScore; }

}
