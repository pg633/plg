#include <bits/stdc++.h>

using namespace std;
#define me(x,y) memset(x,y,sizeof x)
#define MIN(x,y) x < y ? x : y
#define MAX(x,y) x > y ? x : y

typedef long long ll;
typedef unsigned long long ull;

const int maxn = 1e6;
const double INF = 0x3f3f3f3f;
const int MOD = 1e9+7;
const int eps = 1e-8;

const double inf=1e20;
const double pi = acos(-1.0);
const int maxp = 1010;
/**
 * Compares a double to zero
 */
int sgn(double x){
    if(fabs(x) < eps) return 0;
    if(x < 0)return -1;
    else return 1;
}

inline double sqr(double x){return x*x;}


struct Point{
    double x,y;
    Point(){}
    Point(double _x,double _y){x = _x,y = _y;}
    void input(){scanf("%lf%lf",&x,&y);}
    void output(){printf("%.2f %.2f\n",x,y);}
    bool operator == (Point b)const{return sgn(x-b.x) == 0 && sgn(y-b.y) == 0;}
    bool operator < (Point b)const{return sgn(x-b.x) == 0 ? sgn(y-b.y)<0 : x<b.x;}
    Point operator -(const Point &b)const{return Point(x-b.x,y-b.y);}
    /**
     * 叉积
     */
    double operator ^ (const Point &b)const{return x*b.y-y*b.x;}    
    /**
     * 点积
     */
    double operator * (const Point &b)const{return x*b.x+y*b.y;}    
    /**
     * 返回长度
     */
    double len(){return hypot(x,y);}                                
    /**
     * 返回长度平方
     */
    double len2(){return x*x+y*y;}                                  
    /**
     * 返回两点间距离
     */
    double distance(Point p){return hypot(x-p.x,y-p.y);}            
    Point operator + (const Point &b)const{return Point(x+b.x,y+b.y);}
    Point operator * (const double &k)const{return Point(x*k,y*k);} 
    Point operator / (const double &k)const{return Point(x/k,y/k);} 
    /**
     * 计算该点看a,b点的角度
     */
    double rad(Point a,Point b){Point p = *this;return fabs(atan2(fabs((a-p)^(b-p)),(a-p)*(b-p)));}
    /**
     * 化为长度为r的向量
     */
    Point trunc(double r){  
        double l = len();
        if(!sgn(l)) return *this;
        r /= l;
        return Point(x*r,y*r);    
    }
    /**
     * 逆时针转90度
     */
    Point rotleft(){return Point(-y,x);}                             
    /**
     * 顺时针转90度
     */
    Point rotright(){return Point(y,-x);}                            
    /**
     * 绕p点逆时针转angle
     */
    Point rotate(Point p,double angle){                              
        Point v = (*this)-p;
        double c = cos(angle),s = sin(angle);
        return Point(p.x+v.x*c-v.y*s,p.y+v.x*s+v.y*c);
    }
};

