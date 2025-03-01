package com.easychat.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Map<String, Socket> CLIENT_MAP = new HashMap<>();
        try {
            server = new ServerSocket(8899);
            System.out.println("服务已启动，等待客户端连接");

            while (true) {
                Socket socket = server.accept();
                String ip = socket.getInetAddress().getHostAddress();
                System.out.println("有客户端连接ip:" + ip + "，端口:" + socket.getPort());
                String clientKey = ip + socket.getPort();
                CLIENT_MAP.put(clientKey, socket);

                new Thread(() -> {
                    try {
                        while (true) {
                            InputStream inputStream = socket.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            String readData = bufferedReader.readLine();
                            System.out.println("收到客户端消息->" + readData);

                            CLIENT_MAP.forEach((k, v) -> {
                                try {
                                    OutputStream outputStream = v.getOutputStream();
                                    PrintWriter printWriter = new PrintWriter(outputStream);
                                    printWriter.println(socket.getPort() + "：" + readData);
                                    printWriter.flush();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
