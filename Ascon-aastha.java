import java.io.*;
public class Ascon-aastha { 
public static void permutation(byte S[], int rounds) {

  long x0 = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0;
  long t0, t1, t2, t3, t4;

  x0 = Arrays.copyOfRange(S, 0, 8);
  x1 = Arrays.copyOfRange(S, 8, 16);
  x2 = Arrays.copyOfRange(S, 16, 24);
  x3 = Arrays.copyOfRange(S, 24, 32);
  x4 = Arrays.copyOfRange(S, 32, 40);

  for (int i = 0; i < rounds; ++i) {
    // addition of round constant
    x2 ^= (((long) (0xf) - i) << 4) | i;
    // substitution layer
    x0 ^= x4;    x4 ^= x3;    x2 ^= x1;
    t0  = x0;    t1  = x1;    t2  = x2;    t3  = x3;    t4  = x4;
    t0 =~ t0;    t1 =~ t1;    t2 =~ t2;    t3 =~ t3;    t4 =~ t4;
    t0 &= x1;    t1 &= x2;    t2 &= x3;    t3 &= x4;    t4 &= x0;
    x0 ^= t1;    x1 ^= t2;    x2 ^= t3;    x3 ^= t4;    x4 ^= t0;
    x1 ^= x0;    x0 ^= x4;    x3 ^= x2;    x2 =~ x2;
    // linear diffusion layer
    x0 ^= rotate(x0, 19) ^ rotate(x0, 28);
    x1 ^= rotate(x1, 61) ^ rotate(x1, 39);
    x2 ^= rotate(x2, 1) ^ rotate(x2, 6);
    x3 ^= rotate(x3, 10) ^ rotate(x3, 17);
    x4 ^= rotate(x4, 7) ^ rotate(x4, 41);
  }

  System.out.println(x0);
  System.out.println(x1);
  System.out.println(x2);
  System.out.println(x3);
  System.out.println(x4);
}
public static long rotate(long x, int n) {
  return Long.rotateRight(x, n);
}

public static void main(String args[]) throws IOException {
    permutation(, 12);
}

}