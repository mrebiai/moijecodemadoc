package com.mrebiai.moijecodemadoc.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.mrebiai.moijecodemadoc.model.MyDoc;

/**
 * @author mrebiai
 */
public class AdocServiceTest {

	private static final String INPUT = "*Bold* _Italic_";
	private static final String OUTPUT = "<div class=\"paragraph\">\n<p><strong>Bold</strong> <em>Italic</em></p>\n</div>";

	private AdocService service;

	@Test
	public void should_process_adoc() throws IOException {
		// GIVEN
		service = new AdocService();
		MyDoc myDoc = new MyDoc();
		myDoc.setCode(INPUT);
		
		// WHEN
		MyDoc result = service.process(myDoc);
		
		// THEN
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getResult());
		Assert.assertEquals(OUTPUT, result.getResult());
	}
}