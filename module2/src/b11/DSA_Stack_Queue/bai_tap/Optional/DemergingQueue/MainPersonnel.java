package b11.DSA_Stack_Queue.bai_tap.Optional.DemergingQueue;


import java.util.*;

public class MainPersonnel implements Comparator<Personnel> {
    public static void main(String[] args) {
        List<Personnel> personnelList = new ArrayList<>();
        personnelList.add(new Personnel("Nguyễn Văn An", 23, "2/5/1998", "Nam"));
        personnelList.add(new Personnel("Nguyễn Thị Lan", 22, "3/1/1999", "Nữ"));
        personnelList.add(new Personnel("Hồ Đình Văn", 21, "13/12/2000", "Nam"));
        personnelList.add(new Personnel("Nguyễn Thị An", 18, "21/6/2003", "NỮ"));
        personnelList.add(new Personnel("Nguyễn Văn An", 24, "4/7/1997", "Nam"));
        personnelList.add(new Personnel("Trần Thị Trinh", 25, "8/3/1996", "NỮ"));
        personnelList.add(new Personnel("Nguyễn Văn Ân", 23, "19/2/1998", "Nam"));
        personnelList.sort(new MainPersonnel());
        Queue Nam = new ArrayDeque();
        Queue Nu = new ArrayDeque();
        for (Personnel person : personnelList
        ) {
            if (person.getGender().equals("Nam")) {
                Nam.add(person);
            } else {
                Nu.add(person);
            }
        }
        List personnelSort = new ArrayList();
        while (!Nu.isEmpty()) {
            personnelSort.add(Nu.remove());
        }
        while (!Nam.isEmpty()) {
            personnelSort.add(Nam.remove());
        }
        for (Object person : personnelSort
        ) {
            System.out.println(person);
        }
    }

    @Override
    public int compare(Personnel o1, Personnel o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}
