// 4. Inheritance (Subclass 2)
public class Mage extends GameCharacter implements Attacker {
    private double mana;

    // 5. Super Chaining
    public Mage(String id, String name) {
        super(id, name);
        this.mana = 50.0;
    }

    public Mage(String id, String name, int level, double health, double mana) {
        super(id, name, level, health);
        this.mana = mana;
    }

    // 5. Super Chaining & 6. Method Overriding
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Role: Mage | Mana: " + this.mana);
    }

    // 6. Method Overriding & 8. Logika State Percabangan
    @Override
    public void takeDamage(double damage) {
        if (!isAlive()) {
            System.out.println(getName() + " sudah tewas!");
            return;
        }

        double currentHealth = getHealth() - damage;
        if (currentHealth <= 0) {
            setHealth(0);
            setAlive(false);
            System.out.println(getName() + " menerima damage " + damage + " dan tewas!");
        } else {
            setHealth(currentHealth);
            System.out.println(getName() + " menerima damage " + damage + ". Sisa HP: " + currentHealth);
        }
    }

    @Override
    public void attack(GameCharacter target) {
        if (this.mana >= 15.0) {
            this.mana -= 15.0;
            System.out.println(getName() + " melempar bola api ke " + target.getName() + "!");
            target.takeDamage(45.0);
        } else {
            System.out.println(getName() + " tidak memiliki cukup mana untuk menyerang!");
        }
    }

    public double getMana() {
        return this.mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }
}