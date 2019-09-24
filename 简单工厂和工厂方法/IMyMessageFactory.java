package com.demoFound.factoryMethod.factory;  
  
import com.demoFound.factoryMethod.message.IMyMessage;  
  
public interface IMyMessageFactory {  
  
    public IMyMessage createMessage(String messageType);  
}  
package com.demoFound.factoryMethod.factory;  
  
import java.util.HashMap;  
import java.util.Map;  
  
import com.demoFound.factoryMethod.message.IMyMessage;  
import com.demoFound.factoryMethod.message.MyMessageEmail;  
import com.demoFound.factoryMethod.message.MyMessageOaTodo;  
import com.demoFound.factoryMethod.message.MyMessageSms;  
  
public class MyMessageFactory implements IMyMessageFactory {  
  
    @Override  
    public IMyMessage createMessage(String messageType) {  
        // 这里的方式是：消费者知道自己想要什么产品；若生产何种产品完全由工厂决定，则这里不应该传入控制生产的参数。  
        IMyMessage myMessage;  
        Map<String, Object> messageParam = new HashMap<String, Object>();  
        // 根据某些条件去选择究竟创建哪一个具体的实现对象，条件可以传入的，也可以从其它途径获取。  
        // sms  
        if ("SMS".equals(messageType)) {  
            myMessage = new MyMessageSms();  
            messageParam.put("PHONENUM", "123456789");  
        } else  
        // OA待办  
        if ("OA".equals(messageType)) {  
            myMessage = new MyMessageOaTodo();  
            messageParam.put("OAUSERNAME", "testUser");  
        } else  
        // email  
        if ("EMAIL".equals(messageType)) {  
            myMessage = new MyMessageEmail();  
            messageParam.put("EMAIL", "test@test.com");  
        } else  
        // 默认生产email这个产品  
        {  
            myMessage = new MyMessageEmail();  
            messageParam.put("EMAIL", "test@test.com");  
        }  
        myMessage.setMessageParam(messageParam);  
        return myMessage;  
    }  
} 
package com.demoFound.factoryMethod.message;  
  
import java.util.Map;  
  

public interface IMyMessage {  
  
    public Map<String, Object> getMessageParam();  
  
    public void setMessageParam(Map<String, Object> messageParam);  
  
    public void sendMesage() throws Exception;// 发送通知/消息  
  
}  
package com.demoFound.factoryMethod.message;  
  
import java.util.Map;  
  

public abstract class MyAbstractMessage implements IMyMessage {  
  
    private Map<String, Object> messageParam;// 这里可以理解为生产产品所需要的原材料库。最好是个自定义的对象，这里为了不引起误解使用Map。  
  
    
    public Map<String, Object> getMessageParam() {  
        return messageParam;  
    }  
  
      
    public void setMessageParam(Map<String, Object> messageParam) {  
        this.messageParam = messageParam;  
    }  
}  
package com.demoFound.factoryMethod.message;  
  
public class MyMessageEmail extends MyAbstractMessage {  
  
   
    public void sendMesage() throws Exception {  
        // TODO Auto-generated method stub  
        if (null == getMessageParam() || null == getMessageParam().get("EMAIL")  
                || "".equals(getMessageParam().get("EMAIL"))) {  
            throw new Exception("发送短信,需要传入EMAIL参数");// 为了简单起见异常也不自定义了  
        }// 另外邮件内容，以及其他各种协议参数等等都要处理  
  
        System.out.println("我是邮件，发送通知给" + getMessageParam().get("EMAIL"));  
    }  
  
}  
package com.demoFound.factoryMethod.message;  
  
/** 
 * 工厂方法模式_oa待办产品 
 *  
 * @author popkidorc 
 *  
 */  
public class MyMessageOaTodo extends MyAbstractMessage {  
  

    public void sendMesage() throws Exception {  
        // TODO Auto-generated method stub  
        if (null == getMessageParam()  
                || null == getMessageParam().get("OAUSERNAME")  
                || "".equals(getMessageParam().get("OAUSERNAME"))) {  
            throw new Exception("发送OA待办,需要传入OAUSERNAME参数");// 为了简单起见异常也不自定义了  
        }// 这里的参数需求就比较多了不一一处理了  
  
        System.out  
                .println("我是OA待办，发送通知给" + getMessageParam().get("OAUSERNAME"));  
    }  
  
}  
package com.demoFound.factoryMethod.message;  

public class MyMessageSms extends MyAbstractMessage {  
  
      
    public void sendMesage() throws Exception {  
        // TODO Auto-generated method stub  
        if (null == getMessageParam()  
                || null == getMessageParam().get("PHONENUM")  
                || "".equals(getMessageParam().get("PHONENUM"))) {  
            throw new Exception("发送短信,需要传入PHONENUM参数");// 为了简单起见异常也不自定义了  
        }// 另外短信信息，以及其他各种协议参数等等都要处理  
  
        System.out.println("我是短信，发送通知给" + getMessageParam().get("PHONENUM"));  
    }  
  
} 
package com.demoFound.factoryMethod;  
  
import com.demoFound.factoryMethod.factory.IMyMessageFactory;  
import com.demoFound.factoryMethod.factory.MyMessageFactory;  
import com.demoFound.factoryMethod.message.IMyMessage;  
  
public class MyFactoryMethodMain {  
  
    public static void main(String[] args) {  
        IMyMessageFactory myMessageFactory = new MyMessageFactory();  
        IMyMessage myMessage;  
        // 对于这个消费者来说，不用知道如何生产message这个产品，耦合度降低  
        try {  
            // 先来一个短信通知  
            myMessage = myMessageFactory.createMessage("SMS");  
            myMessage.sendMesage();  
  
            // 来一个oa待办  
            myMessage = myMessageFactory.createMessage("OA");  
            myMessage.sendMesage();  
  
            // 来一个邮件通知  
            myMessage = myMessageFactory.createMessage("EMAIL");  
            myMessage.sendMesage();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  