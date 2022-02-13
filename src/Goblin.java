public class Goblin extends Being {
    public Goblin(String theName, int theLife, int theAttack, int theDefense, float theArmor) {
        super(theName, theLife, theAttack, theDefense);
        armor = theArmor;
        assert armor > 0 && armor <= 1;
    }

    @Override
    public void takeDamage(int attackPower) {
        attackPower *= armor;
        super.takeDamage(attackPower);
    }

    @Override
    public String toString() {
        return String.format("%s armor=%.2f", super.toString(), armor);
    }

    protected float armor;
}
