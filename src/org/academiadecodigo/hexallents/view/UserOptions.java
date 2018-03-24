package org.academiadecodigo.hexallents.view;

/**
 * Created by codecadet on 24/03/2018.
 */
public enum UserOptions {

    MAKE_ORDER(1, Messages.MAKE_ORDER),

    CHECK_STATUS(2, Messages.CHECK_STATUS),

    QUIT(3, Messages.QUIT);

    UserOptions(int answerIndex, String message) {
        this.answerIndex = answerIndex;
        this.message = message;

    }

    private int answerIndex;
    private String message;

    public int getAnswerIndex() {
        return answerIndex;
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
            messages[option.getAnswerIndex() - 1] = option.getMessage();
        }

        return messages;
    }
}


