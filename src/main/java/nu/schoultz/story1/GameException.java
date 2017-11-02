/*
 * Copyright (c) 2017. Schoultz Consulting, Sweden.
 */

package nu.schoultz.story1;

class GameException extends RuntimeException {
    GameException(String txt, Exception e) {
        super(txt, e);
    }
}
