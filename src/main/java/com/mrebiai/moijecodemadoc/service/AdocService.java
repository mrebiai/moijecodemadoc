package com.mrebiai.moijecodemadoc.service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;

import com.mrebiai.moijecodemadoc.model.MyDoc;

/**
 * @author mrebiai
 */
public class AdocService implements Processor {
	
	private static Asciidoctor asciidoctor = Asciidoctor.Factory.create();
	
	/**
	 * @throws IOException 
	 * @see com.mrebiai.moijecodemadoc.service.Processor#process(com.mrebiai.moijecodemadoc.model.MyDoc)
	 */
	@Override
	public MyDoc process(MyDoc madoc) throws IOException {
		Attributes attributes = new Attributes();
		attributes.setBackend("html5");

		Reader reader = new StringReader(madoc.getCode());
		
		Options options = new Options();
		options.setAttributes(attributes);
		attributes.setShowTitle(true);
		options.setInPlace(true);
		
		StringWriter writer = new StringWriter();

		asciidoctor.convert(reader, writer, options);

		StringBuffer htmlBuffer = writer.getBuffer();
		writer.flush();
		String result = htmlBuffer.toString();
		reader.close();
		writer.close();
		madoc.setResult(result);
		return madoc;
	}
}
