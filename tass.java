/*
 * in this assignment I made pascal tringle with 5 ways
 * their are three class 
 *      Pascal - for iterative pascal triangle;
 *      RecPascal - for recursive pascal triangle it has two type way to print pascal tringle
 *              - recpascal(int);
 *              - printrPascal(int);
 *      MemoPascal - it has same function as Recpascal the only difference it uses memoization consept to optmise speed
 * 
 * All function privew are Written in main function
 *      
 * 
 */
import java.util.HashMap;
import java.util.Map;
public class tass {
    public static void main(String args[])
    {
        //itration
        Pascal.prinrPascal(12);
        //recursion
        RecPascal.prinrPascal(12);
        RecPascal.recpascal(12);//fully recursive function
        //memoization
        MemoPascal.prinrPascal(12);
        MemoPascal.recpascal(12);
    }
}
class Pascal{
    public static int fact(int num)
    {
        int fac=1;
        for(int i=1;i<=num;fac*=i,i++);
        return fac;
    }
    public static int getNum(int row,int column)
    {
        row--;
        column--;
        return fact(row)/(fact(row-column)*fact(column));
    }
    public static void prinrPascal(int height)
    {
        int row,column,colp;
        boolean a=true;
        for(row=1;row<=height;row++)
        {
            a=true;
            colp=1;
            for(column=1;column<height*2;column++)
                if((column>height-row&&column<height+row)&&a)
                {
                     System.out.print(getNum(row, colp++));
                     a=false;
                }
                else
                {
                    System.out.print(" ");
                    if(a==false)
                        a=true;
                }
            System.out.print("\n");
        }
    }
}
class RecPascal{
    public static int fact(int num)
    {
        if(num==1||num==0)
            return 1;
        return num*fact(num-1);
    }
    public static int getNum(int row,int column)
    {
        row--;
        column--;
        return fact(row)/(fact(row-column)*fact(column));
    }
    public static void prinrPascal(int height)
    {
        int row,column,colp;
        boolean a=true;
        for(row=1;row<=height;row++)
        {
            a=true;
            colp=1;
            for(column=1;column<height*2;column++)
                if((column>height-row&&column<height+row)&&a)
                {
                     System.out.print(getNum(row, colp++));
                     a=false;
                }
                else
                {
                    System.out.print(" ");
                    if(a==false)
                        a=true;
                }
            System.out.print("\n");
        }
    }

    // Aternative recursive way to print pascal triangle
    // Disclamer it will voilate pattern
    public static int[] recpascal(int height)
    {
        /*this perticular function  which print pascal traiangle. ulike the privious function it does not need any 
        other function to work
        how it work
        it takes the desired height of pascal triangle as an argument and calcuate the current row value with value
        returned as an array from recalling itself. it keeps on recalling itself until it get to row one which is its base case
         */
        if(height==1)
        {
            System.out.println(1);
            int a[]=new int[1];
            a[0]=1;
            return a;
        }
        int a[]=new int[height-1];
        a=recpascal(height-1);
        int b[]=new int[height];
        
        System.out.printf("%d ",b[0]=1);
        for(int i=0;i<height-2;i++)
        {
            System.out.printf("%d ",b[i+1]=a[i+1]+a[i]);
        }
        System.out.println(b[height-1]=1);
        return b;
    } 
}
//pascal triangle with Memoization
class MemoPascal
{
        private static Map<Integer,Integer> mem=new HashMap<>();
        
        public static int fact(int num)
        {
            if(mem.containsKey(num))
                return mem.get(num);
            if(num==1||num==0)
                return 1;
            int r;
            mem.put(num,r=num*fact(num-1));
            return r;
        }
        public static int getNum(int row,int column)
        {
            row--;
            column--;
            return fact(row)/(fact(row-column)*fact(column));
        }
        public static void prinrPascal(int height)
        {   
            int row,column,colp;
            boolean a=true;
            for(row=1;row<=height;row++)
            {
                a=true;
                colp=1;
                for(column=1;column<height*2;column++)
                    if((column>height-row&&column<height+row)&&a)
                    {
                         System.out.print(getNum(row, colp++));
                         a=false;
                    }
                else
                    {
                        System.out.print(" ");
                        if(a==false)
                            a=true;
                    }
                System.out.print("\n");
            }
        }
        private static Map<Integer,int[]> memo=new HashMap<>();
        public static int[] recpascal(int height)
        {
            /*this function is the extended version of "recpascal function" in RecPascal class 
             only the difference is that it keeps the track of particular row so that it donot have to recalculate
              calculated row again and 
              it maps the row no with the array of values calculated priviousally 
              I know this is not the best way but is just wanted to try
             */
            if(memo.containsKey(height))
            {
                int a[]=memo.get(height);
                for(int k=1;k<=height;k++)
                {
                    a=memo.get(k);
                    for(int i=0;i<k;i++)
                    {
                        System.out.printf("%d ",a[i]);
                    }
                    System.out.print("\n");
                }
        
                return a;
            }
            if(height==1)
            {
                System.out.println(1);
                int a[]=new int[1];
                a[0]=1;
                memo.put(height,a);
                return a;
            }
            int a[]=new int[height-1];
            a=recpascal(height-1);
            int b[]=new int[height];
            
            System.out.printf("%d ",b[0]=1);
            for(int i=0;i<height-2;i++)
            {
                System.out.printf("%d ",b[i+1]=a[i+1]+a[i]);
            }
            System.out.println(b[height-1]=1);
            memo.put(height, b);
            return b;
        } 
}

