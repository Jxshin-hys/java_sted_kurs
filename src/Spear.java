import java.util.Random;

// Класс Spear
public class Spear extends Weapon implements IThrowing, IWeapon {
    private static final Random random = new Random(); // Статический объект для генерации случайных чисел
    private boolean isThrown = false; // Флаг для отслеживания, было ли выкинуто копье
    private int totalDamage = 0; // Общее количество урона

    public Spear(int damage, int range) {
        super(damage, range);
    }

    @Override
    public void Throw() {
        if (isThrown) {
            System.out.println("Вы уже выкинули копье и не можете им больше пользоваться.");
        } else {
            System.out.println("Вы метнули копье. И нанесли" + getRange() + " урона.");
            isThrown = true;
        }
    }

    @Override
    public void Attack() {
        int hitChance = random.nextInt(20);
        int damageDealt = 0;

        if (hitChance < 5) {
            damageDealt = getDamage() / 2;
            System.out.println("Промах! Вы нанесли только " + damageDealt + " урона.");
        } else if (hitChance >= 19) {
            damageDealt = getDamage() * 2;
            System.out.println("Случайная специальная атака! Вы нанесли " + damageDealt + " урона.");
        } else {
            damageDealt = getDamage();
            System.out.println("Вы атаковали копьем и нанесли " + damageDealt + " урона.");
        }

        totalDamage += damageDealt; // Добавляем урон к общему количеству
        checkVictory(totalDamage); // Проверка на победу
    }

    private void checkVictory(int totalDamage) {
        if (totalDamage >= 30) {
            System.out.println("Вы победили дракона!");
        } else {
            System.out.println("Общее количество урона: " + totalDamage);
        }
    }

    public boolean isThrown() {
        return isThrown;
    }
}
