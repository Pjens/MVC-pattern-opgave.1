import java.util.Observable;

class Model extends Observable {
  private double beløb;
  
  public Model() {
    beløb = 0;
  }
  
  public void set( double beløb ) {
    this.beløb = beløb;
    
    fire();
  }
  
  public double get() {
    return beløb;
  }
  
  private void fire() {
    setChanged();
    notifyObservers();
  }
}