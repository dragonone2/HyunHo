package coffeeMachine;

import java.util.Scanner;

public class Drinkstore { // 음료 저장 공간

   static int MAX = 50; // 메뉴의 최대 갯수:50
   static String[] menu = new String[MAX];
   static int[] price = new int[MAX];
   static int[] stock = new int[MAX];
   static int[] Lstock = new int[MAX];
   static int count = 5;
   static int dec = 0;
   static int profit = 0;

   Scanner sc = new Scanner(System.in);

   public static void drink() {

      menu[0] = "사이다";
      price[0] = 1400;
      stock[0] = 5; // 기본재고는 5개
      Lstock[0] = 5; // 기본재고는 5개
      menu[1] = "콜라";
      price[1] = 1600;
      stock[1] = 5; // 기본재고는 5개
      Lstock[1] = 5; // 기본재고는 5개
      menu[2] = "환타";
      price[2] = 1100;
      stock[2] = 5; // 기본재고는 5개
      Lstock[2] = 5; // 기본재고는 5개
      menu[3] = "파워에이드";
      price[3] = 1700;
      stock[3] = 5; // 기본재고는 5개
      Lstock[3] = 5; // 기본재고는 5개
      menu[4] = "콜라 제로";
      price[4] = 1400;
      stock[4] = 5; // 기본재고는 5개
      Lstock[4] = 5; // 기본재고는 5개
      menu[5] = "박카스";
      price[5] = 700;
      stock[5] = 5; // 기본재고는 5개
      Lstock[5] = 5; // 기본재고는 5개

   }

}