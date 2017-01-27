package collectorgame.collectorgame;

public class Player {

    public int score;
    public int x;
    public int y;

    public Player() {
        this.x = 1;
        this.y = 0;
        this.score = 0;
    }

    public String getLocation() {
        return this.x + "," + this.y;
    }

    public void movePlayerLeft() {
        if (this.x - 1 >= 0) {
            this.x -= 1;
        }
    }

    public void movePlayerRight() {
        if (this.x + 1 <= 22) {
            this.x += 1;
        }
    }

    public void movePlayerUp() {
        if (this.y - 1 >= 0) {
            this.y -= 1;
        }
    }

    public void movePlayerDown() {
        if (this.y + 1 <= 11) {
            this.y += 1;
        }
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int score) {
        if (score < 0 && this.score + score < 0) {
            this.score = 0;
        } else {
            this.score += score;
        }
    }
}
