/**
 * 
 */
package com.mrebiai.moijecodemadoc.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.mrebiai.moijecodemadoc.model.MaDoc;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

/**
 * @author mrebiaiO
 * @see http://fr.plantuml.com/api.html
 */
public class PumlService implements Processor {

	@Override
	public MaDoc process(MaDoc madoc) throws IOException {

		// SVG
		SourceStringReader reader = new SourceStringReader(madoc.getCode());
		final ByteArrayOutputStream os = new ByteArrayOutputStream();
		// Write the first image to "os"
		reader.generateImage(os, new FileFormatOption(FileFormat.SVG));
		os.close();
		// The XML is stored into svg
		String svg = new String(os.toByteArray());
		madoc.setResult(svg);
		return madoc;
	}

}
