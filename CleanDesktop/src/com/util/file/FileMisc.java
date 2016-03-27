package com.util.file;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMisc {

	public String srcMove;
	public String nameFolderIni;

	public FileMisc() {
		nameFolderIni="CleanDesktop";
	}

	public boolean createFolder(String path, String name) {
		boolean response = false;
		path = changeNamePath(path);

		File dir = new File(path + name);
		if (!dir.exists()) {
			response = dir.mkdir();
		}
		srcMove = dir.getPath();
		return response;
	}

	public String getPath() throws IOException {
		String path = "";
		path = new java.io.File(".").getCanonicalPath();
		return path;
	}

	public String changeNamePath(String path) {
		if (path != null) {
			path = path.replace("\\", "/");
			if (!path.substring(path.length() - 1).equals("\\")) {
				path = path + "/";
			}
		} else {
			path = "";
		}
		return path;
	}

	public boolean moveFile(String srcOld, String srcNew, String nameFile) {
		boolean response = false;
		srcOld = changeNamePath(srcOld) + nameFile;
		srcNew = changeNamePath(srcNew) + nameFile;
		File afile = new File(srcOld);
		if (afile.getName().indexOf(".lnk") == -1
				&& afile.getName().indexOf(".jar") == -1&&!afile.getName().startsWith(nameFolderIni)) {
			response = afile.renameTo(new File(srcNew));
		}
		return response;
	}

	public File[] getListFiles(String src) {
		File[] ficheros = null;
		File f = new File(src);
		if (f.exists()) {
			ficheros = f.listFiles();
		}
		return ficheros;
	}

	public String buildNameFolder() {
		String dir = nameFolderIni;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		dir += dateFormat.format(date);
		return dir;
	}
}
