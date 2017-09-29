package sg.edu.nus.comp.cs3219r.diagram;

import java.lang.reflect.Modifier;

public enum Visibility {
  _public,
  _private,
  _protected,
  _package;
  
  public static Visibility toVisibility(int modifier) {
    if(Modifier.isPublic(modifier)) {
      return Visibility._public;
    } else if(Modifier.isPrivate(modifier)) {
      return Visibility._private;
    } else if(Modifier.isProtected(modifier)) {
      return Visibility._protected;
    } else {
      return Visibility._package;
    }
  }
}
