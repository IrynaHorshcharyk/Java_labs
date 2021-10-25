import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\iruna\\University\\3_course\\1\\kpp\\Lab3\\src\\Employee.txt"));
        ArrayList<Employee> list = new ArrayList<Employee>();
        while (s.hasNext()){
            list.add( new Employee(s.next()));
        }
        s.close();
        Scanner s1 = new Scanner(new File("C:\\Users\\iruna\\University\\3_course\\1\\kpp\\Lab3\\src\\Employee1.txt"));
        ArrayList<Employee> list1 = new ArrayList<Employee>();
        while (s1.hasNext()){
            list1.add( new Employee(s1.next()));
        }
        s1.close();
        Scanner s2 = new Scanner(new File("C:\\Users\\iruna\\University\\3_course\\1\\kpp\\Lab3\\src\\Employee2.txt"));
        ArrayList<Employee> list2 = new ArrayList<Employee>();
        while (s2.hasNext()){
            list2.add( new Employee(s2.next()));
        }
        s2.close();
        ArrayList<Employee> commonList = new ArrayList<Employee>();
        for(int i=0; i< list1.size();i++){
            Employee employee=list1.get(i);
            if(commonList.stream().filter(e -> e.getSurname().equals(employee.getSurname())).count()==0){
                commonList.add(employee);
            }
        }
        for(int i=0; i< list2.size();i++){
            Employee employee=list2.get(i);
            if(commonList.stream().filter(e -> e.getSurname().equals(employee.getSurname())).count()==0){
                commonList.add(employee);
            }
        }
        ArrayList<Employee> removeList=new  ArrayList<Employee>();
        for(int i=0; i< commonList.size();i++){
            if(commonList.get(i).getYear()<=2002){
               removeList.add(commonList.get(i));
            }
        }
        commonList.removeAll(removeList);

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i=0; i< list.size();i++){
            if(map.containsKey(list.get(i).position)){
                ArrayList<String> surnames =map.get(list.get(i).position);
                surnames.add(list.get(i).surname);
            }else {
                ArrayList<String> surnames =new ArrayList<String>();
                surnames.add(list.get(i).surname);
                map.put(list.get(i).position,surnames);
            }
        }
        Map<String,ArrayList<Employee>> mapSalary=new HashMap<String,ArrayList<Employee>>();
        ArrayList<Employee> l=new ArrayList<Employee>();
        ArrayList<Employee> a=new ArrayList<Employee>();
        ArrayList<Employee> h=new ArrayList<Employee>();
        for(int i=0; i< list.size();i++){
            Employee e=list.get(i);
            if(e.getSalary()<=100){
                l.add(e);
            }else if(e.getSalary()>100&& e.getSalary()<=200){
                a.add(e);
            }else{
                h.add(e);
            }
        }
        mapSalary.put("Low",l);
        mapSalary.put("Average",a);
        mapSalary.put("High",h);

        while (true) {
            System.out.println("1 - All map and for each position the oldest and youngest person\n2 - Maximum|minimum salary and map\n3 - Read from 2 files(Task 3)");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("All  map:");
                var keys = map.keySet();
                for (String key : keys){
                    var surnames = map.get(key);
                    System.out.println(key+ " : ");
                    for (String surname : surnames) {
                        System.out.println(surname+", ");
                    }
                }
                System.out.println("\nFor each position the oldest and youngest person:");
                for (String key : keys){
                    var surnames = map.get(key);
                    ArrayList<Employee> employees=new ArrayList<Employee>();
                    for (String surname : surnames) {
                        Employee employee=list.stream().filter(p -> p.getPosition().equals(key)&& p.getSurname().equals(surname)).findFirst().orElse(null);
                        employees.add(employee);
                    }
                    Comparator<Employee> comparator = new Comparator<Employee>() {
                        @Override
                        public int compare(Employee b1, Employee b2) {
                            return Double.compare(b1.year, b2.getYear());
                        }
                    };
                    employees.sort(comparator);
                    System.out.println(key+ " :");
                    System.out.println("oldest: "+employees.get(0).surname);
                    System.out.println("youngest: "+employees.get(employees.size()-1).surname);
                }

            }else if (choice == 2) {
                Comparator<Employee> comparator = new Comparator<Employee>() {
                    @Override
                    public int compare(Employee b1, Employee b2) {
                        return Double.compare(b1.salary, b2.getSalary());
                    }
                };
                list.sort(comparator);
                System.out.println("Min salary: "+list.get(0).getSalary());
                System.out.println("Max salary: "+list.get(list.size()-1).getSalary());
                System.out.println("All salary map:\n");
                var keys = mapSalary.keySet();
                for (String key : keys){
                    var employees = mapSalary.get(key);
                    System.out.println(key+ " : ");
                    for (Employee e :employees ) {
                        System.out.println(e.toString());
                    }
                }
            } else if (choice == 3) {
                System.out.println("Сommon map(without employees whose year of birth is more than 2002):");
                for(int i=0; i< commonList.size();i++){
                    System.out.println(commonList.get(i).toString());
                }
            }
        }
    }
}
