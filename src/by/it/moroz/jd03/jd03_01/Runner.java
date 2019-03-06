package by.it.moroz.jd03.jd03_01;

public class Runner {

    public static void main(String[] args) {
        A_AddOrder addData = new A_AddOrder();
        A_AddUser addUser = new A_AddUser();
        A_CreateDB createDB = new A_CreateDB();
        B_AddRoles addRoles = new B_AddRoles();
        B_ShowUsers showUsers = new B_ShowUsers();
        A_AddMenu addMenu = new A_AddMenu();
        C_Init init = new C_Init();
        C_Reset reset = new C_Reset();

        reset.resetDB();
        createDB.createDB();
        addRoles.addRoles();
        addMenu.addMenu();
        addUser.addUsers();
        addData.addOrder();
        showUsers.showUsers();
        //init.initDB();
    }
}
