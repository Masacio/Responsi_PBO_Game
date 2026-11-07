// 4. Class Main dipisahkan dari class lainnya
public class Main {
    public static void main(String[] args) {
        System.out.println("=== PEMBUATAN OBJEK & OVERLOADED CONSTRUCTOR ===");
        Warrior warrior = new Warrior("W01", "Arthur", 1, 100.0, 10.0);
        Mage mage = new Mage("M01", "Merlin");

        warrior.displayStatus();
        System.out.println("-----------------------------------");
        mage.displayStatus();

        System.out.println("\n=== UPGRADE & UPDATE STATE (UPGRADABLE) ===");
        warrior.upgrade();
        warrior.displayStatus();

        System.out.println("\n=== POLIMORFISME INTERFACE (Attacker) ===");
        // 9. Polimorfisme Interface
        Attacker attacker1 = warrior;
        Attacker attacker2 = mage;

        attacker1.attack(mage);
        System.out.println("-----------------------------------");
        attacker2.attack(warrior);

        System.out.println("\n=== LOGIKA STATE PERCABANGAN (AKSI SERANGAN BERUNTUN) ===");
        mage.takeDamage(60.0);
        mage.takeDamage(50.0); // Menguji logika state saat HP mencapai 0

        System.out.println("\n=== STATUS AKHIR OBJEK ===");
        warrior.displayStatus();
        mage.displayStatus();
    }
}