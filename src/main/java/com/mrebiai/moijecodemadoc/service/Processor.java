package com.mrebiai.moijecodemadoc.service;

import java.io.IOException;

import com.mrebiai.moijecodemadoc.model.MaDoc;

/**
 * @author mrebiai
 */
public interface Processor {

	/**
	 * @param madoc input
	 * @return processing
	 * @throws IOException 
	 */
	MaDoc process(MaDoc madoc) throws IOException;
	
}
