package com.star.sud;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ImplementRunnableObject {
	public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // evaluate JavaScript code that defines a function with one parameter
        engine.eval("var obj = new Object()");
        engine.eval("obj.run = function() { print('obj.run() method called') }");

        // expose object defined in the script to the Java application
        Object obj = engine.get("obj");

        // create an Invocable object by casting the script engine object
        Invocable inv = (Invocable) engine;

        // get Runnable interface object
        Runnable r = inv.getInterface(obj, Runnable.class);

        // start a new thread that runs the script
        Thread th = new Thread(r);
        th.start();
        th.join();
    }
}