struct Line{
    Point s,e;
    Line(){}
    Line(Point _s,Point _e){s = _s;e = _e;}
    bool operator == (Line v){return (s == v.s) && (e == v.e);}
    /**
     * 根据一个点和倾斜角angle确定直线，0<=angle<=pi
     */
    Line(Point p,double angle){                                     
        s = p;
        if(sgn(angle-pi/2) == 0){e = (s+Point(0,1));}
        else{e = (s+Point(1,tan(angle)));}
    }
    /**
     * ax+by+c=0
     */
    Line(double a,double b,double c){                               
        if(sgn(a) == 0){s = Point(0,-c/b);e=Point(1,-c/b);}
        else if(sgn(b) == 0){s = Point(-c/a,0);e = Point(-c/a,1);}
        else{s = Point(0,-c/b);e = Point(1,(-c-a)/b);}
    }
    void input(){s.input();e.input();}                              
    void adjust(){if(e < s) swap(s,e);}
    /**
     * 求线段长度
     */
    double length(){return s.distance(e);}                          
    /**
     * 返回直线倾斜角0<=angle<=pi
     */
    double angle(){                                                 
        double k = atan2(e.y-s.y,e.x-s.x);
        if(sgn(k)<0) k+=pi;
        if(sgn(k-pi)==0) k-= pi;
        return k;
    }
    /**
     * 点和直线的关系
     * 1在左侧
     * 2在右侧
     * 3在直线上
     */
    int relation(Point p){                                          
        int c = sgn((p-s)^(e-s));
        if(c < 0)return 1;
        else if(c > 0) return 2;
        else return 3;
    }
    /**
     * 点在线段上的判断
     */
    bool  pointonseg(Point p){return sgn((p-s)^(e-s)) == 0 && sgn((p-s)^(e-s)) <= 0;}   
    /**
     * 两向量平行（对应直线平行或重合）
     */
    bool parallel(Line v){return sgn((e-s)^(v.e-v.s)) == 0;}        
    /**
     * 两线段相交判断
     * 2规范相交
     * 1非规范相交
     * 0不相交
     */
    int segcrosseg(Line v){                                         
        int d1 = sgn((e-s)^(v.s-s));
        int d2 = sgn((e-s)^(v.e-s));
        int d3 = sgn((v.e-v.s)^(s-v.s));
        int d4 = sgn((v.e-v.s)^(e-v.s));
        if((d1^d2) == -2 && (d3^d4) == -2)return 2;
        return (d1 == 0 && sgn((v.s-s)*(v.s-e)) <= 0) || 
               (d2 == 0 && sgn((v.e-s)*(v.e-e)) <= 0) ||
               (d3 == 0 && sgn((s-v.s)*(s-v.e)) <= 0) ||
               (d4 == 0 && sgn((e-v.s)*(e-v.e)) <= 0);
    }
    /**
     * 直线和线段相交判断
     * 2规范相交
     * 1非规范相交
     * 0不相交
     */
    int linecrossseg(Line v){                                       
        int d1 = sgn((e-s)^(v.s-s));
        int d2 = sgn((e-s)^(v.e-s));
        if((d1^d2) == -2) return 2;
        return (d1 == 0 || d2 == 0);
    }
    /**
     * 两直线关系
     * 0平行
     * 1重合
     * 2相交
     */
    int linecrossline(Line v){                                      
        if((*this).parallel(v)) return v.relation(s) == 3;
        return 2;
    }
    /**
     * 求两直线焦点，要保证两直线不平行或重合
     */
    Point crosspoint(Line v){                                       
        double a1 = (v.e-v.s)^(s-v.s);
        double a2 = (v.e-v.s)^(e-v.s);
        return Point((s.x*a2-e.x*a1)/(a2-a1),(s.y*a2-e.y*a1)/(a2-a1));
    }
    /**
     * 点到直线的距离
     */
    double dispointtoline(Point p){return fabs((p-s)^(e-s))/length();}  
    /**
     * 点到线段的距离
     */
    double dispointtoseg(Point p){                                  
        if(sgn((p-s)*(e-s)) < 0 || sgn((p-e)*(s-e)) < 0)
            return min(p.distance(s),p.distance(e));
        return dispointtoline(p);
    }
    /**
     * 线段到线段的距离，前提是两线段不相交，相交距离为0
     */
    double dissegtoseg(Line v){                                     
        return min(min(dispointtoseg(v.s),dispointtoseg(v.e)),min(v.dispointtoseg(s),v.dispointtoseg(e)));
    }
    /**
     * 返回点p在直线上的投影
     */
    Point lineprog(Point p){return s+(((e-s)*((e-s)*(p-s)))/((e-s).len2()));}   
    /**
     * 返回点p关于直线的对称点
     */
    Point symmetypoint(Point p){Point q = lineprog(p);return Point(2*q.x-p.x,2*q.y-p.y);}   
};

//圆
struct  circle
{
    Point p;
    double r;
    circle(){}
    circle(Point _p,double _r){p = _p;r = _r;}
    circle(double x,double y,double _r){p = Point(x,y);r = _r;}
    /**
     * 三角形外接圆，需要Point的+/rotate()以及line的crosspoint()。利用两边中垂线得圆心
     */
    circle(Point a,Point b,Point c){                                 
        Line u = Line((a+b)/2,((a+b)/2)+((b-a).rotleft()));
        Line v = Line((b+c)/2,((b+c)/2)+((c-b).rotleft()));
        p = u.crosspoint(v);
        r = p.distance(a);
    }
    /**
     * 三角形内切圆,参数bool t无作用，只是与外接圆区别  
     */
    circle(Point a,Point b,Point c,bool t){                          
        Line u,v;
        double m = atan2(b.y-a.y,b.x-a.x),n = atan2(c.y-a.y,c.x-a.x);
        u.s = a,v.s = b;
        u.e = u.s+Point(cos((n+m)/2),sin((n+m)/2));
        m = atan2(a.y-b.y,a.x-b.x),n = atan2(c.y-b.y,c.x-b.x);
        v.e = v.s+Point(cos((n+m)/2),sin((n+m)/2));
        p = u.crosspoint(v);
        r = Line(a,b).dispointtoseg(p);
    }
    void input(){p.input();scanf("%lf",&r);}
    void output(){printf("%.2lf %.2lf %.2lf\n",p.x,p.y,r);}
    bool operator == (circle v)const{return (p==v.p) && sgn(r-v.r) == 0;}
    bool operator < (circle v)const{return ((p<v.p) || ((p==v.p) && sgn(r-v.r) < 0));}
    /**
     * 返回面积
     */
    double area(){return pi*r*r;}                                

