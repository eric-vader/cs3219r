package sg.edu.nus.comp.cs3219r;

import java.io.IOException;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import sg.edu.nus.comp.cs3219r.template.Markdown;

public class TestMarkdownRender {
  public static void main(String[] args) throws IOException {

    Markdown md = new Markdown("test.md");
    System.out.println(md.value());
    
  }
}
