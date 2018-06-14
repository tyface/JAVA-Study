package controller.action.member;

import controller.action.Action;
import controller.action.ActionFactory;

public class MemberActionFactory extends ActionFactory {

	private static MemberActionFactory instance;

	public static MemberActionFactory getInstance() {
		if (instance == null) {
			instance = new MemberActionFactory();
		}
		return instance;
	}

	@Override
	public Action getAction(String command) {
		Action action = null;
		switch (command) {
		case "login":
			action = new LoginAction();
			break;
		case "logout":
			action = new LogoutAction();
			break;
		case "join":
			action = new JoinAction();
			break;
		case "join-form":
			action = new JoinFormAction();
			break;
		case "modify":
			action = new ModifyAction();
			break;
		case "modify-form":
			action = new ModifyFormAction();
			break;
		case "check-id":
			action = new CheckIdAction();
			break;
		case "check-email":
			action = new CheckEmailAction();
			break;
		case "view-profile":
			action = new ViewProfileAction();
			break;
		default:
			break;
		}

		return action;
	}

}
