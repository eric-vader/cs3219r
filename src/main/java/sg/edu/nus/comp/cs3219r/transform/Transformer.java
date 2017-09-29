package sg.edu.nus.comp.cs3219r.transform;

public abstract class Transformer<T extends TransformableData> {
  
  private T data;
  
  public Transformer(T data) {
    this.data = data;
  }
  
  public abstract String toHtml();
  
}
