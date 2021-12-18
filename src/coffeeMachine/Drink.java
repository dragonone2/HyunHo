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



public class Drink {

   static boolean isChecked = true;
   static boolean first = true;
   static int money = 0;

   public static void drink() throws Exception { // 음료 사용자 페이지
      BufferedWriter date = new BufferedWriter(new FileWriter("C:\\Temp\\자판기 판매 관리.txt", true));
      PrintWriter dn = new PrintWriter(date, true);
      
      SimpleDateFormat format1 = new SimpleDateFormat ( "\nyyyy-MM-dd HH시 mm분\n");
      Date time = new Date();
      String time1 = format1.format(time);
      
      dn.write(time1);
      dn.flush();
      dn.close();
      Drinkstore.drink();
      Scanner sc = new Scanner(System.in);

      while (true) {

         // 메뉴 출력 및 재고 확인
         System.out.println("================================================================");
         System.out.println("================================================================");
         System.out.println(" 음료수 자판기  \n");
         for (int i = 0; i < Drinkstore.count; i++) {
            System.out.print((i + 1) + ". " + Drinkstore.menu[i] + "  " + Drinkstore.price[i] + "원\n");
            if (Drinkstore.stock[i] == 0) {
               System.out.println("  " + Drinkstore.menu[i] + "는 품절입니다.");
            }

         }

         System.out.println();
         System.out.println("* L사이즈 주문시 300원 추가 *");
         System.out.println();
         System.out.println("(관리자모드 : 11)\n");// 관지라모드는 11번
         System.out.println("================================================================");
         // 커피 선택
         System.out.print("음료 번호를 선택해주세요: ");
         int num = sc.nextInt();
         // 관리자모드 진입
         if (num == 11) {
            System.out.print("관리자모드 비밀번호: ");
            int pw = sc.nextInt();
            if (pw == 3480) {
               DrinkManagement.management();
               return;
            } else {
               System.out.println("비밀번호가 틀립니다.");
               break;
            }

         }
         // 음료 번호를 잘못 선택
         if (num > Drinkstore.count) {
            System.out.println("잘못 누르셨습니다.");
            continue;
         }
         // 돈 투입
         if (first) {
            System.out.print("돈을 넣어주세요: ");
            money = sc.nextInt();
            first = false;
         }
         // 0번을 눌러 잔돈반환
         if (num == 0) {

            System.out.println("거스름돈: " + money);
            System.out.println("또 이용해주세요!");
            break;
         }
         // 선택한 음료 출력
         System.out.println("사이즈를 선택하세요.\n R :1, L: 2");
         int size = sc.nextInt();
         switch (size) {

         case 1:
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Temp\\자판기 판매 관리.txt", true));
            PrintWriter fw = new PrintWriter(bw, true);

            if (money >= Drinkstore.price[num - 1]) {
               money = money - Drinkstore.price[num - 1];
               Drinkstore.stock[num - 1] = Drinkstore.stock[num - 1]--;
               Drinkstore.profit += Drinkstore.price[num - 1];
               System.out.println(Drinkstore.menu[num - 1] + " R사이즈가 나왔습니다.(" + Drinkstore.price[num - 1] + "원)");
               String data = Drinkstore.menu[num - 1];
               fw.write(data + "  R사이즈  : " + Drinkstore.price[num - 1] + "\n");
               fw.flush();
               fw.close();

            } else {
               System.out.println("잔액이 부족합니다!");
               System.out.println("잔액 : " + money);
               System.out.println("계속하시려면 1 종료하시려면 2");
               Drinkstore.dec = sc.nextInt();
               // 돈을 추가
               if (Drinkstore.dec == 1) {
                  System.out.println("돈을 넣어주세요: ");
                  int money1 = sc.nextInt();
                  money += money1;
                  System.out.println("잔액 : " + money);
                  continue;

               } else if (Drinkstore.dec == 2) {
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
            if (money >= (Drinkstore.price[num - 1] + 300)) {
               money = money - 300 - Drinkstore.price[num - 1];
               Drinkstore.Lstock[num - 1] = Drinkstore.Lstock[num - 1]--;
               Drinkstore.profit = Drinkstore.profit + Drinkstore.price[num - 1] + 300;
               System.out.println(
                     Drinkstore.menu[num - 1] + " L사이즈가 나왔습니다.(" + (Drinkstore.price[num - 1] + 300) + "원)");
               String data = Drinkstore.menu[num - 1];
               fw1.write(data + "  L사이즈  : " + (Drinkstore.price[num - 1] + 300) + "\n");
               fw1.flush();
               fw1.close();

            } else {
               System.out.println("잔액이 부족합니다!");
               System.out.println("잔액 : " + money);
               System.out.println("계속하시려면 1 종료하시려면 2");
               Drinkstore.dec = sc.nextInt();
               // 돈을 추가
               if (Drinkstore.dec == 1) {
                  System.out.println("돈을 넣어주세요: ");
                  int money1 = sc.nextInt();
                  money += money1;
                  System.out.println("잔액 : " + money);
                  continue;

               } else if (Drinkstore.dec == 2) {
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
            System.out.println("음료가 나왔습니다!");

            break;
         }

      }

   }

}