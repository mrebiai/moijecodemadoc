/**
 * 
 */
package moijecodemadoc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

/**
 * @author mrebiaiO
 * @see http://fr.plantuml.com/api.html
 */
public class PlantUMLTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String source = "@startuml\n";
		source += "Bob -> Alice : hello\n";
		source += "@enduml\n";

		// PNG
		{
			OutputStream png = new FileOutputStream(new File("/home/mrebiai/test.png"));
			SourceStringReader reader = new SourceStringReader(source);
			// Write the first image to "png"
			String desc = reader.generateImage(png);
			System.out.println(desc);
		}

		// SVG
		{
			SourceStringReader reader = new SourceStringReader(source);
			final ByteArrayOutputStream os = new ByteArrayOutputStream();
			// Write the first image to "os"
			String desc = reader.generateImage(os, new FileFormatOption(FileFormat.SVG));
			os.close();
			System.out.println(desc);

			// The XML is stored into svg
			final String svg = new String(os.toByteArray(), Charset.forName("UTF-8"));
			System.out.println(svg);
		}

	}

}
