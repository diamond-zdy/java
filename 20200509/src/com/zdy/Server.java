package com.zdy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 8080;
    public static void main(String[] args) throws IOException {
        //使用线程池的方式创建socket，支持客户端并发处理
        ExecutorService pool = Executors.newFixedThreadPool(8);
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            while (true){
                Socket socket = serverSocket.accept();
                pool.execute(new TransactionTask(socket));
            }
        }
    }
}
