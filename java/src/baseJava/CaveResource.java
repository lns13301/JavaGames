package baseJava;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

class CaveResources{
    private int cave_level;
    Deque<String> resource_package = new ArrayDeque<>();

    public CaveResources(int cave_level){
        this.cave_level = cave_level;
    }

    public void generatorResources(){
        Random resource_generator = new Random();
        int resource;
        Deque<String> resource_package = new ArrayDeque<>();

        if(cave_level == 1){
            for(int i = 0; i < 500 ; i++){
                resource = resource_generator.nextInt(1000);
                if(resource >= 0 && resource < 70 ){
                    resource_package.offerFirst("부스러지는 석탄");
                }
                else if(resource >= 70 && resource < 75 ){
                    resource_package.offerFirst("불순물이 섞인 금광석");
                }
                else if(resource >= 75 && resource < 100 ){
                    resource_package.offerFirst("산화가 진행된 철광석");
                }
                else if(resource >= 100 && resource < 600 ){
                    resource_package.offerFirst("돌 파편");
                }
                else if(resource >= 600 && resource < 700 ){
                    resource_package.offerFirst("화강암 파편");
                }
                else if(resource >= 700 && resource < 800 ){
                    resource_package.offerFirst("섬록암 파편");
                }
                else if(resource >= 800 && resource < 900 ){
                    resource_package.offerFirst("안산암 파편");
                }
                else if(resource >= 900 && resource < 950 ){
                    resource_package.offerFirst("흩날리는 자갈");
                }
                else if(resource >= 950 && resource < 1000 ){
                    resource_package.offerFirst("질나쁜 흙");
                }
            }
        }
        else if(cave_level == 2){
            for(int i = 0; i < 500 ; i++){
                resource = resource_generator.nextInt(1000);
                if(resource >= 0 && resource < 70 ){
                    resource_package.offerFirst("부드러운 석탄");
                }
                else if(resource >= 70 && resource < 75 ){
                    resource_package.offerFirst("보통 금광석");
                }
                else if(resource >= 75 && resource < 100 ){
                    resource_package.offerFirst("보통 철광석");
                }
                else if(resource >= 100 && resource < 600 ){
                    resource_package.offerFirst("돌 파편");
                }
                else if(resource >= 600 && resource < 700 ){
                    resource_package.offerFirst("화강암 파편");
                }
                else if(resource >= 700 && resource < 800 ){
                    resource_package.offerFirst("섬록암 파편");
                }
                else if(resource >= 800 && resource < 900 ){
                    resource_package.offerFirst("안산암 파편");
                }
                else if(resource >= 900 && resource < 950 ){
                    resource_package.offerFirst("보통 자갈");
                }
                else if(resource >= 950 && resource < 1000 ){
                    resource_package.offerFirst("보통 흙");
                }
            }
        }
        this.resource_package = resource_package;
    }
}