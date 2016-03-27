package com.principal;

import java.io.IOException;

import com.view.Clean;

public class MainTest {

	public static void main(String[] args) {
		try {
			Clean clean = new Clean();
			clean.clean();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
