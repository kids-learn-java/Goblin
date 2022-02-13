public class Being {
    public Being(String theName, int theLife, int theAttack, int theDefense) {
        name = theName;
        life = theLife;
        attack = theAttack;
        defense = theDefense;
    }

    public int getAttack() {
        return isLive() ? attack : 0;
    }

    public String toString() {
        return String.format("%s life=%d attack=%d defense=%d",
            name, life, attack, defense);
    }

    public boolean isLive() {
        return life > 0;
    }

    public void takeDamage(int attackPower) {
        if (attackPower > defense) {
            attackPower -= defense;
        } else {
            return;
        }
        if (attackPower > life) {
            life = 0;
        } else {
            life -= attackPower;
        }
    }

    protected String name;
    protected int life;
    protected int attack;
    protected int defense;
}
