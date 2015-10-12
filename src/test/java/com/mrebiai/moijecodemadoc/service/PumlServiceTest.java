/**
 * 
 */
package com.mrebiai.moijecodemadoc.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import com.mrebiai.moijecodemadoc.model.MyDoc;

/**
 * @author mrebiai
 */
public class PumlServiceTest {

	private static final String INPUT = "@startuml\nBob -> Alice : hello\n@enduml\n";
	private String output;
	private PumlService service;

	
	@Test
	public void should_process_puml() throws IOException, URISyntaxException {
		// GIVEN
		service = new PumlService();
		MyDoc myDoc = new MyDoc();
		myDoc.setCode(INPUT);
		URL url = Thread.currentThread().getContextClassLoader().getResource("test.svg");
		output = new String(Files.readAllBytes(Paths.get(url.toURI())));

		// WHEN
		MyDoc result = service.process(myDoc);

		// THEN
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getResult());
		Assert.assertEquals(output, result.getResult());

	}

}
