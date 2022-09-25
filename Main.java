class Main {
    public static void main(String[] args) {
      
      Figure c = new Circle (5);
      Figure t = new Triangle (3,4,5);
      Cylinder cyl =  new Cylinder (10,c);
      Cylinder tr =  new Cylinder (100,t);

   
      System.out.println("square of circle: ");
      System.out.println(c.CalcSquare());
      System.out.println("square of triangle: ");
      System.out.println(t.CalcSquare());

      System.out.println("volume of circled cylinder: ");
      System.out.println(cyl.CalcVolume());
      System.out.println("volume of triangled cylinder: ");
      System.out.println(tr.CalcVolume());
     
    }
}

interface Figure {

   double CalcSquare();
   Figure Clone();

}

class Circle implements Figure {
   private double r;

        
   public Circle(double new_r) {
      r = new_r;
   }

   public double CalcSquare() {
      return Math.PI * (r * r);
   }


   public Figure Clone() {
      return new Circle(r);
   }

   public double Get_R() {
      return r;
   }
    
}

class Triangle implements Figure {

    private double A;

    private double B;

    private double C;
   

    private boolean TestMySides(double a, double b, double c) {
      if ( c<=a+b && a<=b+c && b<=c+a && a > 0 && b > 0 && c > 0){
        return true;
      }
      else {
        return false;
      }   
    }

    private double CalcPer() {
       return (A + B + C) / 2;
    }

    public Triangle(double a ,double b ,double c ) {
      if (TestMySides(a,b,c)) {
         A = a;
         B = b;
         C = c; 
      } else {
         return ;
        }

   }
   
        public double CalcSquare() {
           double p = CalcPer();
           
	      return  Math.sqrt(p * (p - A) * (p - B) * (p - C));
         
        }

        public Figure Clone() {
           return new Triangle(A,B,C);

        }

        public void Set_Sides(double a, double b, double c) {

          A = a;
          B = b;
          C = c;

        }

        public double Get_A() {
           return A;
        }

        public double Get_B() {
           return B;
        }

        public double Get_C() {
           return C;
        }
}


class Cylinder {

   private double h;
   private Figure base;

   public Cylinder(double new_h, Figure new_base){
      h = new_h;
      base = new_base;
   }

   double CalcVolume() {
      return h * base.CalcSquare();
   }

}