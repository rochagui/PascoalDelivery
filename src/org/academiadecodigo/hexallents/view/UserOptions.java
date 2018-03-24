package org.academiadecodigo.hexallents.view;

/**
 * Created by codecadet on 24/03/2018.
 */
public enum UserOptions {

    MAKE_ORDER(1, Messages.MAKE_ORDER),

    CHECK_STATUS(2, Messages.CHECK_STATUS),

    QUIT(3, Messages.CHOOSE_ITEM);

    UserOptions(int option, String message) {
        this.option = option;
        this.message = message;

    }

    private int option;
    private String message;

    public int getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Gets the messages for the options the user can perform
     *
     * @return an array containing all the messages
     */
    public static String[] getMessages() {

        String[] messages = new String[values().length];

        for (UserOptions option : values()) {
            messages[option.getOption() - 1] = option.getMessage();
        }

        return messages;
    }
}


