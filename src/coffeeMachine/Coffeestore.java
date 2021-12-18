package coffeeMachine;

import java.util.Scanner;

public class Coffeestore { // 커피 저장 공간

   static int MAX = 50; // 메뉴의 최대 갯수:50
   static String[] menu = new String[MAX];
   static int[] price = new int[MAX];
   static int[] stock = new int[MAX];
   static int count = 5;
   static int profit = 0;
   static int dec = 0;

   Scanner sc = new Scanner(System.in);

   public static void coffee() {

      menu[0] = "아메리카노";
      price[0] = 3000;
      stock[0] = 5000; // 기본용량은 5000mL
      menu[1] = "카페라떼";
      price[1] = 3500;
      stock[1] = 5000; // 기본용량은 5000mL
      menu[2] = "바닐라라떼";
      price[2] = 3800;
      stock[2] = 5000; // 기본용량은 5000mL
      menu[3] = "에소프레소";
      price[3] = 2500;
      stock[3] = 5000; // 기본용량은 5000mL
      menu[4] = "카푸치노";
      price[4] = 3700;
      stock[4] = 5000; // 기본용량은 5000mL
      menu[5] = "카라멜마끼야또";
      price[5] = 4000;
      stock[5] = 5000; // 기본용량은 5000mL
   }

}