package net.safty.model;

public class CurrentAccount extends BankAccount{

   private double overdDraft;

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String currency, double initbalance, double overdDraft) {
        super(currency, initbalance);
        this.overdDraft = overdDraft;
    }

    @Override
    public String toString() {
        return "Current Account, { OverDraft ="+ overdDraft +super.toString();
    }

    @Override
    public String getType() {
        return "CURRENT_ACCOUNT";
    }

    public double getOverdDraft() {
        return overdDraft;
    }

    public void setOverdDraft(double overdDraft) {
        this.overdDraft = overdDraft;
    }
}
