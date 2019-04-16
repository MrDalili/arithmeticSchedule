package test;

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i<11){
                if (i<10){
                    if (i<12){
                        if (i>6){
                            System.out.println(i);
                            break;
                        }else {
                            System.out.println(i+1);
                            break;
                        }
                    }
                }
            }else {
                continue;
            }

        }
    }
}
