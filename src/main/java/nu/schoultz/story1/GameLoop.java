package nu.schoultz.story1;

import com.bladecoder.ink.runtime.Story;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

class GameLoop {
    private Story story = null;

    GameLoop(String storyJson) throws Exception {
        story = new Story(storyJson);
    }

    void start() throws Exception {

        while (story.canContinue()) {
            String line = story.Continue();
            System.out.print(line);

            if (story.getCurrentChoices().size() > 0) {

                final AtomicInteger count = new AtomicInteger();

                story.getCurrentChoices().forEach(s -> System.out.println(count.incrementAndGet() + ": " + s.getText()));

                Integer choice = getConsoleChoice(count.intValue());
                story.chooseChoiceIndex(choice);
            }
        }
        System.out.println("================ T H E   E N D ===============");
    }

    private Integer getConsoleChoice(int max) {
        Integer choice;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = null;
            }

            if (choice != null && choice >= 0 && choice < max) break;

            System.out.println("That was not an acceptable choice.");
        }
        return choice;
    }
}