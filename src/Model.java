import java.util.Observable;

class Model extends Observable {
  private double bel�b;
  
  public Model() {
    bel�b = 0;
  }
  
  public void set( double bel�b ) {
    this.bel�b = bel�b;
    
    fire();
  }
  
  public double get() {
    return bel�b;
  }
  
  private void fire() {
    setChanged();
    notifyObservers();
  }
}