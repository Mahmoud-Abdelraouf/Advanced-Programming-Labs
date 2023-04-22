/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssignmentLab05;

/**
 *
 * @author karim
 */




abstract class A { 
    
    public void f1(){ 
        System.out.println("A.f1 called");
    } 
    public final void f2() { 
        System.out.println("A.f2 called");
} 
    public abstract void f3(); 
}

class B extends A { 
    @Override
    public void f1() { 
        super.f1();System.out.println("B.f1 called"); 
    } 
    @Override
   public void f3() { 
        System.out.println("B.f3 called");
   } 
} 

abstract class C extends A { 
    @Override
    public void f1() { 
        super.f1(); 
        System.out.println("C.f1 called"); 
    } 
}

abstract class D extends C { 
    @Override
    public void f3() { 
        System.out.println("D.f3 called");
    } 
} 

final class E extends D { 
} 
class F extends E { 
 public void f3() { 
super.f3();
System.out.println("F.f3 called");} } 
public class Test { 
 public static void main(String[] args) { 
A[] ps = new A[6]; 
ps[0] = new A(); 
ps[1] = new B(); 
ps[2] = new C(); 
ps[3] = new D(); 
ps[4] = new E(); 
ps[5] = new F(); 
 
for (int i = 0; i < ps.length; i++) { 
ps[i].f1(); 
ps[i].f2(); 
ps[i].f3(); 
 } 
 } 
}