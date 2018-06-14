package controller.action.board;

import controller.action.Action;
import controller.action.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	private static BoardActionFactory instance;

	public static BoardActionFactory getInstance() {
		if (instance == null) {
			instance = new BoardActionFactory();
		}
		return instance;
	}

	@Override
	public Action getAction(String command) {
		Action action = null;
		switch (command) {
		case "list":
			action = new BoardListAction();
			break;
		case "view":
			action = new BoardViewAction();
			break;
		case "check-pass-form":
			action = new CheckPassFormAction();
			break;
//		case "check-pass":
//			action = new CheckPassAction();
//			break;
		case "write-form":
			action = new BoardWriteFormAction();
			break;
		case "write":
			action = new BoardWriteAction();
			break;
		case "update-form":
			action = new BoardUpdateFormAction();
			break;
		case "update":
			action = new BoardUpdateAction();
			break;
		case "delete":
			action = new BoardDeleteAction();
			break;
		}
		return action;
	}

}
