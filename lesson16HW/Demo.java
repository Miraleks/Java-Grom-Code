package lesson16HW;

public class Demo {
    public static void main(String[] args) {
        String test = "There is Test something new or jot sdf sdf sdf word Test op or"; //14
        String test1 = new String(); // 0
        String test2 = "SDF The3re is Te43st somethi3ng is is n2ew fo j4ot is ff f sdf sdf sdf wo3rd Te2st o2p o2r   3"; //3
        String address1 = null;
        String address2 = "http://wwW.someaddress.com";
        String address3 = "asmss:sometext";
        String address4 = "some text";
        String address5 = "https://www.someaddress.org";


//        System.out.println("countWords");
//        System.out.println(Solution.countWords(test));
//        System.out.println(Solution.countWords(test1));
//        System.out.println(Solution.countWords(test2));
//
//        System.out.println("maxWord");
//        System.out.println(Solution.maxWord(test)); //something
//        System.out.println(Solution.maxWord(test1)); // null
//        System.out.println(Solution.maxWord(test2)); // word
//        System.out.println("minWord");
//        System.out.println(Solution.minWord(test)); //is
//        System.out.println(Solution.minWord(test1)); // null
//        System.out.println(Solution.minWord(test2)); // is
//        System.out.println("mostCountedWord");
//        System.out.println(Solution.mostCountedWord(test)); //sdf
//        System.out.println(Solution.mostCountedWord(test1)); //null
//        System.out.println(Solution.mostCountedWord(test2)); //is

        System.out.println("1: " + Solution.validate(address1));
        System.out.println("2: " + Solution.validate(address2));
        System.out.println("3: " + Solution.validate(address3));
        System.out.println("4: " + Solution.validate(address4));
        System.out.println("5: " + Solution.validate(address5));

    }

}