    /**
     * 返回周长
     */
    double circumference(){return 2*pi*r;}                      

    /**
     * 点和圆的关系，0圆外，1圆上，2圆内
     */
    int relation(Point b){                                           

        double dst = b.distance(p);
        if(sgn(dst-r) < 0)return 2;
        else if(sgn(dst-r) == 0)return 1;
        else return 0;
    }
    /**
     * 线段和圆的关系，比较的是圆心到线段的距离和半径的关系
     */
    int relationseg(Line v){                                          

        double dst = v.dispointtoseg(p);
        if(sgn(dst-r) < 0)return 2;
        else if(sgn(dst-r) == 0)return 1;
        else return 0;
    }
    /**
     * 直线和圆的关系，比较的是圆心到线段的距离和半径的关系
     */
    int relationline(Line v){                                         

        double dst = v.dispointtoline(p);
        if(sgn(dst-r) < 0)return 2;
        else if(sgn(dst-r) == 0)return 1;
        else return 0;
    }
    /**
     * 两圆关系
     * 5相离
     * 4外切
     * 3相交
     * 2内切
     * 1内含
     */
    int relationcircle(circle v){                                   

        double d = p.distance(v.p);
        if(sgn(d-r-v.r) > 0)return 5;
        if(sgn(d-r-v.r) == 0)return 4;
        double l = fabs(r-v.r);
        if(sgn(d-r-v.r)<0 && sgn(d-l)>0)return 3;
        if(sgn(d-l) == 0)return 2;
        if(sgn(d-l) < 0)return 1;
    }
    /**
    *求两圆交点
    *0是无交点
    *1是一个交点
    *2是两个
     */
    int pointcrosscircle(circle v,Point &p1,Point &p2){              
        int rel = relationcircle(v);
        if(rel == 1 || rel == 5)return 0;
        double d = p.distance(v.p);
        double l = (d*d+r*r-v.r*v.r)/(2*d);
        double h = sqrt(r*r-l*l);
        Point tmp = p + (v.p-p).trunc(l);
        p1 = tmp + ((v.p-p).rotleft().trunc(h));
        p2 = tmp + ((v.p-p).rotright().trunc(h));
        if(rel == 2 || rel == 4)
            return 1;
        return 2;
    }
};

