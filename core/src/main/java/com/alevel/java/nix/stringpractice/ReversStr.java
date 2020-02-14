package com.alevel.java.nix.stringpractice;

public class ReversStr{
    CharSequence ch;

    ReversStr(CharSequence  ch){
        this.ch=ch;
    }
    ReversStr(){
        this.ch="abcd";
    }

   public CharSequence reverse(){
        CharSequence subch= new StringBuilder(ch).reverse().toString();
       System.out.println(subch);
       return subch;
    }

    public static void main(String[] args) {
        ReversStr s=new ReversStr();
       CharSequence str= s.reverse();
        ReversStr s1=new ReversStr("Hello World");
         str= s1.reverse();

        System.out.println(str);
    }

}
