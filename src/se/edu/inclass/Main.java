package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

//        System.out.println("Printing deadlines");
//        printDeadlines(tasksData);
//
//        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));
//
//        printData(tasksData);
//        printDataWithStreams(tasksData);

        printDeadlinesWithStreams(tasksData);
        System.out.println("Total number of deadlines (using stream): " + countDeadlinesWithStreams(tasksData));
    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesWithStreams(ArrayList<Task> tasksData) {
        int count = (int) tasksData.stream()
                .filter((t) -> t instanceof Deadline)
                .count();
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataWithStreams(ArrayList<Task> tasksData) {
        System.out.println("Printing tasks data using stream");
        tasksData.stream()
                .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesWithStreams(ArrayList<Task> tasksData) {
        System.out.println("Printing deadlines data using stream");
        tasksData.stream()
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);
    }
}
