import java.io.*;

public class MenuShow {
    BufferedReader br;

    public String showMenu() throws IOException{
        System.out.println("******EXERCISE SCHEDULER******");
        System.out.println("1. 스케쥴 조회");
        System.out.println("2. 스케쥴 추가");
        System.out.println("3. 스케쥴 수정");
        System.out.println("4. 스케쥴 삭제");
        System.out.println("5. 스케쥴 저장");
        System.out.println("0. 종료");
        System.out.println("******************************");
        System.out.print("실행할 번호를 입력하시오 : ");

        br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

}