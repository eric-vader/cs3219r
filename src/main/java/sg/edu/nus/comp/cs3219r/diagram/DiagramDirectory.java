package sg.edu.nus.comp.cs3219r.diagram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import sg.edu.nus.comp.cs3219r.AppDesignPlane;
import sg.edu.nus.comp.cs3219r.Utils;

public class DiagramDirectory {

  private Map<String, Diagram> lookup;
  private String outputDir;

  public DiagramDirectory() {

    lookup = new HashMap<String, Diagram>();
    outputDir = Utils.getAbsResourcePath(Utils.umlBasePath);

    for(AppDesignPlane eaView : Utils.listAppPlanes()) {
      if(eaView.getDiagram()!=null) 
        lookup.put(eaView.getId(), eaView.getDiagram());
    }
    
  }

  public void writeToDisk(Gson gson) throws IOException {
    for (String eaKey : lookup.keySet()) {
      Path path = Paths.get(outputDir + "/" + eaKey + ".json");
      byte[] strToBytes = gson.toJson(lookup.get(eaKey)).getBytes();
      Files.write(path, strToBytes);
    }
  }

}
