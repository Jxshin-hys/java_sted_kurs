import java.util.Objects;
import java.util.Scanner;

// Класс Main
public class Main {
    static Scanner console = new Scanner(System.in);
    static String currentKey;

    public static void main(String[] args) {
        Spear spear = new Spear(6, 4);
        Greatsword sword = new Greatsword(10, 2, "Железный");

        while (!Objects.equals(currentKey, "C")) {
            System.out.println("Какое оружие использовать для атаки? 1 - Копье // 2 - Железный двуручный меч // C - Сбежать");
            currentKey = console.nextLine();

            if (Objects.equals(currentKey, "1")) {
                battleActionSpear(spear, sword);
            } else if (Objects.equals(currentKey, "2")) {
                battleActionGreatsword(sword,spear);
            }
        }

        System.out.println("Ты не рыцарь. И даже не гладиатор.");
    }

    public static void battleActionSpear(Spear spear, Greatsword sword) {
        System.out.println("Вы взяли копье. Что будете делать? 1 - Метнуть // 2 - Ударить // R - Выбрать другое оружие");
        currentKey = console.nextLine();
        switch (currentKey) {
            case "1":
                if (!spear.isThrown()) {
                    spear.Throw();
                    promptNextAction(spear,spear,sword);
                } else {
                    System.out.println("У вас нету копья.");
                    promptNextAction(sword,spear,sword);
                }
                break;

            case "2":
                if (spear.isThrown()) {
                    System.out.println("У вас нету копья.");
                    promptNextAction(sword,spear,sword);
                } else {
                    spear.Attack();
                    promptNextAction(spear,spear,sword);
                }
                break;

            case "R":
                currentKey = null;
                break;

            default:
                System.out.println("Неверная команда. Попробуйте снова.");
        }
    }

    public static void battleActionGreatsword(Greatsword sword,Spear spear) {
        System.out.println("Вы взяли двуручный меч. Что будете делать? 1 - Ударить // 2 - Особая атака // R - Выбрать другое оружие");
        currentKey = console.nextLine();
        switch (currentKey) {
            case "1":
                sword.Attack();
                promptNextAction(sword,spear,sword);
                break;
            case "2":
                sword.SpecialAttack();
                promptNextAction(sword,spear,sword);
                break;
            case "R":
                currentKey = null;
                break;
            default:
                System.out.println("Неверная команда. Попробуйте снова.");
        }
    }

    private static void promptNextAction(Weapon weapon, Spear spear, Greatsword sword) {

        if (weapon instanceof Spear) {
            System.out.println("Что будете делать дальше? 1 - Метнуть (если это копье) // 2 - Ударить (если это меч) // R - Выбрать другое оружие");
            currentKey = console.nextLine();
            if (currentKey.equals("1")) {
                spear.Throw();
            } else if (currentKey.equals("2")) {
                spear.Attack();
            }
        } else if (weapon instanceof Greatsword) {
            System.out.println("Что будете делать дальше? 1 - Ударить // 2 - Особая атака // R - Выбрать другое оружие");
            currentKey = console.nextLine();
            if (currentKey.equals("1")) {
                sword.Attack();
            } else if (currentKey.equals("2")) {
                sword.SpecialAttack();
            }
        }
    }
}
