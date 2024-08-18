package com.corejava.io;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Enter pattern：");
        String patternString = in.nextLine();

        Pattern pattern = Pattern.compile(patternString);

        while (true) {
            System.out.println("Enter string to match: ");
            String input = in.nextLine();

            if (input == null || input.equals("")) System.exit(0);

            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Match");
                int g = matcher.groupCount();
                if (g > 0) {
                    for (int i = 0; i < input.length(); i++) {
                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i == matcher.end(j))
                                System.out.println("()");
                        }

                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i != matcher.end(j))
                                System.out.println("(");
                        }

                        for (int j = 1; j <= g; j++) {
                            if (i + 1 != matcher.start(j) && i + 1 == matcher.end(j))
                                System.out.println(")");
                        }

                        System.out.println();
                    }
                }
            } else {
                System.out.println("No match");
            }
        }
    }
}
