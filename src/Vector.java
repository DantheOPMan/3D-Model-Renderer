public class Vector {
    double x = 0, y = 0, z = 0;
    double length;
    Vector(double x, double y, double z){

        length = Math.sqrt((x*x)+ (y*y) + (z*z));
        if(length>0){
            this.x = x/length;
            this.y = y/length;
            this.z = z/length;  
        }
        

    }

    Vector crossProduct(Vector v){

        Vector crossed = new Vector(
            (v.z * this.y)-(v.y * this.z),
            -1*(v.z * this.x)-(v.x * this.z),
            (v.y * this.x)-(v.x * this.y)
            );
        return crossed;
    }


}
