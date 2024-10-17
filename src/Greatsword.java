import java.util.Random;

// Класс Greatsword
public class Greatsword extends Weapon implements IWeapon {
    private String madeOf;
    private static final Random random = new Random(); // Статический объект для генерации случайных чисел
    private int totalDamage = 0; // Общее количество урона, нанесенного с помощью меча

    public Greatsword(int damage, int range, String madeOf) {
        super(damage, range);
        this.madeOf = madeOf;
    }

    public String getMadeOf() {
        return madeOf;
    }

    @Override
    public void Attack() {
        int hitChance = random.nextInt(20);
        int damageDealt = 0;

        if (hitChance < 5) {
            damageDealt = getDamage() / 2;
            System.out.println("Промах! Вы нанесли только " + damageDealt + " урона.");
        } else if (hitChance >= 19) {
            SpecialAttack();
            damageDealt = getDamage() * 2;
        } else {
            damageDealt = getDamage();
            System.out.println("Вы атаковали двуручным мечом и нанесли " + damageDealt + " урона.");
        }

        totalDamage += damageDealt;
        checkVictory(totalDamage);
    }

    public void SpecialAttack() {
        System.out.println("Вы провели мощную атаку двуручным мечом, нанеся " + (getDamage() * 2) + " урона!");
    }

    private void checkVictory(int totalDamage) {
        if (totalDamage >= 30) {
            System.out.println("Вы победили дракона!");
        } else {
            System.out.println("Общее количество урона: " + totalDamage);
        }
    }
}
