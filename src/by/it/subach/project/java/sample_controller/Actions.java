package by.it.subach.project.java.sample_controller;


enum Actions {
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.jsp ="/signup.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.jsp ="/login.jsp";
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.jsp ="/profile.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandLogout();
        }
    };
    public String jsp ="/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }


}