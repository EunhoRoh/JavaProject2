import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<DataManage> list;

        MenuShow m = new MenuShow();
        CRUD crudService = new CRUD();
        SearchService searchService = new SearchService();
        FileService fileService = new FileService();

        list = fileService.readFile();

        while(true) {
            try {
                String choose = m.showMenu();
                switch(choose){
                    case "1":
                        crudService.readData(list);
                        break;

                    case "2":
                        list.add(crudService.createData(list));
                        System.out.println("스케쥴이 추가되었습니다.");
                        break;

                    case "3":
                        crudService.readData(list);
                        crudService.updateData(list);
                        System.out.println("스케쥴이 수정되었습니다.");
                        break;

                    case "4":
                        crudService.readData(list);
                        crudService.deleteData(list);
                        System.out.println("스케쥴이 삭제되었습니다.");
                        break;

                    case "5":
                        searchService.searchBy(list, "name");
                        break;

                    case "6":
                        fileService.saveFile(list);
                        System.out.println("스케쥴이 파일에 저장되었습니다.");
                        break;

                    case "0":
                        System.out.println("종료");
                        return;

                    default:
                        System.out.println("잘못된 번호를 입력하셨습니다.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean valid(ArrayList<DataManage> list, int num) {
        // 배열 범위
        if (list.size() <= num || num == -1) {
            System.out.println("없는 번호 입니다.");
            return false;
        }
        return true;
    }

}