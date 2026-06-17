public class AuditService {
    public void track(BankAccount account) {
        System.out.println("Tracking account: "+account.getAccountNumber()+" | Holder: "+account.getHolderName());
    }
}
