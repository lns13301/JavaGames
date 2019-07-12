package baseJava;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean newplayer = true;
    private static List<List<String>> itemList = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        int returnvalue = -1;
        UserData ud = new UserData();

        File file = new File("itemlist.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String cur = null;
        String readData = null;
        while((cur = reader.readLine()) != null){
            readData = cur;
            List<String> list = new LinkedList<>();
            String[] split = readData.split("@");
            list.add(split[0]);
            list.add(split[1]);
            itemList.add(list);
        }


        System.out.println("# 도굴꾼의 역경 #");
        System.out.println("  !Grand Open!");
        System.out.println();

        System.out.println("1. 접속하기");
        System.out.println("2. 종료하기");
        System.out.print("\n\n\n입력 >> ");

        char select = scanner.nextLine().charAt(0);

        /*ThreadLocalRandom.current().ints(1, 100).limit(5).forEach(x->{
            System.out.println(x);
        });*/

        if(select == '1'){
            while(returnvalue == -1){
                returnvalue = menu();
                System.out.println(returnvalue);
                if(returnvalue == 1){
                    returnvalue = menumystatus();

                    if(returnvalue == 11){
                        if(newplayer){
                            newplayer = false;
                            System.out.print("닉네임을 입력하세요 : ");
                            String username = scanner.nextLine().toString();
                            ud.setusername(username);
                            ud.fileExistCheck();
                        }
                        cleanScreen();
                        ud.userData();
                        ud.getInventory().loadInventory();
                        ud.showAllData();
                        String back = "1" + scanner.nextLine().toString();

                        returnvalue = -1;
                    }
                    else if(returnvalue == 12){
                        ud.getInventory().inventoryUI();
                    }
                }
                else if(returnvalue == 2){
                    returnvalue = menuoutdoor();
                }

                if(returnvalue == 21)
                    returnvalue = menufield();
                else if(returnvalue == 22)
                    returnvalue = menucave();
            }
        }
    }

    public static void cleanScreen(){
        for(int i = 0; i < 40 ; i++){
            System.out.println();
        }
    }

    public static int menu(){
        cleanScreen();
        System.out.println("# 도굴꾼의 역경 #");
        System.out.println();
        System.out.println("메뉴 선택하기");
        System.out.println("1. 내 상태");
        System.out.println("2. 외출하기");
        System.out.println("3. 잠자기(종료)");
        System.out.print("\n\n\n입력 >> ");
        char select = scanner.nextLine().charAt(0);

        if(select == '1')
            return 1;
        else if(select == '2')
            return 2;
        else if(select == '3')
            return 3;
        else
        return -1;
    }
    public static int menumystatus(){
        cleanScreen();
        System.out.println("# 도굴꾼의 역경 #");
        System.out.println();
        System.out.println("메뉴 선택하기");
        System.out.println("1. 내 정보");
        System.out.println("2. 인벤토리");
        System.out.println("3. 이전으로");
        System.out.print("\n\n\n입력 >> ");
        char select = scanner.nextLine().charAt(0);

        if(select == '1')
            return 11;
        else if(select == '2')
            return 12;
        else if(select == '3')
            return -1;
        else
            return -1;
    }
    public static int menumyinventory(){
        return 0;
    }
    public static int menuoutdoor(){
        cleanScreen();
        System.out.println("# 도굴꾼의 역경 #");
        System.out.println();
        System.out.println("메뉴 선택하기");
        System.out.println("1. 주변 탐색");
        System.out.println("2. 동굴 입장");
        System.out.println("3. 이전으로");
        System.out.print("\n\n\n입력 >> ");
        char select = scanner.nextLine().charAt(0);

        if(select == '1')
            return 21;
        else if(select == '2')
            return 22;
        else if(select == '3')
            return -1;
        else
            return -1;
    }
    public static int menufield(){
        cleanScreen();
        System.out.println("# 도굴꾼의 역경 #");
        System.out.println();
        System.out.println("메뉴 선택하기");
        System.out.println("1. 마을 입장");
        System.out.println("2. 떠돌이 상인과 거래");
        System.out.println("3. 이전으로");
        System.out.print("\n\n\n입력 >> ");
        char select = scanner.nextLine().charAt(0);

        if(select == '1')
            return 211;
        else if(select == '2')
            return 212;
        else if(select == '3')
            return 2;
        else
            return -1;
    }
    public static int menucave(){
        cleanScreen();
        System.out.println("# 도굴꾼의 역경 #");
        System.out.println();
        System.out.println("메뉴 선택하기");
        System.out.println("1. 동굴 정보조회");
        System.out.println("2. 동굴 입장하기");
        System.out.println("3. 이전으로");
        System.out.print("\n\n\n입력 >> ");
        char select = scanner.nextLine().charAt(0);

        if(select == '1')
            return 221;
        else if(select == '2')
            return 222;
        else if(select == '3')
            return 2;
        else
            return -1;
    }

    public static List<List<String>> getItemList() {
        return itemList;
    }
}

class Monster{
    private int statpoint = 0;
    public Monster(){
        Random statpoint = new Random();
        this.statpoint= statpoint.nextInt(100);
    }
    public int getstatpoint(){
        return this.statpoint;
    }
}

class Timer extends Thread{
    private int sec;

    @Override
    public void run(){
        while(true){
            try{
                showSec();
                sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private void showSec(){
        System.out.println(++sec + "초");
    }
}