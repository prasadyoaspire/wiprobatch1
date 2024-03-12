
  public class ArrayDemo {

   public static void main(String[] args) {

   //array object creation

    int[] marks = new int[5];

   // assign values to the array

    marks[0] = 69;
    marks[1] = 58;
    marks[2] = 89;
    marks[3] = 70;
    marks[4] = 56;

    for(int i=0;i<marks.length;i++) {
        System.out.print(marks[i]+" ");
    }     

    char[] chs = new char[4];
    chs[0] = 'a';
    chs[1] = 'e';
    chs[2] = 'i';
    chs[3] = 'o';

     for(int i=0;i<chs.length;i++) {
        System.out.print(chs[i]+ " ");
    } 
      
   }

}