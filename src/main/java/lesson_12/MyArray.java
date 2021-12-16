package lesson_12;

public class MyArray  {

    public int SummElement(String[][] arr) throws MyArrayDataException,MyArraySizeException {
        int result =0;
        if(arr.length > 4 || arr[0].length >4){
            throw new MyArraySizeException("Неправильный размер массива");
        }else{
            for (int i = 0; i< arr.length; i++){
                for (int j = 0; j<arr[i].length; j++){
                    try {
                        result += Integer.parseInt(arr[i][j]);
                    }catch(Exception e) {
                        throw new MyArrayDataException("в ячейке массива лежит что-то не то");
                    }
                }
            }
        }

        return result;
    }
}
