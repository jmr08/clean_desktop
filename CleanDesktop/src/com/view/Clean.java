package com.view;

import java.io.File;
import java.io.IOException;

import com.util.file.FileMisc;

public class Clean {

	public Clean() {
		// TODO Auto-generated constructor stub
	}

	public void clean() throws IOException {
		FileMisc cl = new FileMisc();
		String sDirectorio = cl.getPath();
		//Create Directory / folder where will move the desktop files
		cl.createFolder(sDirectorio, cl.buildNameFolder());
		// List Files to move
		File[] ficheros = cl.getListFiles(sDirectorio);
		for (int x = 0; x < ficheros.length; x++) {
			//Move Files
			cl.moveFile(sDirectorio, cl.srcMove, ficheros[x].getName());
		}
	}

}