struct polygon{
    int n;
    Point p[maxp];
    Line l[maxp];
    void input(int _n){
        n = _n;
        for(int i = 0; i < n; ++i) p[i].input();
    }
    void add(Point q){p[n++] = q;}
    void getline(){
        for(int i = 0; i < n; ++i){
            l[i] = Line(p[i],p[(i+1)%n]);
        }
    }
    struct cmp{
        Point p;
        cmp(const Point &p0){p = p0;}
        bool operator()(const Point &aa,const Point &bb){
            Point a = aa,b = bb;
            int d = sgn((a-p)^(b-p));
            if(d == 0) return sgn(a.distance(p)-b.distance(p))<0;
            return d > 0;
        }
    };
    /**
     * 进行极角排序，首先找到最左下角的点
     */
    void norm(){  
        Point mi = p[0];
        for(int i = 1; i < n; ++i) mi = min(mi,p[i]);
        sort(p,p+n,cmp(mi));
    }
    /**
     * 得到重心
     */
    Point getbarycentre(){                       
        Point ret(0,0);
        double area = 0;
        for(int i = 1; i < n-1; ++i){
            double tmp = (p[i]-p[0])^(p[i+1]-p[0]);
            if(sgn(tmp) == 0) continue;
            area += tmp;
            ret.x += (p[0].x+p[i].x+p[i+1].x)/3*tmp;
            ret.y += (p[0].y+p[i].y+p[i+1].y)/3*tmp;
        }
        if(sgn(area)) ret = ret/area;
        return ret;
    }
    /**
     * 得到凸包，
     * 内部点编号为0-n-1，
     * 如果有影响判断所有点共点或共线
     * 另外注意是否需要点的顺序为逆时针，不需要可以将norm注释掉，有时候排序过程会导致RE
     */
	void getconvex(polygon &convex){                

        sort(p,p+n);
        convex.n = n;
        for(int i = 0;i < min(n,2); ++i)convex.p[i] = p[i];
        if(convex.n == 2 && (convex.p[0] == convex.p[1]))convex.n--;
        if(n <= 2)return ;
        int &top = convex.n;
        top = 1;
        for(int i = 2; i <n ; ++i){
            while(top && sgn((convex.p[top]-p[i])^(convex.p[top-1]-p[i])) <= 0){top--;}
            convex.p[++top] = p[i];
        }
        int temp = top;
        convex.p[++top] = p[n-2];
        for(int i = n-3; i >= 0; i--){
            while(top != temp && sgn((convex.p[top]-p[i])^(convex.p[top-1]-p[i])) <= 0)top--;
            convex.p[++top] = p[i];
        }
        if(convex.n == 2 && (convex.p[0] == convex.p[1]))convex.n--;
        // convex.norm();   //原本得到的是顺时针方向的点，排序后变为逆时针
    }
    /**
     * 得到凸包的另一种方法
     */
    void Graham(polygon &convex){
        norm();
        int &top = convex.n;
        top=0;
        if(n == 1){
            top=1;
            convex.p[0]=p[0];
            return ;
        }
        if(n == 2){
            top=2;
            convex.p[0]=p[0];
            convex.p[1]=p[1];
            if(convex.p[0]==convex.p[1]) top--;
            return ;
        }
        convex.p[0] = p[0];
        convex.p[1] = p[1];
        top=2;
        for(int i = 2; i < n; ++i){
            while(top > 1 && sgn((convex.p[top-1] - convex.p[top-2]) ^ (p[i]-convex.p[top-2])) <= 0) top--;
            convex.p[top++] = p[i];
        }
        if(convex.n == 2 && (convex.p[0] == convex.p[1])) convex.n--;
    }
    /**
     * 判断是不是凸的
     */
    bool isconvex(){
        bool s[2];
        memset(s,false,sizeof s);
        for(int i = 0; i < n; ++i){
            int j = (i+1)%n;
            int k = (j+1)%n;
            s[sgn((p[j]-p[i])^(p[k]-p[i]))+1] = true;
            if(s[0] && s[1]) return false;
        }
        return true;
    }
    /**
     * 判断点和任意多边形的关系
     * ３点上
     * ２边上
     * １内部
     * ０外部
     */
    int relationpoint(Point q){
        for(int i = 0; i < n; ++i){
            if(p[i] == q) return 3;
        }
        getline();
        for(int i = 0; i < n; ++i){
            if(l[i].pointonseg(q)) return 2;
        }
        int cnt = 0;
        for(int i = 0; i < n; ++i){
            int j = (i+1)%n;
            int k = sgn((q-p[j])^(p[i]-p[j]));
            int u = sgn(p[i].y-q.y);
            int v = sgn(p[j].y-q.y);
            if(k > 0 && u < 0 && v >= 0) cnt++;
            if(k < 0 && v < 0 && u >= 0) cnt--;
        }
        return cnt!=0;
    }
    /**
     * 得到周长
     */
    double getcircumference(){
        double sum=0;
        for(int i = 0; i < n; ++i){
            sum += p[i].distance(p[(i+1)%n]);
        }
        return sum;
    }
    /**
     * 得到面积
     */
    double getarea(){
        double sum=0;
        for(int i = 0; i < n; ++i){
            sum += (p[i]^p[(i+1)%n]);
        }
        return fabs(sum)/2;
    }
    /**
     * 判断两凸包相交
     */
    bool ConvexHullIntersection(polygon convex){
        for(int i = 0; i < convex.n; ++i){
            if(relationpoint(convex.p[i])) return true;
        }
        for(int i = 0; i < n; ++i){
            if(convex.relationpoint(p[i])) return true;
        }
        getline();
        convex.getline();
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < convex.n; ++j){
                if(l[i].segcrosseg(convex.l[j])) return true;
            }
        }
        return false;
    }
};

