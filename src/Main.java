import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        int[] testArr = {1,2,3,4,5,6,7,8};  Использовалось для тэста.
//        int testShift = -3;
        // Первое задание.
        // Для каждого задания буду писать отдельный метод.
            int[] arr = {1, 0, 1, 1, 0, 0, 0, 1, 0};
            for (int i = 0; i < arr.length; i++ ) {
                if (arr[i] == 0) {
                    arr[i] += 1;
                } else {
                    arr[i] -= 1;
                }
            }
        System.out.println(Arrays.toString(arr));
            quest2();
            quest3();
            quest4();
            //           quest7(testArr,testShift);
//        System.out.println(Arrays.toString(testArr)); Использовалось для тэста.
    }

    //Второе задание.
    public static void quest2() {

        int[] arr = new int [8];

        for(int i = 1; i < arr.length; i++){
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }
    //Третье задание.
    public static void quest3() {

        int[] arr ={1,5,3,2,11,4,5,2,4,8,9,1};
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 6){
                arr[i] *= 6;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
    //Четвёртое задание.
    public static void quest4() {

        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };


        for (int i = 0; i < arr.length; i++) {  //идём по строкам
            for (int j = 0; j < arr.length; j++) {//идём по столбцам
                if(i == j){
                    arr[i][j] += 1;
                } else if (i + j == arr.length - 1){
                    arr[i][j] += 1;
                }
                System.out.print(" " + arr[i][j] + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }

    }
//Изначально я решил задачу таким образом. Но Idea попросил оптимизировать и после нажатия на авто оптимизацию у меня
// получилось решение которое не за коментировано.
//    public static void quest5() {
//        int[] arr = {2,23,5,7,8,45,3,89,4,7,6,1,43,56};
//
//        int maxNumArr = 0;
//        int minNumArr = 999999999;
//
//        for(int i = 0; i < arr.length; i++){
//            if( maxNumArr < arr[i]){
//                maxNumArr = arr[i];
//            }
//
//    }
//
//        for (int i = 0; i < arr.length; i++) {
//            if( minNumArr > arr[i] ){
//                minNumArr = arr[i];
//            }
//        }
//        System.out.println("максимальное значение массива " + maxNumArr);
//        System.out.println("Минимальное значение массива " + minNumArr);
//
//        }

    public static void quest5(int[] arr) {
      //  int[] arr = {2,23,5,7,8,45,3,89,4,7,6,1,43,56}; Было использована для проверки.

        int maxNumArr = 0;
        int minNumArr = 999999999;

        for (int value : arr) {
            if (maxNumArr < value) {
                maxNumArr = value;
            }

        }

        for (int value : arr) {
            if (minNumArr > value) {
                minNumArr = value;
            }
        }
        System.out.println("максимальное значение массива " + maxNumArr);
        System.out.println("Минимальное значение массива " + minNumArr);

    }

    public static void quest6(int[] arr) {

     //   int[] arr = {2,2,2,2,}; Использовал для проверки.
        int sumArr = 0;
        int balance = 0;
        boolean result = false;

            for(int i = 0; i < arr.length; i++){
                sumArr += arr[i];
            }
        int balanceCheck = sumArr /= 2;


            for(int i = 0; i < arr.length; i++){
                balance += arr[i];
                if(balance == balanceCheck){
                    result = true;
                }

            }
        System.out.println(result);

    }

    public static int[] quest7(int[] incomingArray, int shift) {
        if(shift != 0){
            // Любой сдвиг больше длины массива можно оптимизировать до меньшего сдвига
            // через деление по модулю

            int finalShift;
            if (shift > incomingArray.length){
                shift = Math.abs(shift % incomingArray.length);
            }
            else {
                finalShift = shift;
            }

            // в зависимости от знака сдвига движение будет происходить
            // слева направо при положительном сдвиге
            // справа налево при отрицательном
            if (shift > 0) {
                for (int n = 0; n < shift; n++) {
                    // убираем первый элемент в буфер, а на его место ставим хвостовой элемент
                    int buffer = incomingArray[0];
                    incomingArray[0] = incomingArray[incomingArray.length - 1];

                    // циклично сдвигаем весь массив
                    for (int j = 1; j < incomingArray.length - 1; j++) {
                        incomingArray[incomingArray.length - j] = incomingArray[incomingArray.length - j - 1];
                    }

                    // ставим буферный элемент в 1 ячейку
                    incomingArray[1] = buffer;
                }
            }
            else if (shift < 0) {
                for (int i = 0; i > shift; i--) {
                    int buffer = incomingArray[incomingArray.length - 1];
                    incomingArray[incomingArray.length - 1] = incomingArray[0];

                    for (int j = 1; j < incomingArray.length - 1; j++) {
                        incomingArray[j - 1] = incomingArray[j];
                    }

                    incomingArray[incomingArray.length - 2] = buffer;
                }
            }
        }

        return incomingArray;
    }

}

