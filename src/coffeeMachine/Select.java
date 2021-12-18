package coffeeMachine;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Select { // 음료 및 커피 선택

   public static void select() throws Exception {
      Scanner sc = new Scanner(System.in);
      System.out.println("================================================================");
      System.out.println("       \n           자판기\n");// 관지라모드는 11번
      System.out.println("         커피자판기 : 1\n         음료자판기 : 2       ");
      System.out.println("");

      while (true) {
         int sec = sc.nextInt();
         if (sec == 1) {
            Coffee.coffee();
            break;
         } else if (sec == 2) {
            Drink.drink();
            break;
         } else {
            System.out.println("다시 입력해주세요.");
            continue;
         }

      }
   }

}