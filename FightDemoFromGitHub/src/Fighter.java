public class Fighter {
    private final String name;
    private int health;
    private final int intelligence;
    private final boolean magic;
    private final int ability;
    private int speed;

    public Fighter(String name, int intelligence, boolean magic) {
        this.name = name;
        this.health = 20;
        this.intelligence = intelligence;
        this.magic = magic;
        this.ability = abilityCount();
        this.speed = speedCount();
    }

    public int abilityCount() {
        // способности персонажей
        return intelligence * ((magic) ? 20 : 10);
    }

    public int speedCount() {
        //скорость персонажей - определяет очерёдность хода в бою
        return health * (ability - ((magic) ? 15 : 0));
    }

    protected boolean isAlive() {
        return (health > 0);
    }

    public boolean makeDamage(Fighter otherFighter) {
        return otherFighter.getDamage(this);
    }

    private boolean getDamage(Fighter hittingFighter) {
        if (hittingFighter.ability <= ability) {
            health -= (hittingFighter.speed <= speed) ? 5 : hittingFighter.speed - speed;
        } else
            health -= hittingFighter.ability - ability;
        if (health < 0)
            health = 0;
        speed = speedCount();
        return true;
    }

    @Override
    public String toString() {
        return String.format("Герой %s (%s)", name, health);
    }
}
