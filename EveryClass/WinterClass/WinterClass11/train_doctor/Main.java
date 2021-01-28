package train_doctor;

import javax.print.Doc;

public class Main {
    private static Person[] train() {
        Person[] array = new Person[10];
        for (int i = 0; i < 5; i++) {
            array[i] = new Teacher();
        }
        array[5] = new Doctor();
        for (int i = 6; i < 10; i++) {
            array[i] = new Student();
        }

        return array;
    }

    public static void main(String[] args) {
        Person[] array = train();

        for (int i = 0; i < array.length; i++) {
            Person p = array[i];
            if (p instanceof Doctor) {
                System.out.println("下标是 " + i + " 的乘客是医生");
                Doctor d = (Doctor)p;
                d.rescue();
            }
            //else {
//                System.out.println("不是医生，冒充医生");
//                Doctor d = (Doctor)p;
//                d.rescue();
//            }
        }
    }
}
