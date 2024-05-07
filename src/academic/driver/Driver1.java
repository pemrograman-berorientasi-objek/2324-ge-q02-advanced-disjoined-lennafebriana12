package academic.driver;

import academic.model.Course;
import academic.model.CourseOpening;
import academic.model.Lecturer;
import academic.model.Student1;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.*;

/**
 * @author 12S22008 Rahel Simanjuntak
 * @author 12S22017 Lenna Febriana
 */

public class Driver1 {

   
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        HashMap<String, Enrollment> enrollmentMap = new HashMap<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Student1> students1 = new ArrayList<>();
        ArrayList<CourseOpening> coursesopening = new ArrayList<>();
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        ArrayList<Enrollment> enrollments1 = new ArrayList<>();
        HashMap<String, Double> gradeValues = new HashMap<>();
        LinkedHashMap<String, Enrollment> enrollmentMapo = new LinkedHashMap<>();
        
        
        gradeValues.put("A", 4.0);
        gradeValues.put("AB", 3.5);
        gradeValues.put("B", 3.0);
        gradeValues.put("BC", 2.5);
        gradeValues.put("C", 2.0);
        gradeValues.put("D", 1.0);
        gradeValues.put("E", 0.0);
        gradeValues.put("None", 0.0);

        
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] parts = input.split("#");
            String command = parts[0];

            switch (command) {
                case "course-add":
                Course newCourse = new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
               
                courses.add(newCourse);
                break;

                case "course-open":
                String course_code = parts[1];
                String academicyear = parts[2];
                String semester = parts[3];
                String lecturerInitialsInput = parts[4];
                String email="";
                String[] lecturerInitials = lecturerInitialsInput.split(",");
                Course course1 = courses.stream()
                    .filter(c -> c.getCode().equals(course_code))
                    .findFirst()
                    .orElse(null);
                Lecturer lectur = lecturers.stream()
                    .filter(c -> Arrays.asList(lecturerInitials).contains(c.getInitial()))
                    .findFirst()
                    .orElse(null);
                if (course1 != null && lectur != null) {
                    for(int i=0;i<lecturerInitials.length;i++){
                        String lecString= lecturerInitials[i];
                        for (Lecturer lecturer1 : lecturers) {
                            if(lecturer1.getInitial().equals(lecString)){
                                if(i !=0){
                                    email+=";";
                                }
                                email+=lecturer1.getInitial()+" ("+lecturer1.getEmail()+")";
                            }
                        }
                    }
                }
                CourseOpening courseOpening = new CourseOpening(course_code,academicyear,semester, email);
                coursesopening.add(courseOpening);
                break;
                
                case "course-history":
                Set<String> printed = new HashSet<>();
                Collections.sort(coursesopening, (CourseOpening co1, CourseOpening co2) -> {
                    if (co1.getSemester().equals("odd") && !co2.getSemester().equals("odd")) {
                        return -1;
                    } else if (!co1.getSemester().equals("odd") && co2.getSemester().equals("odd")) {
                        return 1;
                    } else {
                        return 0;
                    }
                });
                for(CourseOpening courseOpening1:coursesopening){
                    String name="";
                    String credit="";
                    String passinggrade="";
                    for (Course course2: courses){
                        if(course2.getCode().equals(parts[1])&& course2.getCode().equals(courseOpening1.getCourse_Code())){
                            name=course2.getName();
                            credit=String.valueOf(course2.getCredits());
                            passinggrade=course2.getPassingGrade();
                            System.out.println(courseOpening1.getCourse_Code()+"|"+name+"|"+credit+"|"+passinggrade+"|"+courseOpening1.getAcademicyear()+"|"+courseOpening1.getSemester()+"|"+courseOpening1.string(courseOpening1.getString()));
                        }
                    }
                    for(Enrollment enrollment : enrollments) {
                            if(enrollment.getCourseId().equals(courseOpening1.getCourse_Code())&&enrollment.getCourseId().equals(parts[1])&&enrollment.getAcademicyear().equals(courseOpening1.getAcademicyear()) && enrollment.getSemester().equals(courseOpening1.getSemester())) {
                                String output;
                                if(!enrollment.getBack().equals("")) {
                                    output = enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicyear() + "|" + enrollment.getSemester() + "|" + enrollment.getGradeValue() + "(" + enrollment.getBack() + ")";
                                } else {
                                    output = enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicyear() + "|" + enrollment.getSemester() + "|" + enrollment.getGradeValue();
                                }
                                if (!printed.contains(output)) {
                                    System.out.println(output);
                                    printed.add(output);
                                }
                            }  
                        }
                    }
               
                break;
               
                case "student-add":
                    Student student = new Student(parts[1], parts[2], parts[3], parts[4]);
                    students.add(student);
                    break;

                case "lecturer-add":
                    Lecturer lecturer = new Lecturer(parts[1], parts[2], parts[3], parts[4], parts[5]);
                    lecturers.add(lecturer);
                    break;

                case "enrollment-add":
                    String courseId = parts[1];
                    String studentId1 = parts[2];
                    String academicYear = parts[3];
                    String semester1 = parts[4];
                  
                    if (!enrollmentMap.containsKey(parts[1] + "#" + parts[2] + "#" + parts[3] + "#" + parts[4])) {
                        Enrollment newEnrollment = new Enrollment(parts[1], parts[2], parts[3], parts[4]);
                        enrollments.add(newEnrollment);
                        enrollmentMap.put(parts[1] + "#" + parts[2] + "#" + parts[3], newEnrollment);   
                    }
                    break;
               
                case "enrollment-grade":
                    // Memeriksa apakah pendaftaran ada di enrollmentMap sebelum mengatur nilai grade
                    String enrollmentGradeKey = parts[1] + "#" + parts[2] + "#" + parts[3];
                    if (enrollmentMap.containsKey(enrollmentGradeKey)) {
                        enrollmentMap.get(enrollmentGradeKey).setGrade(parts[5]);
                    }

                    break;

                case "enrollment-remedial":
                    for (Enrollment enrollment : enrollments) {
                        if (enrollment.getCourseId().equals(parts[1]) &&
                            enrollment.getStudentId().equals(parts[2]) &&
                            enrollment.getAcademicyear().equals(parts[3]) &&
                            enrollment.getSemester().equals(parts[4]) && enrollment.getGrade() != "None") {

                             // check if grade has been set
                        if (enrollment.getGrade() == null || enrollment.getGrade().equals("None")) {
                            System.out.println("");
                            break;
                            }
                        if (enrollment.getRemedialCount() == 0) {
                            enrollment.setBack(parts[5]);
                            enrollment.resetBack();
                            enrollment.addRemedialCount();
                        } else {
                            String previousGrade = enrollment.getGradeValue();
                            enrollment.setRemedial(previousGrade + "(" + parts[5] + ")");
                            }
                            break;  
                        }
                    }
                    break;

                case "student-details":
                    String studentId = parts[1];
                    String[] matkulStrings = new String[5];
                    String[] gradeStrings = new String[5];
                    double totalGradePoints = 0.0;
                    int creditStrings = 0;
                    int x = 0;
                
                    for (Enrollment enrollment : enrollments) {
                        if (enrollment.getStudentId().equals(studentId)) {
                            matkulStrings[x] = enrollment.getCourseId();
                            gradeStrings[x] = enrollment.getGrade();
                            x++;
                        }
                    }
            
                    // Removing duplicate matkul and grade
                    for (int y = 0; y < x; y++) {
                        for (int z = y + 1; z < x; z++) {
                            if (matkulStrings[y].equals(matkulStrings[z])) {
                                matkulStrings[y] = null;
                                gradeStrings[y] = null;
                            }
                        }
                    }
                
                    for (int i = 0; i < x; i++) {
                        if (matkulStrings[i] != null && gradeStrings[i] != null) {
                            for (Course course : courses) {
                                if (course.getCode().equals(matkulStrings[i])) {
                                    totalGradePoints += gradeValues.get(gradeStrings[i]) * course.getCredits();
                                    creditStrings += course.getCredits();
                                }
                            }
                        }
                    }
                
                    double gpaRounded = Math.round(totalGradePoints / creditStrings * 100.0) / 100.0;
                    final int finalCreditStrings = creditStrings;
                    students.stream()
                        .filter(s -> s.getId().equals(studentId))
                        .findFirst()
                        .ifPresent(student1 -> {
                            Student1 student1Obj = new Student1(student1.getId(), student1.getName(), student1.getAngkatan(), student1.getInitial(), gpaRounded, finalCreditStrings);
                            students1.add(student1Obj);
                        });
                    break;

                    case "student-transcript":

                    String studentIdo = parts[1];
                
                    enrollments.sort(Comparator.comparing(Enrollment::getAcademicyear)
                        .thenComparing(Enrollment::getSemester));
                   
                    for (Enrollment enrollment : enrollments) {
                        if (enrollment.getStudentId().equals(studentIdo)) {
                            enrollmentMapo.put(enrollment.getCourseId(), enrollment);
                        }
                    }
                
                    class Transcript {
                    double totalGradePoints1 = 0.0;
                    int creditStrings1 = 0;
                        void process() {
                            for (Map.Entry<String, Enrollment> entry : enrollmentMapo.entrySet()) {
                                Enrollment enrollment = entry.getValue();
                                for (Course course : courses) {
                                    if (course.getCode().equals(enrollment.getCourseId())) {
                                        totalGradePoints1 += gradeValues.get(enrollment.getGradeValue()) * course.getCredits();
                                        creditStrings1 += course.getCredits();
                                    }
                                }
                            }
                
                            double gpaRounded1 = Math.round(totalGradePoints1 / creditStrings1 * 100.0) / 100.0;
                            final int finalCreditStrings1 = creditStrings1;
                            students.stream()
                                .filter(s -> s.getId().equals(studentIdo))
                                .findFirst()
                                .ifPresent(student1 -> {
                                    Student1 student1Obj = new Student1(student1.getId(), student1.getName(), student1.getAngkatan(), student1.getInitial(), gpaRounded1, finalCreditStrings1);
                                    students1.add(student1Obj);
                                });
                            }
                        }
                    new Transcript().process();
                    break;

                    
            }
        }         
        students1.forEach(System.out::println);
        for (Map.Entry<String, Enrollment> entry : enrollmentMapo.entrySet()) {
            Enrollment enrollment = entry.getValue();
            if (enrollment.getRemedialCount() > 0) {
                System.out.println(enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicyear() + "|" + enrollment.getSemester() + "|" + enrollment.getGradeValue() + "(" + enrollment.getBack() + ")");
            } else {
                System.out.println(enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicyear() + "|" + enrollment.getSemester() + "|" + enrollment.getGradeValue());
            }
        }

        lecturers.forEach(System.out::println);
        courses.forEach(System.out::println);
        students.forEach(System.out::println);

        enrollments.sort((Enrollment e1, Enrollment e2) -> {
            if (e1.getSemester().equals("odd") && !e2.getSemester().equals("odd")) {
                return -1;
            } else if (!e1.getSemester().equals("odd") && e2.getSemester().equals("odd")) {
                return 1;
            } else {
                return 0;
            }
        });
        
        for(Enrollment enrollment : enrollments) {
            if(enrollment.getRemedialCount() > 0) {
                System.out.println(enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicyear() + "|" + enrollment.getSemester() + "|" + enrollment.getGradeValue() + "(" + enrollment.getBack() + ")");
            } else {
                System.out.println(enrollment.getCourseId() + "|" + enrollment.getStudentId() + "|" + enrollment.getAcademicyear() + "|" + enrollment.getSemester() + "|" + enrollment.getGradeValue());
            }
        }

        // for(Enrollment enrollment : enrollments) {
        //     if(enrollment.getRemedialCount() > 0) {
        //         System.out.println(enrollment.getStudentId() + "|" + enrollment.getGradeValue() + "/" + enrollment.getBack());
        //     } 
        // }

        sc.close();
    }
}
