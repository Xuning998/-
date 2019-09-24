public abstract class INoodles {
 public abstract void desc();
}
public class LzNoodles extends INoodles {
  public void desc() {
 System.out.println("兰州拉面  上海的好贵 家里的 才五六块一碗");
}
}

public class PaoNoodles extends INoodles {
public void desc(){
 System.out.println("泡面好吃，不要贪杯");
}
}

 public class GankouNoodles extends INoodles{
public void desc(){
  System.out.println("还是家里的干扣面好吃 六块一碗");
}
}
public class SimpleNoodlesFactory{
public static final int TYPE_LZ=1;
public static final int TYPE_PM=2;
public static final int TYPE_GK=3;
public static INoodles createNoodles(int type) {
switch (type) {
 case TYPE_LZ:
return new LzNoodles();
case TYPE_PM:
 return new PaoNoodles();
case TYPE_Gk:
 default:
 return new GankouNoodles();
}
}
}
INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_GK);
noodles.desc();