package uroborosGameStudio.domain;

import java.io.Serializable;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

public class Collider implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private String code;
	
	public Collider(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.code = "";
	}

	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String newCode) {
		this.code = newCode;
	}

	@SuppressWarnings("unchecked")
	public void evalCollider(EcmaScriptEngine engine, String nameActor) {
//		try {
//			Object consumer = engine.eval(this.code);
//
//			Method consumerMethod = Arrays.asList(consumer.getClass().getMethods()).stream()
//					.filter(method -> method.getName().equals("call")).findFirst().orElse(null);
//
//			Game.getActor(nameActor).whenCollidesDo(aActor -> {
//
//				
//				
//				try {
//					consumerMethod.invoke(consumer, "onColliderDo", 
//							engine.eval(
//									"var actors = Game.getCurrentScene().getActors();"+
//											"var index = 0;"+
//											"var aux = actors.get(index);"+
//											"while (aux.getName() != '"+nameActor+"') {"+
//												"index++;"+
//												"aux = actors.get(index);"+
//											"}"+"aux"));
//				} 
				
//				catch (ScriptException | IllegalAccessException | IllegalArgumentException
//						| InvocationTargetException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			});

//		} 
//		 catch (ScriptException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		actor.whenCollidesDo((aActor -> {
//			engine.eval(code);
//		}));
//		
//		try {
//			actor.whenCollidesDo((Consumer<Actor>) engine.eval(code));
//			Invocable inv = (Invocable) engine;
//			inv.invokeFunction("onColliderDo", "collider");
//		} catch (ScriptException | NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/*
		actor.whenCollidesDo((collider) -> {
			try {
				engine.eval(code);
				
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		*/
		
	}
}
