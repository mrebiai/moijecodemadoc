package com.mrebiai.moijecodemadoc.service;

import java.io.IOException;

import com.mrebiai.moijecodemadoc.model.MyDoc;

/**
 * @author mrebiai
 */
public interface Processor {

	/**
	 * @param madoc input
	 * @return processing
	 * @throws IOException 
	 */
	MyDoc process(MyDoc madoc) throws IOException;
	
}
