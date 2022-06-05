public class Hunter implements Agent {
    int age = 0;
    private boolean alive = true;
    public enum State {
        HUNTING,
        EATING,
        SLEEPING
    }
    private State state = State.HUNTING;

    @Override
    public void act() {
        switch (state) {
            case HUNTING -> hunt();
            case EATING -> eat();
            case SLEEPING -> sleep();
        }
        age++;
        if(age > 10) {
            System.out.println("I'm dead!");
            alive = false;
        }
    }

    private void sleep() {
        System.out.println("I'm sleeping");
        state = State.HUNTING;
    }

    private void eat() {
        System.out.println("I'm eating");
        state = State.SLEEPING;

    }

    private void hunt() {
        System.out.println("I'm hunting");
        state = State.EATING;

    }

    public boolean isDead() {
        return !alive;
    }
}
