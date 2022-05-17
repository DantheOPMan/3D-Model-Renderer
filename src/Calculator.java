public class Calculator {
    static double drawX = 0, drawY = 0;
    public static double calculatePositionX(double[] viewFrom, double[] viewTo, double x, double y, double z){

        set(viewFrom,viewTo,x,y,z);
        return drawX;

    }

    public static double calculatePositionY(double[] viewFrom, double[] viewTo, double x, double y, double z){

        set(viewFrom,viewTo,x,y,z);
        return drawY;

    }

    static void set(double[] viewFrom,double[] viewTo, double x, double y, double z){
            
        Vector viewVector = new Vector(viewTo[0]- viewFrom[0], viewTo[1]- viewFrom[1], viewTo[2]- viewFrom[2]);
        Vector directionVector = new Vector(1, 1, 1);
        Vector PlaneVector1 = viewVector.crossProduct(directionVector);
        Vector PlaneVector2 = viewVector.crossProduct(PlaneVector1);

        Vector viewToPoint = new Vector(x-viewFrom[0], y-viewFrom[1], z-viewFrom[2]);

        double t = ((viewVector.x*viewTo[0]+ viewVector.y*viewTo[1] + viewVector.z*viewTo[2]) 
                - (viewVector.x*viewFrom[0]+ viewVector.y*viewFrom[1] + viewVector.z*viewFrom[2]))
                / (viewVector.x*viewToPoint.x+ viewVector.y*viewToPoint.y + viewVector.z*viewToPoint.z);
        
        x = viewFrom[0] + viewToPoint.x * t;
        y = viewFrom[1] + viewToPoint.y * t;
        z = viewFrom[2] + viewToPoint.z * t;

        if(t>0){
            drawX = PlaneVector2.x * x + PlaneVector2.y * y + PlaneVector2.z * z;
            drawY = PlaneVector1.x * x + PlaneVector1.y * y + PlaneVector1.z * z;
        }

    }   
    
}
