package review.view;

import review.common.MyValidation;
import review.controller.StudentController;
import review.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AcademyManagement {
    public static void mainMenu() {
        do {
            System.out.println("""
                    1. Quản lý học viên
                    2. Quản lý giảng viên
                    3. Thoát
                    Vui lòng chọn trong menu""");
            int choice = getChoice();
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    teacherMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }

    private static int getChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public static void studentMenu() {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        do {
            System.out.println("""
                    1. Hiển thị dssv
                    2. Thêm mới sv
                    3. Chỉnh sửa sv
                    4. Xóa sv
                    5. Tìm kiếm sv
                    6. Trở về
                    Vui lòng chọn trong menu""");
            int choice = getChoice();
            switch (choice) {
                case 1:
                    studentController.findAll();
                    break;
                case 2:
                    Student student = inputStudentInformation(scanner);
                    studentController.saveStudent(student);
                    break;
                case 3:
                    //
                    break;
                case 4:
                    deleteStudent(scanner, studentController);
                    break;
                case 5:
                    searchStudentByName(scanner, studentController);
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

    private static void searchStudentByName(Scanner scanner, StudentController studentController) {
        System.out.println("Nhập tên học viên cần tìm: ");
        String name = scanner.nextLine();
        studentController.searchByName(name);
    }

    private static void deleteStudent(Scanner scanner, StudentController studentController) {
        System.out.println("Nhập id học viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = studentController.findById(id);
        System.out.println(s);
        System.out.println("""
                Bạn có chắc chắn xóa học viên này không?
                1. Có
                2. Không""");
        int confirm = getChoice();
        if (confirm == 1) {
            studentController.delete(s);
        }
    }

    public static Student inputStudentInformation(Scanner scanner) {

        String name;
        do {
            System.out.println("Nhập tên học viên");
            name = scanner.nextLine();
            if(name.isEmpty()){
                System.out.println("VUi lòng không để trống");
            }else if (!MyValidation.isValidName(name)) {
                System.out.println("Tên không chứa ký tự đặt biệt và số. Vui lòng nhập lại");
            } else {
                break;
            }
        } while (true);

        System.out.println("Nhập email học viên");
        String email = scanner.nextLine();
        String birthday;
        do {
            System.out.println("Nhập ngày sinh học viên");
            birthday = scanner.nextLine();
            if (!MyValidation.isValidFormatBirthday(birthday)) {
                System.out.println("...");
            } else {
                if(MyValidation.isValidAge(birthday)){
                    System.out.println("chua du tuoi");
                }else {
                    break;
                }
            }
        }while (true);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        System.out.println("Nhập lớp học viên");
        String className = scanner.nextLine();
        return new Student(name, email, localDate, className);
    }

    public static void teacherMenu() {
        System.out.println("""
                1. Hiển thị gv
                2. Thêm mới gv
                3. Chỉnh sửa gv
                4. Xóa gv
                5. Tìm kiếm gv
                6. Trở về
                Vui lòng chọn trong menu""");
    }

    public static void main(String[] args) {
        AcademyManagement.mainMenu();
    }
}
