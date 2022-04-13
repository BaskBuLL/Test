//package top.baskbull;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
///**
// * @author liuzhuo
// * @date 2021/12/4 7:43 下午
// */
//public class TestComparator {
//
//    public static void main(String[] args) {
////        Student a = new Student(1L, "a", 5);
////        Student b = new Student(2L, "b", 1);
////        Student c = new Student(3L, "c", 2);
////        Student d = new Student(4L, "d", 3);
////        Student g = null;
//////        Student e = new Student(5L, "e", null);
////        Student f = new Student(6L, "b", 1);
////        Student z = new Student(6L, "c", 1);
////        List<Student> students = Arrays.asList(a, b, c, d, g, f);
////        students.sort(new Comparator<Student>() {
////            @Override
////            public int compare(Student o1, Student o2) {
////                if(o1.getClassId() > o2.getClassId()){
////                    return -1;
////                }
////                return o1.getClassId().equals(o2.getClassId()) ? 0 : 1;
////            }
////        });
////        students.sort(Comparator.comparingInt(Student::getClassId).reversed());
//        List<Student> collect = students.stream().filter(Objects::nonNull)
//                .sorted(Comparator.comparing(Student::getClassId, Comparator.nullsFirst(Comparator.naturalOrder())))
//                .collect(Collectors.toList());
//        set(collect);
//        System.out.println(collect);
//
//        List<Integer> list = Arrays.asList(1);
//        List<Integer> collect1 = list.stream().sorted((o1, o2) -> {
//            Integer oo1 = Objects.requireNonNull(o1);
//            Integer oo2 = Objects.requireNonNull(o2);
//            if (oo1 > oo2) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }).collect(Collectors.toList());
//        System.out.println(collect1);
//
//        Integer i = 5;
//
//        switch (i){
//            case 1:
//                System.out.println(1);
//                break;
//            case 2:
//                System.out.println(2);
//                break;
//            case 5:
//                System.out.println(5);
//                break;
//            default:
//                System.out.println("error");
//        }
//    }
//
//    private static void set(List<Student> studentList) {
//        for (Student student : studentList) {
//            if (student.getClassId().equals(1)) {
//                if ("b".equals(student.getName())) {
//                    student.setName("hhhhhhhhhhhhhhhhhh");
//                    break;
//                }
//            } else {
//                break;
//            }
//        }
//    }
//}