/**
 * AxB
 */
double cross(Point A,Point B,Point C){
    return (B-A)^(C-A);
}
/**
 * AB*AC
 */
double dot(Point A,Point B,Point C){
    return (B-A)*(C-A);
}

/**
 * 最小矩形面积覆盖
 * A必须是凸包（而且是逆时针顺序
 */
double minRectanglecover(polygon A){
    if(A.n < 3) return 0.0;
    A.p[A.n]=A.p[0];
    double ans=-1;
    int r=1,p=1,q;
    for(int i = 0; i < A.n; ++i){
        //卡出离边A.p[i]-A.p[i+1]最远的点
        while(sgn(cross(A.p[i],A.p[i+1],A.p[r+1]) -cross(A.p[i],A.p[i+1],A.p[r])) >= 0) r=(r+1)%A.n;
        //卡出A.p[i]-A.p[i+1]方向上正向最远点
        while(sgn(dot(A.p[i],A.p[i+1],A.p[p+1]) -dot(A.p[i],A.p[i+1],A.p[p])) >= 0) p=(p+1)%A.n;
        if(i == 0) q=p;
        //卡出A.p[i]-A.p[i+1]方向上负向最远点
        while(sgn(dot(A.p[i],A.p[i+1],A.p[q+1]) -dot(A.p[i],A.p[i+1],A.p[q])) <= 0) q=(q+1)%A.n;
        double d=(A.p[i]-A.p[i+1]).len2();
        double tmp = cross(A.p[i],A.p[i+1],A.p[r])*(dot(A.p[i],A.p[i+1],A.p[p])-dot(A.p[i],A.p[i+1],A.p[q]))/d;
        if(ans < 0 || ans > tmp) ans=tmp;
    }
    return ans;
}
//半平面交
struct halfplane:public Line{
    double angle;
    halfplane(){}
    //表示向量 s->e 逆时针 (左侧) 的半平面
    halfplane(Point _s,Point _e){
        s = _s;
        e = _e;
    }
    halfplane(Line v){
        s = v.s;
        e = v.e;
    }
    void calcangle(){
        angle = atan2(e.y-s.y,e.x-s.x);
    }
    bool operator <(const halfplane &b)const{
        return angle < b.angle;
    }
};
struct halfplanes{
    int n;
    halfplane hp[maxp];
    Point p[maxp];
    int que[maxp];
    int st,ed;
    void push(halfplane tmp){
        hp[n++] = tmp;
    }
    //去重
    void unique(){
        int m = 1;
        for(int i = 1;i < n;i++){
            if(sgn(hp[i].angle-hp[i-1].angle) != 0)
                hp[m++] = hp[i];
            else if(sgn( (hp[m-1].e-hp[m-1].s)^(hp[i].s-hp[m-1].s)) > 0)
                hp[m-1] = hp[i];
        }
        n = m;
    }
    bool halfplaneinsert(){
        for(int i = 0;i < n;i++)hp[i].calcangle();
        sort(hp,hp+n);
        unique();
        que[st=0] = 0;
        que[ed=1] = 1;
        p[1] = hp[0].crosspoint(hp[1]);
        for(int i = 2;i < n;i++){
            while(st<ed && sgn((hp[i].e-hp[i].s)^(p[ed]-hp[i].s))<0)ed--;
            while(st<ed && sgn((hp[i].e-hp[i].s)^(p[st+1]-hp[i].s))<0)st++;
            que[++ed] = i;
            if(hp[i].parallel(hp[que[ed-1]])) return false;
            p[ed]=hp[i].crosspoint(hp[que[ed-1]]);
        }
        while(st<ed && sgn((hp[que[st]].e-hp[que[st]].s)^(p[ed]-hp[que[st]].s))<0)ed--;
        while(st<ed && sgn((hp[que[ed]].e-hp[que[ed]].s)^(p[st+1]-hp[que[ed]].s))<0)st++;
        if(st+1>=ed)return false;
        return true;
    }
    //得到最后半平面交得到的凸多边形
    //需要先调用 halfplaneinsert() 且返回 true
    void getconvex(polygon &con){
        p[st] = hp[que[st]].crosspoint(hp[que[ed]]);
        con.n = ed-st+1;
        for(int j = st,i = 0;j <= ed;i++,j++)
            con.p[i] = p[j];
    }
};
