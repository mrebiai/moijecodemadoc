package moijecodemadoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import javax.imageio.stream.FileImageInputStream;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;

import static org.asciidoctor.OptionsBuilder.options;
import static org.asciidoctor.AttributesBuilder.attributes;

public class AsciidoctorJTest {


	private static Asciidoctor asciidoctor = Asciidoctor.Factory.create();

//	@Rule
//	public ClasspathResources classpath = new ClasspathResources();

//	@Test
//	public void png_should_be_rendered_for_diagram() {
	public static void main(String... strings) throws IOException {
		File inputFile = new File("src/test/resources/sample.adoc");
//		File outputFile1 = new File(inputFile.getParentFile(), "asciidoctor-diagram-process.png");
//		File outputFile2 = new File(inputFile.getParentFile(), "asciidoctor-diagram-process.png.cache");
//		asciidoctor.requireLibrary("asciidoctor-diagram");
		
		Attributes attributes = new Attributes();
		attributes.setBackend("html5");

		Options options = new Options();
		options.setAttributes(attributes);
		options.setInPlace(true);

		FileReader reader = new FileReader(inputFile);
		StringWriter writer = new StringWriter();

		asciidoctor.convert(reader, writer, options);

		StringBuffer htmlBuffer = writer.getBuffer();
		System.out.println(htmlBuffer.toString());
	}
}
