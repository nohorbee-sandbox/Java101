class BitwiseOp {
  public static void main(String args[]) {
    short x = 0B0011010101110010;
    short y = 0B0110101011101011;
    
    System.out.println(x & y);
    System.out.println(~x);
    System.out.println(x ^ y);
    System.out.println(x | y);


    System.out.println(123_312+1);

    String arg = "-v";

    switch (arg)
    {
      case "-v":
        System.out.println("version 1.0");

      case "-V":
        System.out.println("Version 1.0");
      case "-d":
        System.out.println("dersion 1.0");

      // ...

      default  : System.out.println("unknown option");
    }


    
    
  }
}