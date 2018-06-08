package controller;

import controller.action.Action;
import controller.action.BoardCheckPassAction;
import controller.action.BoardCheckPassFormAction;
import controller.action.BoardDeleteAction;
import controller.action.BoardListAction;
import controller.action.BoardUpdateAction;
import controller.action.BoardUpdateFormAction;
import controller.action.BoardViewAction;
import controller.action.BoardWriteAction;
import controller.action.BoardWriteFormAction;

public class ActionFactory {
	//요청에 따라서 실제 동작할 객체를 만들어주는 역할
	
	public static Action getAction(String command) {
		Action action = null;
		
		switch(command){
		case "board_list":
			action= new BoardListAction();
			break;
		case "board_write":
			action= new BoardWriteAction();
			break;
		case "board_write_form":
			action= new BoardWriteFormAction();
			break;
		case "board_view":
			action= new BoardViewAction();
			break;
		case "board_check_pass_form":
			action= new BoardCheckPassFormAction();
			break;
		case "board_check_pass":
			action= new BoardCheckPassAction();
			break;
		case "board_update_form":
			action= new BoardUpdateFormAction();
			break;
		case "board_update":
			action= new BoardUpdateAction();
			break;
		case "board_delete":
			action= new BoardDeleteAction();
			break;
		default:
			break;
		}
		
		return action;
	}
	
}
