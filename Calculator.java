package calc.program;


import java.util.Scanner;

class TakeInput{
    TakeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("(int or 4 Byte) Enter First Number : ");
        SetNumber set = new SetNumber();
        set.setFirstNumber(sc.nextInt());
        System.out.print("\n(int or 4 Byte) Enter Second Number : ");
        set.setSecondNumber(sc.nextInt());
        new Operation(set);
        switch (set.getSign()){
            case '+':
                System.out.println("Addition Of Two Number is : " +set.getResult());
                break;
            case '-':
                System.out.println("Substraction Of Two Number is : " +set.getResult());
                break;
            case '*':
                System.out.println("Multiplication Of Two Number is : " +set.getResult());
                break;
            case '/':
                System.out.println("Division Of Two Number is : " +set.getResult());
                break;
            case '%':
                System.out.println("Modulo Of Two Number is : " +set.getResult());
                break;
            default:
                System.out.println("OOPS! SOMETHING WENT WRONG WHITH YOUR SIGN!!!!!!");
                new Operation(set);
        }
    }
}
class SetNumber{
    private int firstNumber;
    private int secondNumber;
    private int result;
    private char sign;
    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setResult(int result){
        this.result = result;
    }
    public int getResult(){
        return result;
    }
    public void setSign(char sign){
        this.sign = sign;
    }
    public char getSign(){
        return sign;
    }
}
class Operation{
    Operation(SetNumber set){
        Scanner sc = new Scanner(System.in);
            System.out.println("\nOperation : +, -, *, /, %");
            System.out.print("Enter the operation sign you want to Perform : ");
            char op = sc.next().charAt(0);
            if(op == '+' || op =='-' || op =='*' || op =='/' || op=='%' ) {
                int result = this.operation(op, set);
                if (result == Integer.MIN_VALUE) {
                    System.out.println("\nPlease Enter the right operation sign..?");
                    System.out.println("If You want to perform operation enter zero else anything : ");
                    if (sc.nextInt() != 0) {
                        System.exit(0);
                    }
                }
                set.setResult(result);
                set.setSign(op);
            }
            else {
                System.out.println("\nOperator not matched????");
                new TakeInput();
            }
    }
    private static int operation(char op, SetNumber set){
        int result = 0;
        switch (op){
            case '+':
                result =  set.getFirstNumber()+set.getSecondNumber();
                break;
            case '-':
                result =  set.getFirstNumber()-set.getSecondNumber();
                break;
            case '*':
                result =  set.getFirstNumber()*set.getSecondNumber();
                break;
            case '/':
                result =  set.getFirstNumber()/set.getSecondNumber();
                break;
            case '%':
                result = set.getFirstNumber()%set.getSecondNumber();
                break;
            default:
                result = Integer.MIN_VALUE;
        }
        return result;
    }
}
public class Calculator {
    public static void main(String[] args){
        System.out.println("NOTE: Here we are doing basic operation which we can see on Calculator"+
                "\nLike addition, substration, division, multiplication, modulo");
        Scanner sc = new Scanner(System.in);
        int value;
        do{
            new TakeInput();
            System.out.print("\n\nIf You want again perform operation enter positive or zero\nAnd if you " +
                    "do not want to perform enter negative value");
            value = sc.nextInt();
        }while(value>=0);
    }
}
