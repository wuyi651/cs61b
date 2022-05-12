public class NBody {
    public static double readRadius(String s){
        In in = new In(s);
        int a=in.readInt();
        double Radius = in.readDouble();
        return Radius;
    }
    public static Planet[] readPlanets(String s){
        In in = new In(s);
        int size=in.readInt();
        in.readDouble();
        Planet[] p=new Planet[size];
        for(int i=0;i<p.length;i++){
            p[i]= new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),
                    in.readDouble(),in.readString());
        }
        return p;
    }

    public static void main(String[] args) {
        double time = 0;

        // Collecting All Needed Input
        double T = Double.valueOf(args[0]), dt = Double.valueOf(args[1]);
        String filename = args[2];
        Planet[] p = readPlanets(filename);

        int numOfp = p.length;

        StdDraw.enableDoubleBuffering();
        double radius = readRadius(filename);
        StdDraw.setScale(- radius, radius);


        while(time < T) {
            // create xForces and yForces arrays
            double[] xForces = new double[numOfp];
            double[] yForces = new double[numOfp];

            // calculate the net x and y forces for each body, store them respectively
            for(int i = 0; i < numOfp; i++) {
                Planet curBody = p[i];
                double curForceX = 0, curForceY = 0;
                for(int j = 0; j < numOfp; j++) {
                    if(j != i) {
                        curForceX += curBody.calcForceExertedByX(p[j]);
                        curForceY += curBody.calcForceExertedByY(p[j]);
                    }

                }
                xForces[i] = curForceX;
                yForces[i] = curForceY;
            }

            // update each body's position, velocity and acceleration
            for(int i = 0; i < numOfp; i++) p[i].update(dt, xForces[i], yForces[i]);


            // Draw the background image.
            StdDraw.picture(1, 1, "images/starfield.jpg", radius * 2, radius * 2);

            // Draw all of the p
            for(Planet body : p) body.draw();

            // show the offscreen buffer
            StdDraw.show();

            // pause the animation for 10 ms
            StdDraw.pause(10);

            // increase time by dt
            time += dt;

        }
        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }


    }
}
