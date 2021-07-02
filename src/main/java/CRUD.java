import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CRUD {

    BufferedReader br;

    public void readData(ArrayList<DataManage> list) {

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        //System.out.println("No Name Kor Eng Math Sum Avg Grade RegDate");
        //System.out.println("==========================================");
        for (DataManage d: list) {
            System.out.println(d.toString());
        }
    }

    public DataManage createData(ArrayList<DataManage> list) throws IOException{

        int num;
        String name;
        String regiDate;
        String part;
        int numOfSets;
        int reps;
        int weight;
        String exercise;

        num = list.size();

        System.out.print("이름 : ");
        br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();
        System.out.print("부위 : ");
        part = br.readLine();
        System.out.print("운동 : ");
        exercise =br.readLine();
        System.out.print("셋트수 : ");
        numOfSets = Integer.parseInt(br.readLine());
        System.out.print("횟수 : ");
        reps = Integer.parseInt(br.readLine());
        System.out.print("무게(kg) : ");
        weight = Integer.parseInt(br.readLine());

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        regiDate = date.format(formatter);

        DataManage d = new DataManage( num, regiDate, name, part,exercise, numOfSets, reps,
                weight);

        return d;
    }

    public void updateData(ArrayList<DataManage> list){

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        try {
            System.out.print("수정하고 싶은 스케쥴의 번호를 입력하시오(1~100) : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine()) - 1;
            if(Main.valid(list, num)) {
                System.out.print("이름 : ");
                list.get(num).setName(br.readLine());
                System.out.print("부위 : ");
                list.get(num).setPart(br.readLine());
                System.out.print("운동 : ");
                list.get(num).setExercise(br.readLine());
                System.out.print("셋트수 : ");
                list.get(num).setNumOfSets(Integer.parseInt(br.readLine()));
                System.out.print("횟수 : ");
                list.get(num).setReps(Integer.parseInt(br.readLine()));
                System.out.print("무게(kg) : ");
                list.get(num).setWeight(Integer.parseInt(br.readLine()));

                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String regDate = date.format(formatter);
                list.get(num).setRegiDate(regDate);
            } else {
                System.out.println("작성된 스케쥴이 없는 번호입니다.");
                updateData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(ArrayList<DataManage> list){

        if( list.size() == 0 ){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        try {
            System.out.println("삭제하고 싶은 스케쥴의 번호를 입력하시오(1 ~ 100) : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine()) - 1;
            if(Main.valid(list, num)) {
                list.remove(num);
                for(int i=0; i < list.size(); i++)
                    list.get(i).setNum(i);
            }else {
                deleteData(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
