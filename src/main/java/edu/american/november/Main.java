package edu.american.november;

import java.io.FileInputStream;
import java.io.InputStream;

import edu.american.november.Assembler.Assembler;

public class Main {
	private static final String TEST_FILE = "lists.test";

	public static void main(String...args) {
		String sourceName;
		InputStream stream;
		
		CompileStep compiler;

		try {

			//Get input
			if (args.length > 0) {
				stream = new FileInputStream(args[0]);
				sourceName = args[0];
			} else {
				stream = Main.class.getClassLoader().getResourceAsStream(TEST_FILE);
				sourceName = TEST_FILE;
			}
			System.out.println("Parsing: " + sourceName);
			
			//Pass to compiler
			compiler = new Assembler(stream);
			compiler.setOutputStream(new HexPrinterStream());
			compiler.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
