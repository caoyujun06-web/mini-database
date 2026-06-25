    import java.io.*;
    import java.util.HashMap;
    public class Database {
        private AVLTree tree;
        public Database() {
            tree = new AVLTree();
            load();
        }
        public void insert(int id, String name) {
            Record record = new Record(id, name);

            tree.insert(id, record);
        }

        public Record select(int id) {
            return tree.search(id);
        }

        public boolean delete(int id) {
            return tree.delete(id);
        }
        public void save(){
            try(BufferedWriter bw=
                        new BufferedWriter(
                                new FileWriter("database.txt"));){
                for(Record record : tree.findAll()){
                    bw.write(record.getId() + "," + record.getName());
                    bw.newLine();

                }
            }catch(IOException e){
                e.printStackTrace();
            }

        }
        public void load(){
            try(BufferedReader br = new BufferedReader(new FileReader("database.txt"))){
                String line;
                while((line = br.readLine())!=null){

                    String[] parts = line.split(",");
                    if (parts.length != 2) {
                        continue;
                    }
                    try{
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        insert(id, name);
                    }catch(NumberFormatException e){
                        continue;
                    }
                }
            }catch(FileNotFoundException e){
                return;
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
