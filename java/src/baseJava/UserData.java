package baseJava;

import java.io.*;
import java.util.*;
import java.util.Timer;

class UserData{
    private String username;
    private long money;
    private int level;
    private int stemina;
    private String location;
    private String date;
    private String filePath;
    private String filePath2;
    private Inventory inventory;
    private boolean fileExist;

    public void userData() throws IOException {
        if(!fileExist){
            money = 0;
            level = 1;
            stemina = 50;
            location = "금련산 쉼터";
            date = "2019-01-01";
            saveUserData();
        }
        loadUserData();
        inventory = new Inventory(username);
    }
    public void fileExistCheck(){
        File file = new File(filePath);

        if(file.isFile()){
            fileExist = true;
        }
        else
            fileExist = false;
    }

    public String getusername(){
        return username;
    }
    public long getmoney(){
        return money;
    }
    public int getlevel(){
        return level;
    }
    public int getstemina(){
        return stemina;
    }
    public String getlocate(){
        return location;
    }
    public String getdate(){
        return date;
    }

    public void setusername(String username){
        this.username = username;
        this.filePath = username + "_data.txt";
        this.filePath2 = username + "_inventory.txt";
    }
    public void setmoney(long money){
        this.money = money;
    }
    public void setlevel(int level){
        this.level = level;
    }
    public void setstemina(int stemina){
        this.stemina = stemina;
    }
    public void setlocate(String locate){
        this.location = locate;
    }
    public void setdate(String date){
        this.date = date;
    }

    public void showAllData(){
        System.out.println("##### 내 정보 조회 #####\n");
        System.out.println("닉 네 임 : " + username);
        System.out.println("소 지 금 : " + money);
        System.out.println("레    벨 : " + level);
        System.out.println("스테미너 : " + stemina);
        System.out.println("장    소 : " + location);
        System.out.println("날    짜 : " + date);
        System.out.println("\n\n이전으로 돌아가려면 엔터를 입력하세요.");
    }

    public void saveUserData() throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
            FileOutputStream inventoryOutputStream = new FileOutputStream(filePath2, true);
            String datalist = username + "@" + money + "@" + level + "@" + stemina + "@" + location + "@" + date + "\n";
            byte[] datalistbyte = datalist.getBytes();
            fileOutputStream.write(datalistbyte);
            fileOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadUserData() throws IOException{
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String cur = null;
            String readdata = "";
            LinkedList<String> userdata = new LinkedList<>();
            while((cur = reader.readLine()) != null){
                //System.out.println(cur);
                readdata += cur;
            }
            reader.close();
            String[] hadSplit = readdata.split("@");
            money = Long.parseLong(hadSplit[1]);
            level = Integer.parseInt(hadSplit[2]);
            stemina = Integer.parseInt(hadSplit[3]);
            location = hadSplit[4];
            date = hadSplit[5];
        }
        catch (FileNotFoundException e){
            e.getStackTrace();
        }
        catch (IOException e){
            e.getStackTrace();
        }
    }
    public void timer(){
        java.util.Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            }
        };
        timer.schedule(task, 1000);
    }

    public Inventory getInventory() {
        return inventory;
    }
}