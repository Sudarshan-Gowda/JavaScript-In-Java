package com.star.sud;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ImplementRunnable {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");

		// evaluate JavaScript code that defines a function with one parameter
		engine.eval("function run() { print('run() function called') }");

		// create an Invocable object by casting the script engine object
		Invocable inv = (Invocable) engine;

		// get Runnable interface object
		Runnable r = inv.getInterface(Runnable.class);

		// start a new thread that runs the script
		Thread th = new Thread(r);
		th.start();
		th.join();
	}
}