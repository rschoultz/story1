/*
 * Copyright (c) 2017. Schoultz Consulting, Sweden.
 */

package nu.schoultz.story1;

public class StoryMain {


    public static void main(String[] args) throws Exception {

        String filename;

        if (args.length == 0) {
            filename = "story.ink.json";
        } else {
            filename = args[0];
        }

        System.out.println("filename = " + filename);

        String story = new ExpStory().initiate(filename);

        new GameLoop(story).start();
    }
}
