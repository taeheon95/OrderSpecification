package com.view;

import java.util.Scanner;

public interface ModelView {
    public void view(Scanner sc);
    public void view(int id);
    public void make(Scanner sc);
    public void edit(Scanner sc);
    public void edit(int id, Scanner sc);
}
