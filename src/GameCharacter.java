public abstract class GameCharacter {
    // 2. Immutability (konstanta global)
    public static final int MAX_LEVEL = 50;

    // 2. Immutability (atribut instans kekal)
    private final String id;

    // 3. Enkapsulasi (seluruh atribut berstatus private)
    private String name;
    private int level;
    private double health;
    private boolean isAlive;

    // 3. Overloaded Constructor 1
    public GameCharacter(String id, String name) {
        this.id = id;
        this.name = name;
        this.level = 1;
        this.health = 100.0;
        this.isAlive = true;
    }

    // 3. Overloaded Constructor 2
    public GameCharacter(String id, String name, int level, double health) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.isAlive = health > 0;
    }

    // 1. Method Prosedur (void)
    public void displayStatus() {
        System.out.println("ID: " + this.id + " | Name: " + this.name +
                " | Level: " + this.level + " | HP: " + this.health +
                " | Alive: " + this.isAlive);
    }

    // 7. Abstract Method
    public abstract void takeDamage(double damage);

    // 3. Getter & Setter (menggunakan keyword this)
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // 1. Method Fungsi (mengembalikan nilai return)
    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}