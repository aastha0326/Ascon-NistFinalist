import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	static long state[] = new long[5];
	static long t[] =  new long[5];
	static long constants[] = {0xf0, 0xe1, 0xd2, 0xc3, 0xb4, 0xa5, 0x96, 0x87, 0x78, 0x69, 0x5a, 0x4b, 0x3c, 0x2d, 0x1e, 0x0f};
	public static void main (String[] args) throws java.lang.Exception
	{
		 long nonce[] = new long[2];
  long key[] = new long[2];
  long IV = 0x80400c0600000000l;
  long plainText[] = {0x1234567890abcdefl, 0x82187l};
  long cipherText[] = new long[10];
  state[0] = IV;
  state[1] = key[0];
  state[2] = key[1];
  state[3] = nonce[0];
  state[4] = nonce[1];
  initialization(state, key);
  
  print(state);
  encrypt(state, 2, plainText, cipherText);
  System.out.printf("CipherText: %x %x%n", cipherText[0], cipherText[1]);
  finalization(state, key);
  System.out.printf("Tag: %x %x%n", state[3], state[4]);
	}
	
	public static void permutation(long state[], int rounds) {
  for (int i = 0; i < rounds; ++i) {
    add_constants(state, i, rounds);
    sbox(state);
    linear(state);
  }
  }

public static void add_constants(long state[], int i, int a) {
  state[2] ^= constants[12 - a + i];
}
static long rotate(long x, int l) {
  long temp;
  temp = (x >> 1) ^ (x << (64-l));
  return temp;
}

static void sbox(long x[]) {
  x[0] ^= x[4]; x[4] ^= x[3]; x[2] ^= x[1];
  t[0] = x[0]; t[1] = x[1]; t[2] = x[2]; t[3] = x[3]; t[4] = x[4];
  t[0] =~ t[0]; t[1] =~ t[1]; t[2] =~ t[2]; t[3] =~ t[3]; t[4] =~ t[4];
  t[0] &= x[1]; t[1] &= x[2]; t[2] &= x[3]; t[3] &= x[4]; t[4] &= x[0];
  x[0] ^= t[1]; x[1] ^= t[2]; x[2] ^= t[3]; x[3] ^= t[4]; x[4] ^= t[0];
  x[1] ^= x[0]; x[0] ^= x[4]; x[3] ^= x[2]; x[2] =~ x[2];
}

static void linear(long state[]) {
	 long temp0, temp1;
  temp0 = rotate(state[0], 19);
  temp1 = rotate(state[0], 28);
  state[0] ^= temp0 ^ temp1;
  temp0 = rotate(state[1], 61);
  temp1 = rotate(state[1], 39);
  state[1] ^= temp0 ^ temp1;
  temp0 = rotate(state[2], 1);
  temp1 = rotate(state[2], 6);
  state[2] ^= temp0 ^ temp1;
  temp0 = rotate(state[3], 10);
  temp1 = rotate(state[3], 17);
  state[3] ^= temp0 ^ temp1;
  temp0 = rotate(state[4], 7);
  temp1 = rotate(state[4], 41);
  state[4] ^= temp0 ^ temp1;
}


static void initialization(long state[], long key[]) {
  permutation(state, 12);
  state[3] ^= key[0];
  state[4] ^= key[1];

}

static void encrypt(long state[], int length, long plainText[], long cipherText[]) {
  cipherText[0] = plainText[0] ^ state[0];
  for(int i = 1; i < length; ++i) {
    permutation(state, 6);
    cipherText[i] = plainText[i] ^ state[0];
    state[0] = cipherText[i];
  }
}

static void print(long state[]) {
  for(int i = 0; i < 5; ++i) {
    System.out.printf("state %x%n", state[i]);
  }
}
static void finalization(long state[], long key[]) {
	 state[0] ^= key[0];
  state[1] ^= key[1];
  permutation(state,12);
}
}
