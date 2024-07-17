package tool;


public class ActionFactory {
    public static Action getAction(String actionName) {
        switch (actionName) {
            case "login":
                return new LoginAction();
            case "loginExecute":
                return new LoginExecuteAction();
            case "menu":
                return new MenuAction();
            default:
                return null;
        }
    }
}
