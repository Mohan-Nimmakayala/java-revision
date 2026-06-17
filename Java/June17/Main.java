public class Main {
    public static void main(String[] args) {
        System.out.println("=== Default Constructor ===");
        BankAccount defaultAcc = new BankAccount();
        defaultAcc.display();

        System.out.println("=== Parameterized Constructor ===");
        BankAccount acc1 = new BankAccount("ACC001", "Mohan", 5000.0);
        acc1.display();

        System.out.println("=== Fluent Chaining (return this) ===");
        acc1.deposit(1000).deposit(500).withdraw(200);
        acc1.display();

        System.out.println("=== Copy Constructor (deep copy) ===");
        BankAccount acc2 = new BankAccount(acc1);
        acc2.deposit(9999);
        System.out.println("acc2 after deposit:");
        acc2.display();
        System.out.println("acc1 unchanged (proves deep copy):");
        acc1.display();

        System.out.println("=== this as argument (Use #3) ===");
        AuditService auditService = new AuditService();
        acc1.register(auditService);

        System.out.println("=== 2-arg Constructor (telescoping) ===");
        BankAccount acc3 = new BankAccount("ACC003", "Ravi");
        acc3.display();

        System.out.println("=== Validation Guard ===");
        try {
            BankAccount invalid = new BankAccount("ACC004", "Test", -500.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}
