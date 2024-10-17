public abstract class Weapon {
    private int range;
    private int damage;
    private static int weaponCount = 0;

    public Weapon(int damage, int range) {
        this.damage = damage;
        this.range = range;
        weaponCount++;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public static int getWeaponCount() {
        return weaponCount;
    }
}
