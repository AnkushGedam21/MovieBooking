package com.techverito.utils;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class UserInputUtil {
    private final Scanner scanner;

    public UserInputUtil(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getSeatsInputFromUser() throws Exception{
        System.out.print(("Enter Seat Numbers::"));
        return Arrays.stream(getUserInput().split(",")).collect(Collectors.toList());
    }
    public String getUserInput() throws Exception {
        return scanner.nextLine().split(" ")[0];
    }
}
