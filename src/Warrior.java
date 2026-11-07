// 4. Inheritance & 10. Multiple Interface (implements Attacker, Upgradable)
public class Warrior extends GameCharacter implements Attacker, Upgradable {
    private double shieldPower;

    // 5. Super Chaining (pemanggilan super(...) pada konstruktor)
    public Warrior(String id, String name) {
        super(id, name);
        this.shieldPower = 20.0;
    }

    public Warrior(String id, String name, int level, double health, double shieldPower) {
        super(id, name, level, health);
        this.shieldPower = shieldPower;
    }

    // 5. Super Chaining (pemanggilan super.namaMethod()) & 6. Method Overriding
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Role: Warrior | Shield Power: " + this.shieldPower);
    }

    // 6. Method Overriding & 8. Logika State Percabangan (if/else membaca & mengubah state internal)
    @Override
    public void takeDamage(double damage) {
        if (!isAlive()) {
            System.out.println(getName() + " sudah tewas dan tidak bisa diserang.");
            return;
        }

        double netDamage = damage - this.shieldPower;
        if (netDamage < 0) {
            netDamage = 0;
        }

        double currentHealth = getHealth() - netDamage;
        if (currentHealth <= 0) {
            setHealth(0);
            setAlive(false);
            System.out.println(getName() + " menerima damage " + netDamage + " dan telah tewas!");
        } else {
            setHealth(currentHealth);
            System.out.println(getName() + " menerima damage " + netDamage + ". Sisa HP: " + currentHealth);
        }
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " menebas " + target.getName() + " dengan pedang!");
        target.takeDamage(35.0);
    }

    @Override
    public void upgrade() {
        if (getLevel() < MAX_LEVEL) {
            setLevel(getLevel() + 1);
            this.shieldPower += 5.0;
            System.out.println(getName() + " naik ke level " + getLevel() + "! Shield bertambah menjadi " + this.shieldPower);
        } else {
            System.out.println(getName() + " sudah mencapai level maksimum.");
        }
    }

    public double getShieldPower() {
        return this.shieldPower;
    }

    public void setShieldPower(double shieldPower) {
        this.shieldPower = shieldPower;
    }
}