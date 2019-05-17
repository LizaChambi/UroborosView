package uroborosGameStudio.exception;

import uroborosGameStudio.domain.GameObject;

public class NombreVacioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameObject game;

	public NombreVacioException(GameObject game) { this.game = game;	}

	@Override
	public String getMessage() {
		return game.toString() + " debe tener un nombre.";
	}

}
