package com.solid.book;

import java.util.List;

public class ScreenPrinter extends Book {

  public ScreenPrinter(String title, List<String> pages) {
    super(title, pages);
  }

  public void printToScreen() {
    Book book = this;
    do {
      System.out.println(book.getCurrentPage());
    } while (book.turnToNextPage());
  }
}