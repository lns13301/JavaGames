package baseJava;

import java.io.*;
import java.util.*;
import java.util.Timer;

class Inventory{

    private String username;
    private String filePath;
    Map<Integer,Integer>itemList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public Inventory(String username) throws IOException {
        this.username = username;
        filePath = username + "_inventory.txt";
        loadInventory();
    }

    public void loadInventory() throws IOException{
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String cur = null;
            String readdata = "";
            LinkedList<String> inventorylist = new LinkedList<>();
            while((cur = reader.readLine()) != null){
                String[] split = cur.split("@");
                itemList.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            e.getStackTrace();
        }
        catch (IOException e){
            e.getStackTrace();
        }
    }

    public void addItem(Integer itemCode,Integer count) throws IOException {
        if(itemList.containsKey(itemCode))
            itemList.put(itemCode,itemList.get(itemCode)+count);
        else
            this.itemList.put(itemCode,count);
        saveInventory(itemCode, count);
    }

    public void saveInventory(Integer itemCode,Integer count) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath, false);
        itemList.forEach((a,b)->{
            try {
                fileOutputStream.write((a + "@" + b + "\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
}

    public void showInventory(){
        itemList.forEach((a, b)->{
            Main.getItemList().forEach(x->{
                if(Integer.parseInt(x.get(0)) == a){
                    System.out.println("아이템이름 : " + x.get(1)  + "   개수 : " + b);
                }
            });

        });
    }

    public void inventoryUI() throws IOException {
        while (true) {
            System.out.println("# 도굴꾼의 역경 #");
            System.out.println();
            System.out.println("인벤토리 메뉴 선택하기");
            System.out.println("1. 아이템 추가하기");
            System.out.println("2. 아이템 삭제하기");
            System.out.println("3. 아이템 리스트 보기");
            System.out.println("4. 잠자기(종료)");
            System.out.print("\n\n\n입력 >> ");
            char select = scanner.nextLine().charAt(0);
            if(select == '1'){
                makeCentre();
            }
            else if(select == '2'){

            }
            else if(select == '3'){
                showInventory();
            }
            else
                break;
        }
    }

    public void makeCentre() throws IOException {
        System.out.println("아이템코드@갯수");
        String[] split = scanner.nextLine().split("@");
        addItem(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}