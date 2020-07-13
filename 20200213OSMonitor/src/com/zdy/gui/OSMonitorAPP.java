package com.zdy.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//javafx 主程序的要求：
//必须继承 javafx的Application类
//必须覆盖Application类的 start 方法
public class OSMonitorAPP extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //加载 .fxml 文件
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("os_monitor_tab.fxml"));
        //真正的加载
        Parent root = loader.load();
        OSmonitorController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        //创建一个 Scene 对象，也就是场景
        Scene scene = new Scene(root, 800, 600);
        //给Stage 设置标题
        primaryStage.setTitle("OS Monitor");
        //将Scene 添加到 Stage
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest((e) -> controller.shutdown());
        //展示
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
