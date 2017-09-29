package sg.edu.nus.comp.cs3219r;

public class BankAccount {

  public String owner;
  private int currency;
  protected String parent;
  int child;

  public String getOwner() {
    return owner;
  }

  private void setOwner(String owner) {
    this.owner = owner;
  }

  protected int getCurrency() {
    return currency;
  }

  void setCurrency(int currency) {
    this.currency = currency;
  }

  public String getParent() {
    return parent;
  }

  private void setParent(String parent) {
    this.parent = parent;
  }

  protected int getChild() {
    return child;
  }

  void setChild(int child) {
    this.child = child;
  }



}
