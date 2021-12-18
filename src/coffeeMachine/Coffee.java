package coffeeMachine;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;


public class Coffee {
   static boolean isChecked = true;
   static boolean first = true;
   static int money = 0;

   public static void coffee() throws Exception { // 커피 사용자 페이지

      BufferedWriter date = new BufferedWriter(new FileWriter("C:\\Temp\\자판기 판매 관리.txt", true));
      PrintWriter dn = new PrintWriter(date, true);
      
      SimpleDateFormat format1 = new SimpleDateFormat ( "\nyyyy-MM-dd HH시 mm분\n");
      Date time = new Date();
      String time1 = format1.format(time);
      
      dn.write(time1);
      dn.flush();
      dn.close();
      Coffeestore.coffee();
      Scanner sc = new Scanner(System.in);

      while (true) {
         // 메뉴 출력 및 재고 확인
         System.out.println("================================================================");
         System.out.println("================================================================");
         System.out.println(" 커피 자판기  \n");
         for (int i = 0; i < Coffeestore.count; i++) {
            System.out.print((i + 1) + ". " + Coffeestore.menu[i] + "  " + Coffeestore.price[i] + "원\n");
            if (Coffeestore.stock[i] == 0) {
               System.out.println("  " + Coffeestore.menu[i] + "는 품절입니다.");
            }

         }

         System.out.println();
         System.out.println("* L사이즈 주문시 300원 추가 *");
         System.out.println();
         System.out.println("(관리자모드 : 11)\n");// 관지라모드는 11번
         System.out.println("================================================================");
         // 커피 선택
         System.out.print("번호를 선택해주세요(종료 시 0번 입력): ");
         int num = sc.nextInt();

         // 관리자모드 진입
         if (num == 11) {
            System.out.print("관리자모드 비밀번호: ");
            int pw = sc.nextInt();
            if (pw == 3480) {
               CoffeeManagement.management();
               return;
            } else {
               System.out.println("비밀번호가 틀립니다.");
               break;
            }

         }
         // 커피 번호를 잘못 선택
         if (num > Coffeestore.count) {
            System.out.println("잘못 누르셨습니다.");
            continue;
         }
         // 0번을 눌러 잔돈반환
         if (num == 0) {
            System.out.println("거스름돈: " + money);
            System.out.println("또 이용해주세요!");

            break;
         }
         // 돈 투입
         if (first) {
            System.out.print("돈을 넣어주세요: ");
            money = sc.nextInt();
            first = false;
         }
         // 선택한 커피 출력
         System.out.println("사이즈를 선택하세요.\n R :1, L: 2");
         int size = sc.nextInt();
         switch (size) {
         case 1:
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Temp\\자판기 판매 관리.txt", true));
            PrintWriter fw = new PrintWriter(bw, true);
            if (money >= Coffeestore.price[num - 1]) {
               System.out
                     .println(Coffeestore.menu[num - 1] + " R사이즈가 나왔습니다.(" + Coffeestore.price[num - 1] + "원)");
               money = money - Coffeestore.price[num - 1];
               Coffeestore.stock[num - 1] = Coffeestore.stock[num - 1] - 200;
               Coffeestore.profit += Coffeestore.price[num - 1];
               String data = Coffeestore.menu[num - 1];
               fw.write(data + "  R사이즈  : " + Coffeestore.price[num - 1] + "원\n");
               fw.flush();
               fw.close();
            } else {
               System.out.println("잔액이 부족합니다!");
               System.out.println("잔액 : " + money);
               System.out.println("계속하시려면 1 종료하시려면 2");
               Coffeestore.dec = sc.nextInt();
               // 돈을 추가
               if (Coffeestore.dec == 1) {
                  System.out.println("돈을 넣어주세요: ");
                  int money1 = sc.nextInt();
                  money += money1;
                  System.out.println("잔액 : " + money);
                  continue;

               } else if (Coffeestore.dec == 2) {
                  System.out.println("거스름돈 :" + money);
                  System.out.println("또 이용해주세요!");

                  isChecked = false;
                  break;
               } else {
                  System.out.println("잘못된 번호를 입력하여 종료됩니다.");
                  System.out.println("거스름돈 :" + money);
                  System.out.println("또 이용해주세요!");
                  isChecked = false;

                  break;
               }
            }
            break;
         case 2:
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:\\Temp\\자판기 판매 관리.txt", true));
            PrintWriter fw1 = new PrintWriter(bw1, true);
            if (money >= (Coffeestore.price[num - 1] + 300)) {
               money = money - 300 - Coffeestore.price[num - 1];
               Coffeestore.stock[num - 1] = Coffeestore.stock[num - 1] - 400;
               Coffeestore.profit = Coffeestore.profit + 300 + Coffeestore.price[num - 1];
               System.out.println(
                     Coffeestore.menu[num - 1] + " L사이즈가 나왔습니다.(" + (Coffeestore.price[num - 1] + 300) + "원)");
               String data = Coffeestore.menu[num - 1];
               fw1.write(data + "  L사이즈  : " + (Coffeestore.price[num - 1] + 300) + "\n");
               fw1.flush();
               fw1.close();
            } else {
               System.out.println("잔액이 부족합니다!");
               System.out.println("잔액 : " + money);
               System.out.println("계속하시려면 1 종료하시려면 2");
               Coffeestore.dec = sc.nextInt();
               // 돈을 추가
               if (Coffeestore.dec == 1) {
                  System.out.println("돈을 넣어주세요: ");
                  int money1 = sc.nextInt();
                  money += money1;
                  System.out.println("잔액 : " + money);
                  continue;

               } else if (Coffeestore.dec == 2) {
                  System.out.println("거스름돈 :" + money);
                  System.out.println("또 이용해주세요!");
                  isChecked = false;

                  break;
               } else {
                  System.out.println("잘못된 번호를 입력하여 종료됩니다.");
                  System.out.println("거스름돈 :" + money);
                  System.out.println("또 이용해주세요!");
                  isChecked = false;

                  break;
               }
            }
            break;
         }
         if (isChecked == false)
            System.exit(0);

         // 커피 나온후 잔액
         System.out.println("잔액 : " + money);
         System.out.println("");

         if (money == 0) {
            System.out.println("프로그램이 종료됩니다.");

            break;
         }

      }

   }

}