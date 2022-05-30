public class Hunter implements Agent {
    int age = 0;
    private boolean alive = true;

    @Override
    public void act() {
        System.out.println("I'm hunting!");
        age++;
        if(age > 10) {
            System.out.println("I'm dead!");
            alive = false;
        }
    }

    public boolean isDead() {
        return !alive;
    }
}
