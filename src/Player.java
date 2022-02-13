public class Player extends Being {
    public Player(String theName, int theLife, int theAttack, int theDefense) {
        super(theName, theLife, theAttack, theDefense);
        inAttackMode = false;
    }

    public void SetMode(boolean newInAttackMode) {
        if (inAttackMode == newInAttackMode) {
            return;
        }
        if (newInAttackMode) {
            super.attack *= 2;
            super.defense /= 2;
        } else {
            super.attack /= 2;
            super.defense *= 2;
        }
        inAttackMode = newInAttackMode;
    }

    private boolean inAttackMode;
    public float attack;
}
