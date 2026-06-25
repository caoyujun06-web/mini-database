import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        Scanner sc = new Scanner(System.in);
        while(true){
            String command = sc.nextLine();
            command = command.trim();
            if(command.isEmpty()){
                continue;
            }
            String[] parts =  command.split(" ");
            if ((parts[0].toUpperCase()).equals("INSERT")) {
                if(parts.length != 3){
                    System.out.println("Error");
                    continue;
                }
                try{
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    db.insert(id, name);
                    System.out.println("Inserted");
                }catch(NumberFormatException e){
                    System.out.println("Error");
                }




            } else if ((parts[0].toUpperCase()).equals("SELECT")) {
                if(parts.length != 2){
                    System.out.println("Error");
                    continue;
                }
                try {
                    int id = Integer.parseInt(parts[1]);
                    Record res =  db.select(id);
                    if (res == null) {
                        System.out.println("No such record");
                    } else {
                        System.out.println(res);
                    }
                }catch(NumberFormatException e){
                    System.out.println("Error");
                }


            } else if ((parts[0].toUpperCase()).equals("DELETE")) {
                if(parts.length != 2){
                    System.out.println("Error");
                    continue;
                }
                try {
                    int id = Integer.parseInt(parts[1]);
                    Boolean succ = db.delete(id);
                    if(succ){
                        System.out.println("Record deleted successfully");
                    }else {
                        System.out.println("No such record");
                    }
                }catch(NumberFormatException e){
                    System.out.println("Error");
                }


            } else if ((parts[0].toUpperCase()).equals("EXIT")) {
                db.save();
                break;

            }
        }
    }
}