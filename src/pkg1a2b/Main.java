package pkg1a2b;

import java.util.Scanner;
import java.io.Console;
import java.util.Random;

/*
    2A2B小遊戲
    JAVA練習作品
    2019.07.23 By Bob Pan.
 */
public class Main {

    //區域變數放置區
    static boolean chkfallloop;
    static int outnum[] = {0, 0, 0, 0};
    static int ta = 0;
    static int tb = 0;

    //使用者輸入檢查(錯誤會將chkfallloop改成true並跳出)
    static void chkinnum(char[] inpnum) {
        //System.out.println("chkinnum");//test
        chkfallloop = false;
        //初步過濾掉未到4個字元的字串
        if (inpnum.length != 4) {
            chkfallloop = true;
            System.err.println("Wrong number!! Please input 4 different Arabic numerals.");
        } else {
            //轉換成Int(會變成ASCII碼)
            //並檢查是否為0(48)~9(57)，檢查錯誤丟出錯誤碼。
            boolean errcon = false;
            for (byte i = 0; i < 4; i++) {
                outnum[i] = (int) inpnum[i];
                if (outnum[i] < 48 || outnum[i] > 57) {
                    errcon = true;
                    break;
                }
            }
            //有錯誤碼便返回迴圈
            if (errcon == true) {
                chkfallloop = true;
                System.err.println("Wrong number!! Please input 4 different Arabic numerals.");
            } else {
                for (byte j = 0; j < 4; j++) {
                    outnum[j] = outnum[j] - 48;
                }
            }
        }
    }

    //檢查是否有重複字元(錯誤會將chkfallloop改成true並跳出)
    static void chkrepnum() {
        //System.out.println("chkrepnum");//test
        chkfallloop = false;
        /*for (byte i = 0; i < 4; i++) {
            System.out.print(outnum[i]);
        }
        System.out.print("\n");*///test
        boolean reperr = false;
        for (int j = 0; j < 3; j++) {
            for (int l = (j + 1); l < 4; l++) {
                if (outnum[j] == outnum[l]) {
                    reperr = true;
                    break;
                }
            }
            if (reperr) {
                chkfallloop = true;
                break;
            }
        }
    }

    static void compare(Integer[] ans, int[] in) {
        //Test print number:
        //System.out.println("(Compare)Now ans:");
        //System.out.print(ans[0]);
        //System.out.print(ans[1]);
        //System.out.print(ans[2]);
        //System.out.println(ans[3]);
        //System.out.println("(Compare)Now inp:");
        //System.out.print(in[0]);
        //System.out.print(in[1]);
        //System.out.print(in[2]);
        //System.out.println(in[3]);
        ta = 0;
        tb = 0;
        //歸零ab後用雙重迴圈比較
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (ans[i] == in[j]) {
                    if (i == j) {
                        ta++;
                    } else {
                        tb++;
                    }
                }
            }
        }
    }

    //輸入數字模式
    static void givenum() {
        //要在主控台測試請將註解交換改採Scanner方法
        Console console = System.console();
        //Scanner scanner = new Scanner(System.in);
        String ans;
        char[] conum;
        do {
            //輸入字元(不顯示)，chkfallloop為true(輸入有誤)跳到這個迴圈頭
            //要在主控台測試請將註解交換改採Scanner方法
            ans = new String(console.readPassword("Number:"));
            //System.out.print("Input:");
            //ans = scanner.next();
            conum = ans.toCharArray();
            chkinnum(conum);
            if (chkfallloop == false) {
                chkrepnum();
                if (chkfallloop == true) {
                    System.err.println("Wrong number!! Please input 4 different Arabic numerals.");
                } else {
                    maingame(outnum);
                }
            }
        } while (chkfallloop);
    }

    //亂數模式
    static void rand() {
        Random random = new Random();
        do {
            //抽取亂數4個存入陣列(亂數重複會跳至此重抽)
            for (byte i = 0; i < 4; i++) {
                //System.out.print("give generate:");
                //System.out.println(i);
                outnum[i] = random.nextInt(9);
                //System.out.println(outnum[i]);
            }
            //檢查重複亂數(未通過不會解除迴圈)
            chkrepnum();
        } while (chkfallloop);
        maingame(outnum);
    }

    static void maingame(int[] num) {
        //逐項取出包裝成Wapper(避免資料被覆寫(實測有覆寫現象))
        Integer[] ansnum = new Integer[num.length];
        int i = 0;
        for (int value : num) {
            ansnum[i++] = value;
        }
        //test print number.
        //System.out.println("(Maingame)Now:");
        //System.out.print(ansnum[0]);
        //System.out.print(ansnum[1]);
        //System.out.print(ansnum[2]);
        //System.out.println(ansnum[3]);
        String ans;
        Scanner scanner = new Scanner(System.in);
        int trytimes = 1;
        char[] conans;
        do {
            do {
                //取得輸入並處理
                System.out.print("Try");
                System.out.print(trytimes);
                System.out.print(" => ");
                ans = scanner.nextLine();
                conans = ans.toCharArray();
                chkinnum(conans);
                if (chkfallloop == false) {
                    chkrepnum();
                    if (chkfallloop == true) {
                        System.err.println("Wrong number!! Please input 4 different Arabic numerals.");
                    } else {
                        //都OK進行比較
                        compare(ansnum, outnum);
                    }
                }
            } while (chkfallloop);
            System.out.println(trytimes + ". " + ta + "A" + tb + "B");
            //中獎訊息
            if (ta == 4) {
                System.out.println("=========================");
                System.out.println(" Congratulations!");
                System.out.println(" The answer is : " + ansnum[0] + ansnum[1] + ansnum[2] + ansnum[3]);
                System.out.println(" You total try " + trytimes + " times.");
                System.out.println("=========================");
            } else {
                trytimes++;
            }
        } while (ta != 4);

    }

    public static void main(String[] args) {
        //檢查引數是否為遊戲模式rand(電腦亂數)或givenum(玩家給數字)
        System.out.println("=========================");
        System.out.println(" 1A2B Java console game.");
        System.out.println(" By Bob Pan");
        System.out.println(" 2019.07.24");
        System.out.println("=========================");
        if (args.length > 1) {
            System.err.println("Too many argument. Please USE \"givenum\" or \"rand\"(default) to start.");
        } else if (args.length == 0) {
            System.out.println("Game start in \"rand\" mode");
            rand();
        } else if (args.length == 1) {
            switch (args[0]) {
                case "givenum":
                    System.out.println("Game start in \"givenum\" mode");
                    givenum();
                    break;
                case "rand":
                    System.out.println("Game start in \"rand\" mode");
                    rand();
                    break;
                default:
                    System.err.println("Invaild argument. Please USE \"givenum\" or \"rand\"(default) to start.");
                    break;
            }
        }
    }

}
