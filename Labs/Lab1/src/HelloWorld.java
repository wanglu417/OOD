
//This class represents a 3D Vector,which has x,y,z components
public class Vector3D {
    private double x;
    private double y;
    private double z;

    //A constructor that takes in x, y, z components of the vector
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //A getter method that returns the information of an object
    public double getX() {
        return this.x;
    }

    //A getter method that returns the information of an object
    public double getY() {
        return this.y;
    }

    //A getter method that returns the information of an object
    public double getZ() {
        return this.z;
    }

    //A toString method that returns a string that describes this vector
    @Override
    public String toString(){
        String vx = String.format("%.2f",this.x);
        String vy = String.format("%.2f",this.y);
        String vz = String.format("%.2f",this.z);
        return ("(" + vx +"," + vy + "," +vz +")");
    }

    //A method getMagnitude that returns its magnitude
    public double getMagnitude(){
        double mag = Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2);
        return(Math.sqrt(mag));
    }

    //A method normalize that returns a normalized version of this vector
    public Vector3D normalize(){
        double mag1 = getMagnitude();
        double vx = this.x/mag1;
        double vy = this.y/mag1;
        double vz = this.z/mag1;
        return new Vector3D(vx,vy,vz);
    }

    //A method add that returns the result of adding this vector to another vector
    public Vector3D add(Vector3D b){
        double vx,vy,vz;
        vx= this.x+b.x;
        vy= this.y+b.y;
        vz= this.z+b.z;
        return new Vector3D(vx, vy, vz);
    }

    //A method multiply that returns the result of multiplying this vector by a constant
    public Vector3D multiply(double n){
        double vx,vy,vz;
        vx= this.x*n;
        vy= this.y*n;
        vz= this.z*n;
        return new Vector3D(vx,vy,vz);
    }

    //A method dotProduct that returns the dot product of this vector and another vector
    public double dotProduct(Vector3D w){
        double vx,vy,vz;
        vx = this.x * w.x;
        vy = this.y * w.y;
        vz = this.z * w.z;
        return vx + vy + vz;
    }

    //A method angleBetween that returns the angle between two vectors in degrees
    public double angleBetween(Vector3D w){
        double product1 = this.x*w.x + this.y*w.y +this.z*w.z;
        double product2 = this.getMagnitude()* w.getMagnitude();
        double result = product1/product2;
        return Math.acos(result);
    }

    //Main class
    public static void main() {
        Vector3D v1 = new Vector3D(3,4,10);
        Vector3D v2 = new Vector3D(7,8,30);
        System.out.println("\nVector 1 : "+v1.toString());
        System.out.println("\nVector 1 : "+v2.toString());
        System.out.println("\nThe magnitude of vector v1 : "+String.format("%.2f",v1.getMagnitude()));
        System.out.println("\nThe magnitude of vector v2 : "+String.format("%.2f",v2.getMagnitude()));
        System.out.println("\nThe normalized version of v1 : "+v1.normalize());
        System.out.println("\nThe normalized version of v2 : "+v2.normalize());
        System.out.println("\nThe result of adding v1 and v2 is : "+v1.add(v2));
        System.out.println("\nThe vector v1 multiplied by constant 10 : "+v1.multiply(10));
        System.out.println("\nThe Dot product of v1 and v2 : "+String.format("%.2f",v1.dotProduct(v2)));
        System.out.println("\nThe angle between v1 and v2 : "+String.format("%.2f",v1.angleBetween(v2)));
    }
}

