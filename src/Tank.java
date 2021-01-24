public class Tank {
    private int posX, posY, direction;
    /* direction:
    0 - right
    1 - down
    2 - left
    3 - up
     */
    private int fuel;
    private static String model = "T34";
    private static int tankCount = 0;
    private int tankNumber;

    public Tank() {
        this(0, 0, 0, 100);
    }

    public Tank(int posX, int posY) {
        this(posX, posY, 0, 100);
    }

    public Tank(int posX, int posY, int fuel) {
        this(posX, posY, 0, fuel);
    }

    public Tank(int posX, int posY, int direction, int fuel) {
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        this.fuel = fuel;
        tankNumber = ++tankCount;
    }

    public void goForward(int delta) {
        if (delta < 0 ) {
            if (-delta > fuel) { delta = -fuel; }
        } else {
            if (delta > fuel) { delta = fuel; }
        }
        switch (direction) {
            case 0:
                posX += delta;
                break;
            case 1:
                posY += delta;
                break;
            case 2:
                posX -= delta;
                break;
            case 3:
                posY -= delta;
                break;
        }
        fuel -= Math.abs(delta);
    }

    public void goBackward(int delta) {
        goForward(-delta);
    }

    public void turnRight(){
        direction++;
        if (direction > 3) {
            direction = 0;
        }
    }

    public void turnLeft(){
        direction--;
        if (direction < 0) {
            direction = 3;
        }
    }
    public void printPosition() {
        // The Tank is at 10, 0 now.
        System.out.printf("The Tank %s-%d is at %d, %d now.\n", model, tankNumber, posX, posY);
    }
}
