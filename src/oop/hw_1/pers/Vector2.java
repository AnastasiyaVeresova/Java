package oop.hw_1.pers;

public class Vector2 {
    int posX, posY;

    public Vector2(int posX, int posY) {

        this.posX = posX;
        this.posY = posY;

    }

    @Override
    public String toString() {
        return "Position(" + posX + ", " + posY + "; " + (float) Math.sqrt(Math.pow(posX + posY, 2)) +")";
//          return "Position(" + posX + ", " + posY;

    }

    public float rangeEnemy(Vector2 posEnemy) {
        double distance = (Math.sqrt(Math.pow(posEnemy.posY - posY, 2) + Math.pow(posEnemy.posX - posX, 2)));

        return (float) distance;
    }


}
