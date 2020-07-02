package com.star.sud;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class EvalFile {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");

		// evaluate JavaScript code
		engine.eval(new java.io.FileReader("script.js"));
		
	}
}