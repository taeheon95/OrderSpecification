package com.view;

import java.util.Scanner;

public interface ModelView {
    boolean view(Scanner sc);
    boolean view(int id);
    void make(Scanner sc);
    boolean edit(Scanner sc);
    boolean edit(int id, Scanner sc);
    boolean delete(Scanner sc);
}
