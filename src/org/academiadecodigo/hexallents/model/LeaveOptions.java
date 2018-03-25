package org.academiadecodigo.hexallents.model;

/**
 * Created by codecadet on 25/03/2018.
 */
public enum LeaveOptions {
    CHECKOUT("Proceed to checkout", 5),
    BACK("Back to main menu", 6);

    String leaveOptions;
    int userOptions;
    LeaveOptions(String leaveOptions, int userOptions){
        this.leaveOptions = leaveOptions;
        this.userOptions = userOptions;
    }

    public String getLeaveOptions() {
        return leaveOptions;
    }

    public int getUserOptions() {
        return userOptions;
    }

    public static String[] leaveOptions() {

        String[] messages = new String[values().length];

        for (LeaveOptions leaveOption: values()) {
            messages[leaveOption.ordinal()] = leaveOption.getLeaveOptions();
        }

        return messages;
    }
}
