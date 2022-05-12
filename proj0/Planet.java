public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G=6.67e-11;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }
    public double calcDistance(Planet t){
        double squareDis=(t.xxPos-this.xxPos)*(t.xxPos-this.xxPos)+(t.yyPos-this.yyPos)*(t.yyPos-this.yyPos);
        return Math.sqrt(squareDis);
    }
    public double calcForceExertedBy(Planet t){
        double Force=(G*t.mass*this.mass)/(this.calcDistance(t)*this.calcDistance(t));
        return Force;
    }
    public double calcForceExertedByX(Planet t){
        double ForceX= (calcForceExertedBy(t)*(t.xxPos-this.xxPos))/calcDistance(t);
        return ForceX;
    }
    public double calcForceExertedByY(Planet t){
        double ForceY=(calcForceExertedBy(t)*(t.yyPos-this.yyPos))/calcDistance(t);
        return ForceY;
    }
    public double calcNetForceExertedByX(Planet[] t){
        double NetFx=0;
        for(Planet p:t){
            if(p.equals(this)){
                continue;
            }
            NetFx=NetFx+calcForceExertedByX(p);
        }
        return NetFx;
    }
    public double calcNetForceExertedByY(Planet[] t){
        double NetFy=0;
        for(Planet p:t){
            if(p.equals(this)){
                continue;
            }
            NetFy=NetFy+calcForceExertedByY(p);
        }
        return NetFy;
    }
    public void update(double time,double ForceX,double ForceY){
        double ax=ForceX/this.mass;
        double ay=ForceY/this.mass;
        this.xxVel = this.xxVel + time * ax;
        this.yyVel = this.yyVel + time * ay;
        this.xxPos = this.xxPos + time * this.xxVel;
        this.yyPos = this.yyPos + time * this.yyVel;
    }
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }
}
