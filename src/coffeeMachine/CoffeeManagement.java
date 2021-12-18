package coffeeMachine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CoffeeManagement { // 커피 관리자 모드

   public static void management() throws Exception {

      FileReader reader = new FileReader("C:\\Temp\\자판기 판매 관리.txt");
      int ch;

      Scanner sc = new Scanner(System.in);

      while (true) {
         System.out.println("=============================================================");
         System.out.println("\n관리자모드입니다\n");
         System.out.println(" 1: 메뉴 추가 \n 2: 가격 변경\n 3: 재고 추가\n 4: 메뉴 변경\n 5: 총 수익 확인\n 6: 관리자모드 종료");
         System.out.print("\n번호를 입력하세요: ");
         int num = sc.nextInt();
         System.out.println("=============================================================");

         // 메뉴 추가
         if (num == 1) {
            if (Coffeestore.count >= Coffeestore.MAX - 1) {
               System.out.println("더 이상 커피가 들어갈 자리가 없습니다!");
               continue;
            } else {
               System.out.print("추가하실 커피의 가격을 입력하세요 : ");
               int i = sc.nextInt();
               System.out.print("추가하실 커피의 이름을 입력하세요 : ");
               sc.nextLine();
               String name = sc.next();
               System.out.print(name + "의 재고는 mL 입니까? : ");
               int j = sc.nextInt();

               Coffeestore.menu[Coffeestore.count] = name;
               Coffeestore.price[Coffeestore.count] = i;
               Coffeestore.stock[Coffeestore.count] = j;
               Coffeestore.count++;
               System.out.println("메뉴 추가가 완료되었습니다!");
            }
         }
         // 가격 변경
         else if (num == 2) {
            System.out.print("가격을 변경하실 메뉴의 번호를 입력하세요(1~" + Coffeestore.count + ") :");
            int i = sc.nextInt();
            System.out.print(Coffeestore.menu[i - 1] + "의 가격을 얼마로 바꾸시겠습니까? :");
            int j = sc.nextInt();
            Coffeestore.price[i - 1] = j;
            System.out.println("가격 변경이 완료되었습니다!");
         }
         // 재고 추가
         else if (num == 3) {
            System.out.print("재고를 추가하실 메뉴의 번호를 입력하세요(1~" + Coffeestore.count + ") :");
            int i = sc.nextInt();
            System.out.print(Coffeestore.menu[i - 1] + "을(를) 몇 개 추가 하시겠습니까? :");
            int j = sc.nextInt();
            Coffeestore.stock[i - 1] += j;
            System.out.println("재고 추가가 완료되었습니다!");
         }
         // 메뉴 변경
         else if (num == 4) {
            System.out.print("변경하실 메뉴의 번호를 입력하세요(1~" + Coffeestore.count + ") :");
            int i = sc.nextInt();
            System.out.print(Coffeestore.menu[i - 1] + "을(를) 무엇으로 바꾸시겠습니까? :");
            sc.nextLine();
            String name = sc.next();
            System.out.print(name + "의 가격은 얼마입니까? ");
            int v = sc.nextInt();
            System.out.print(name + "의 재고를 몇 개 등록하시겠습니까? : ");
            int n = sc.nextInt();

            Coffeestore.menu[i - 1] = name;
            Coffeestore.price[i - 1] = v;
            Coffeestore.stock[i - 1] = n;
            System.out.println("메뉴 변경이 완료되었습니다!");

         }

         // 수익 확인
         else if (num == 5) {
            System.out.println("현재까지의 수익은 " + Coffeestore.profit + "입니다.\n");
            while ((ch = reader.read()) != -1) {
               System.out.print((char) ch);
            }

         }
         // 6입력시 종료
         else if (num == 6) {
            System.out.println("관리자 모드가 종료됩니다.");
            Coffee.coffee();
            return;
         }
      }
   }

}