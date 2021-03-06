package framework.rpc.rpca.client;

import framework.rpc.domain.entity.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @program: draft
 * @description: Rpc客户端
 * @author: atong
 * @create: 2021-01-22 09:54
 */
public class RpcClient {

    public static void main(String[] args) {
        try {
            //1.建立远程连接
            Socket socket = new Socket("127.0.0.1",8888);
            //2.服务端参数
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeLong(1L);
            outputStream.flush();

            //3.接收服务端返回的结果
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) inputStream.readObject();
            String name = user.getName();
            System.out.println("name = " + name);
            System.out.println(user.toString());
            //资源关闭
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
